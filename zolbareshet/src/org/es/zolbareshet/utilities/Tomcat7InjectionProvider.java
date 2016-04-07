package org.es.zolbareshet.utilities;

/**
 * Created by eilons on 3/27/2016.
 */



import com.sun.faces.spi.DiscoverableInjectionProvider;
import com.sun.faces.spi.InjectionProviderException;
import com.sun.faces.vendor.WebContainerInjectionProvider;
import org.es.zolbareshet.logging.Logger;
import org.es.zolbareshet.logging.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import org.es.zolbareshet.logging.MainLogger;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;

//so we can use the @Resource annotation - this is class is currently not in use
public class Tomcat7InjectionProvider extends DiscoverableInjectionProvider
{
    private Logger logger = LoggerFactory.getLogger();
    private ServletContext  servletContext;

    private WebContainerInjectionProvider delegate = new WebContainerInjectionProvider();

    public Tomcat7InjectionProvider(ServletContext servletContext)
    {
        logger.log(MainLogger.LEVEL.INFO,"constructed");
        this.servletContext = servletContext;
    }

    @Override
    public void inject(Object managedBean) throws InjectionProviderException
    {
        Class<?> clazz = managedBean.getClass();
        do
        {
            List<Resource> classResources = new LinkedList<>();
            // Process class-level @Resources and @Resource
            if (clazz.isAnnotationPresent(Resources.class))
            {
                Resources annotation = clazz.getAnnotation(Resources.class);
                for (Resource resource : annotation.value())
                {
                    classResources.add(resource);
                }
            }
            if (clazz.isAnnotationPresent(Resource.class))
            {
                Resource    annotation = clazz.getAnnotation(Resource.class);
                classResources.add(annotation);
            }
            for (Resource annotation : classResources)
            {
                String  name = annotation.name();
                // Make sure the resource exists.
                try
                {
                    Context ctx = new InitialContext();
                    Object resource = ctx.lookup("java:comp/env/" + name);
                }
                catch (NamingException exc)
                {
                    throw new InjectionProviderException("checking class resource " + annotation.name()+" of "+clazz.getName(), exc);
                }
            }
            // Process fields with @Resource
            // see org.apache.catalina.core.DefaultInstanceManager
//            Field[] fields = Introspection.getDeclaredFields(managedBean.getClass());
            Field[] fields = managedBean.getClass().getDeclaredFields();
            for (Field field : fields)
            {
                if (field.isAnnotationPresent(Resource.class))
                {
                    Resource annotation = field.getAnnotation(Resource.class);
                    String name = annotation.name();
                    logger.log(MainLogger.LEVEL.INFO,"injecting @Resource(name=" + managedBean.getClass().getName() +
                             " into " + field.getName() + " " + name);

                    try
                    {
                        Context ctx = new InitialContext();
                        Object resource;
                        if (name != null && name.length() > 0)
                        {
                            resource = ctx.lookup("java:comp/env/" + name);
                        }
                        else
                        {
                            resource = ctx.lookup(clazz.getName() + "/" + field.getName());
                        }
                        // field may be private
                        boolean accessibility = field.isAccessible();
                        try
                        {
                            field.setAccessible(true);
                            field.set(managedBean, resource);
                        }
                        finally
                        {
                            field.setAccessible(accessibility);
                        }
                    }
                    catch (NamingException | IllegalAccessException exc)
                    {
                        throw new InjectionProviderException("injecting resource " + annotation.name()+" into "+clazz.getName()+"."+field.getName(), exc);
                    }
                }
            }
            // Process methods with @Resource
            for (Method method : clazz.getDeclaredMethods())
            {
                if (method.isAnnotationPresent(Resource.class)
                        && method.getName().startsWith("set")
                        && method.getName().length() > 3
                        && method.getReturnType() == void.class
                        && method.getParameterTypes().length == 1)
                {
                    // It's a setter with @Resource
                    Resource annotation = method.getAnnotation(Resource.class);
                    String name = annotation.name();
                    logger.log(MainLogger.LEVEL.INFO,"injecting @Resource(name=" + managedBean.getClass().getName() +
                            " into " +  method.getName() + " " + name);

                    try
                    {
                        Context ctx = new InitialContext();
                        Object resource;
                        if (name != null && name.length() > 0)
                        {
                            resource = ctx.lookup("java:comp/env/" + name);
                        }
                        else
                        {
                            name = method.getName().substring(3);
                            name = name.substring(0,1).toLowerCase()+name.substring(1);
                            resource = ctx.lookup(clazz.getName() + "/" + name);
                        }
                        // method may be private
                        boolean accessibility = method.isAccessible();
                        try
                        {
                            method.setAccessible(true);
                            method.invoke(managedBean, resource);
                        }catch (InvocationTargetException e){}

                        finally
                        {
                            method.setAccessible(accessibility);
                        }
                    }
                    catch (NamingException | IllegalAccessException  exc)
                    {
                        throw new InjectionProviderException("injecting resource " + annotation.name()+" via "+clazz.getName()+"."+method.getName(), exc);
                    }
                }
            }
        } while ((clazz = clazz.getSuperclass()) != Object.class);
    }

    @Override
    public void invokePostConstruct(Object managedBean) throws InjectionProviderException
    {
        delegate.invokePostConstruct(managedBean);
    }

    @Override
    public void invokePreDestroy(Object managedBean) throws InjectionProviderException
    {
        delegate.invokePreDestroy(managedBean);
    }
}


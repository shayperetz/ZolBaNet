package org.es.zolbareshet.JsfHelpers.helpers;

import org.es.zolbareshet.logging.Logger;
import org.es.zolbareshet.logging.LoggerFactory;

import javax.faces.FacesException;
import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerWrapper;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ExceptionQueuedEvent;
import javax.faces.event.ExceptionQueuedEventContext;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;


public class CustomExceptionHandler  extends ExceptionHandlerWrapper {

        private static final Logger logger = LoggerFactory.getLogger();
        private final ExceptionHandler wrapped;

        public CustomExceptionHandler(ExceptionHandler wrapped) {
            this.wrapped = wrapped;
        }

        @Override
        public ExceptionHandler getWrapped() {
            return this.wrapped;

        }
        public void handle() throws FacesException {
            final Iterator<ExceptionQueuedEvent> i = getUnhandledExceptionQueuedEvents().iterator();

            while (i.hasNext()) {
                ExceptionQueuedEvent event = i.next();
                ExceptionQueuedEventContext Econtext =
                        (ExceptionQueuedEventContext) event.getSource();
                // get the exception from context
                Throwable t = Econtext.getException();
                FacesContext context = FacesContext.getCurrentInstance();
                 ExternalContext externalContext = context.getExternalContext();
                 Map<String, Object> sessionmap = context.getExternalContext().getSessionMap();
                try {
                    //log error ?
                    logger.log(Logger.LEVEL.WARNING,"Severe Exception Occured:\n"+ t.getMessage());
                    //redirect error page
                    sessionmap.put("exceptionMessage", t.getMessage());
                    sessionmap.put("errorOccurred", "true");

                    try {
                        externalContext.redirect(externalContext.getRequestContextPath() + "/main/error.xhtml");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    context.renderResponse();


                }
                finally {
                    //remove it from queue
                    i.remove();             }
            }
            getWrapped().handle();
        }

    }



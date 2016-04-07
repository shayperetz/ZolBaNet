package org.es.zolbareshet.JsfHelpers.helpers;

import com.sun.faces.application.NavigationHandlerImpl;
import org.es.zolbareshet.logging.Logger;
import org.es.zolbareshet.logging.LoggerFactory;

import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import java.io.File;

/**
 * Created by eilons on 4/4/2016.
 */
public class CustomNavigationHandler extends NavigationHandlerImpl {

        private Logger log = LoggerFactory.getLogger();


        @Override
        public void handleNavigation(FacesContext context, String fromAction,
                                     String outcome) {
            if (outcome != null && outcome.endsWith(".xhtml")) {

                // canonicalize path relative to current view
                String dir = "/";
                if (!outcome.startsWith("/")) {
                    dir = context.getViewRoot().getViewId();
                    dir = dir.substring(0, dir.lastIndexOf("/"));
                }
                try {
                    File file = new File(dir, outcome);
                    outcome = file.getCanonicalPath();
                } catch (Exception ioe) {
                    log.log(Logger.LEVEL.WARNING,"Error canonicalizing " + outcome);
                    return;
                }

                // set the specified view
                ViewHandler views = context.getApplication().getViewHandler();
                UIViewRoot view = views.createView(context, outcome);
                context.setViewRoot(view);
            } else {
                super.handleNavigation(context, fromAction, outcome);
            }
        }
    }


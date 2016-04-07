package org.es.zolbareshet.JsfHelpers.helpers;

import javax.faces.context.ExceptionHandler;
import javax.faces.context.ExceptionHandlerFactory;

/**
 * Created by eilons on 4/4/2016.
 */
public class CustomExceptionHandlerFactory extends ExceptionHandlerFactory {



        private ExceptionHandlerFactory parent;

        public CustomExceptionHandlerFactory(ExceptionHandlerFactory parent) {
            this.parent = parent;
        }

        @Override
        public ExceptionHandler getExceptionHandler() {
            return new CustomExceptionHandler (parent.getExceptionHandler());

        }

    }


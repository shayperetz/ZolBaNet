package org.es.zolbareshet.JsfHelpers.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.Collection;

@FacesValidator("noElementWasChosenValidator")
public class NoElementWasChosenValidator  implements Validator {

        @Override
        public void validate(FacesContext context, UIComponent component,
                             Object value) throws ValidatorException {

            try {
                if(((Collection)value).size()==0) {
                    throw new Exception();
                }
            } catch (Exception ex) {
                FacesMessage msg = new FacesMessage("Validation failed.", "Empty collection");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
        }

    }

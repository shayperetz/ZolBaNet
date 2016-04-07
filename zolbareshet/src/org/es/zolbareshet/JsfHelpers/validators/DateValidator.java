package org.es.zolbareshet.JsfHelpers.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.Date;


@FacesValidator("datevalidator")
public class DateValidator implements Validator {

        @Override
        public void validate(FacesContext context, UIComponent component,
                             Object value) throws ValidatorException {
            try {
                if(value!=null) {
                    if (!((Date) value).toString().matches("(0[1-9])|([1-2][0-9])|(3[0-1])//(0[1-9])|(1[0-2])//(19[5-9][0-9])|(20[0-9][0-9])"));
                    throw new Exception();
                }
            } catch (Exception ex) {
                FacesMessage msg = new FacesMessage("Validation failed.", "Not a number");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
        }

        }


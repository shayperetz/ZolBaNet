package org.es.zolbareshet.JsfHelpers.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Created by eilons on 4/7/2016.
 */
@FacesValidator("floatDiscountValidator")
public class FloatDiscountValidator  implements Validator {

        @Override
        public void validate(FacesContext context, UIComponent component,
                             Object value) throws ValidatorException {

            try {
                   Float val =(Float) value;
                    if (val<0 || val>100){
                        throw new Exception();
                    }

            } catch (Exception ex) {
                FacesMessage msg = new FacesMessage("Validation failed.", "Not a percent number");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
        }

    }


package org.es.zolbareshet.JsfHelpers.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

//for fields of type String
@FacesValidator("integervalidator")
public class Integervalidator implements Validator{
    @Override
    public void validate(FacesContext context, UIComponent component,
                         Object value) throws ValidatorException {

        try {
            if(value!=null) {
                if (Long.parseLong((String) value)<=0){
                    throw new Exception();
                };// I use Long because we want to support phone number with 12 digits
            }
            else{
                throw new Exception();
            }
        } catch (Exception ex) {
            FacesMessage msg = new FacesMessage("Validation failed.", "Not a number");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }

}

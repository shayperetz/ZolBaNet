package org.es.zolbareshet.entities.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator("nullvalidator")
public class Nullvalidator implements Validator{
    @Override
    public void validate(FacesContext context, UIComponent component,
                         Object value) throws ValidatorException {

        try {
            if(value==null) {
                throw new Exception();
            }
        } catch (Exception ex) {
            FacesMessage msg = new FacesMessage("Validation failed.", "Null value");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }

}

package org.es.zolbareshet.entities.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

//for fields of type int
@FacesValidator("positiveNumberValidator")
public class PositiveNumberValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component,
                         Object value) throws ValidatorException {

        try {
            if ((Integer)value <=0){
                FacesMessage msg = new FacesMessage("Validation failed.",
                        "Number must be strictly positive");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
        } catch (NumberFormatException ex) {
            FacesMessage msg = new FacesMessage("Validation failed.", "Not a positive number");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }
    }

}

package org.es.zolbareshet.JsfHelpers.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

@FacesValidator(value="fileValidator")
public class FileValidator implements Validator {


        @Override
        public void validate(FacesContext context, UIComponent component, Object value)     throws ValidatorException {
            Part file = (Part) value;

            FacesMessage message=null;

            try {

                if (file==null || file.getSize()<=0 || file.getContentType().isEmpty() )
                    message=new FacesMessage("Select a valid file");
                else if (!file.getContentType().endsWith("png")&&!file.getContentType().endsWith("jpg"))
                    message=new FacesMessage("Select png or jpg file");
                else if (file.getSize()>100000)
                    message=new FacesMessage("File size too big. File size allowed  is less than or equal to 1 KB.");

                if (message!=null && !message.getDetail().isEmpty())
                {
                    message.setSeverity(FacesMessage.SEVERITY_ERROR);
                    throw new ValidatorException(message );
                }

            } catch (Exception ex) {
                throw new ValidatorException(new FacesMessage(ex.getMessage()));
            }

        }

    }


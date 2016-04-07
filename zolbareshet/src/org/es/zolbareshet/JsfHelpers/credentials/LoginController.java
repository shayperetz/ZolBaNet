package org.es.zolbareshet.JsfHelpers.credentials;

import org.apache.http.HttpRequest;
import org.es.zolbareshet.entities.users.UserBean;
import org.es.zolbareshet.queries.SimpleQueryInvoker;
import org.es.zolbareshet.utilities.Constants;
import org.es.zolbareshet.utilities.PropertiesFileManager;

import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.function.IntBinaryOperator;

@ManagedBean
public class LoginController implements PhaseListener {
    public void securePage(){
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        if(session!=null){
            String currentUser = (String)session.getAttribute("username");
            if (!SimpleQueryInvoker.IsSuperUser(currentUser)){
                try {
                    externalContext.redirect(externalContext.getRequestContextPath() + "/main/forbiddenPage.xhtml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        else{
            try {
                externalContext.redirect(externalContext.getRequestContextPath() + "/main/forbiddenPage.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    public void StoreLoginDetailsInSession(String userName){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", userName);
    }

    public void clearSessionLoginDetais(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }





    public String setusernameandgotomang(){
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        Map<String, Object> params =
                externalContext.getSessionMap();
        params.put("loginusername","eilon");
        return "/management/management";
    }

    @Override
    public void afterPhase(PhaseEvent phaseEvent) {

    }

    @Override
    public void beforePhase(PhaseEvent phaseEvent) {
    }

    @Override
    public PhaseId getPhaseId() {
        return null;
    }
}

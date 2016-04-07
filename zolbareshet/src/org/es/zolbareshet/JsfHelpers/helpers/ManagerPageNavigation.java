package org.es.zolbareshet.JsfHelpers.helpers;

import org.es.zolbareshet.entities.users.UserBean;
import org.es.zolbareshet.queries.SimpleQueryInvoker;
import org.es.zolbareshet.utilities.Utils;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.Map;

@ManagedBean
@ViewScoped
public class ManagerPageNavigation {
    //main menu
    private final static String MANAGER = "manager";
    private final static String REPORT = "report";
    private final static String PRODUCT = "product";
    private final static String SERVER_STATE = "server-state";
    //server state sub menu
    private final static String LOG = "log";
    private final static String CONFIG = "config";
    private final static String SERVICES = "services";

    //super users sub menu
    private final static String NEW_SUPER = "new-uper-user";
    private final static String LIST_SUPER = "list-of-supers";
    private final static String REGULAR_USER = "regular-users";
    public final static String EDIT_USER ="edit-user";

    //products sub menu
    private final static String NEW_PRODUCT = "new-product";
    private final static String EDIT_PRODUCT = "edit-product";
    private final static String EDIT_CATEGORIES = "edit-categories";

    //when entering all sections are closed
    private boolean showManagerSection = false;
    private boolean showReportSection = false;
    private boolean showProductsSection = false;
    private boolean showServerStateSection = false;
    private boolean showLogSection = false;
    private boolean showConfigurationSection = false;
    private boolean showServiceSection = false;
    private boolean showNewSuperusersSection = false;
    private boolean showListSuperusersSection = false;
    private boolean showRegularUsersSection =false;
    private boolean showEditusersSection = false;
    private boolean showNewProductSection = false;
    private boolean showEditProductSection = false;
    private boolean showEditCategoriesSection = false;

    public boolean isShowNewProductSection() {
        return showNewProductSection;
    }


    public boolean isShowEditProductSection() {
        return showEditProductSection;
    }


    public boolean isShowEditCategoriesSection() {
        return showEditCategoriesSection;
    }

    public boolean isShowEditusersSection() {
        return showEditusersSection;
    }

    public boolean isShowRegularUsersSection() {
        return showRegularUsersSection;
    }

    public boolean isShowListSuperusersSection() {
        return showListSuperusersSection;
    }

    public boolean isShowNewSuperusersSection() {
        return showNewSuperusersSection;
    }

    public boolean isShowServiceSection() {
        return showServiceSection;
    }

    public boolean isShowServerStateSection() {
        return showServerStateSection;
    }

    public boolean isShowManagerSection() {
        return showManagerSection;
    }

    public boolean isShowReportSection() {
        return showReportSection;
    }

    public boolean isShowLogSection() {
        return showLogSection;
    }

    public boolean isShowConfigurationSection() {
        return showConfigurationSection;
    }

    public boolean isShowProductsSection() {
        return showProductsSection;
    }

    public void setShowEditCategoriesSection(boolean showEditCategoriesSection) {
        this.showEditCategoriesSection = showEditCategoriesSection;
    }

    public void setShowEditProductSection(boolean showEditProductSection) {
        this.showEditProductSection = showEditProductSection;
    }

    public void setShowNewProductSection(boolean showNewProductSection) {
        this.showNewProductSection = showNewProductSection;
    }

    public void setShowEditusersSection(boolean showEditusersSection) {
        this.showEditusersSection = showEditusersSection;
    }

    public void setShowRegularUsersSection(boolean showRegularUsersSection) {
        this.showRegularUsersSection = showRegularUsersSection;
    }

    public void setShowNewSuperusersSection(boolean showNewSuperusersSection) {
        this.showNewSuperusersSection = showNewSuperusersSection;
    }

    public void setShowListSuperusersSection(boolean showListSuperusersSection) {
        this.showListSuperusersSection = showListSuperusersSection;
    }

    public void setShowServiceSection(boolean showServiceSection) {
        this.showServiceSection = showServiceSection;
    }

    public void setShowServerStateSection(boolean showServerStateSection) {
        this.showServerStateSection = showServerStateSection;
    }

    public void setShowManagerSection(boolean showManagerSection) {
        this.showManagerSection = showManagerSection;
    }

    public void setShowReportSection(boolean showReportSection) {
        this.showReportSection = showReportSection;
    }

    public void setShowProductsSection(boolean showProductsSection) {
        this.showProductsSection = showProductsSection;
    }

    public void setShowLogSection(boolean showLogSection) {
        this.showLogSection = showLogSection;
    }

    public void setShowConfigurationSection(boolean showConfigurationSection) {
        this.showConfigurationSection = showConfigurationSection;
    }

    public void setShowEditCategoriesSection() {
        changeContext(EDIT_CATEGORIES);
    }

    public void setShowEditProductSection() {
        changeContext(EDIT_PRODUCT);
    }

    public void setShowNewProductSection() {
        changeContext(NEW_PRODUCT);    }

    public void setShowRegularUsersSection() {
        changeContext(REGULAR_USER);
    }

    public void setShowReportSection() {
        changeContext(REPORT);
    }

    public void setShowServerStateSection() {
        changeContext(SERVER_STATE);
    }

    public void setShowProductsSection() {
        changeContext(PRODUCT);
    }

    public void setShowLogSection() {
        changeContext(LOG);
    }

    public void setShowConfigurationSection() {
        changeContext(CONFIG);
    }

    public void setShowManagerSection() {
        changeContext(MANAGER);
    }

    public void setShowServiceSection() {
        changeContext(SERVICES);
    }

    public void setShowNewSuperusersSection() {
        changeContext(NEW_SUPER);
    }

    public void setShowListSuperusersSection() {
        changeContext(LIST_SUPER);
    }


    public void changeContext(String s) {
        switch (s) {
            //*--------------MANAGE USERS---------------------
            case MANAGER:
                setShowProductsSection(false);
                setShowReportSection(false);
                setShowServerStateSection(false);
                setShowManagerSection(!isShowManagerSection());
                setShowListSuperusersSection(false);
                setShowNewSuperusersSection(false);
                setShowRegularUsersSection(false);
                break;
            case NEW_SUPER:
                UserBean u = Utils.findBean("userBean");
                u.clearUserBean();
                setShowNewSuperusersSection(!isShowNewSuperusersSection());
                setShowListSuperusersSection(false);
                setShowRegularUsersSection(false);
                setShowEditusersSection(false);
                break;
            case LIST_SUPER:
                setShowNewSuperusersSection(false);
                setShowListSuperusersSection(!isShowListSuperusersSection());
                setShowRegularUsersSection(false);
                setShowEditusersSection(false);
                break;
            case REGULAR_USER:
                setShowNewSuperusersSection(false);
                setShowListSuperusersSection(false);
                setShowRegularUsersSection(!isShowRegularUsersSection());
                setShowEditusersSection(false);
                break;
            case EDIT_USER:
                setShowNewSuperusersSection(false);
                setShowListSuperusersSection(false);
                setShowRegularUsersSection(false);
                setShowEditusersSection(true);
                break;
            //-------------MANAGE PRODUCTS-------------------------
            case PRODUCT:
                setShowReportSection(false);
                setShowServerStateSection(false);
                setShowProductsSection(!isShowProductsSection());
                setShowManagerSection(false);
                setShowEditProductSection(false);
                setShowNewProductSection(false);
                setShowEditCategoriesSection(false);
                break;
            case NEW_PRODUCT:
                setShowEditProductSection(false);
                setShowNewProductSection(!isShowNewProductSection());
                setShowEditCategoriesSection(false);
                break;
            case EDIT_PRODUCT:
                setShowEditProductSection(!isShowEditProductSection());
                setShowNewProductSection(false);
                setShowEditCategoriesSection(false);
                break;
            case EDIT_CATEGORIES:
                setShowEditProductSection(false);
                setShowNewProductSection(false);
                setShowEditCategoriesSection(!isShowEditCategoriesSection());
                break;
            //-----------------REPORTS----------------------------------
            case REPORT:
                setShowReportSection(!isShowReportSection());
                setShowProductsSection(false);
                setShowServerStateSection(false);
                setShowManagerSection(false);
                break;
            case SERVER_STATE:
                setShowConfigurationSection(false);
                setShowLogSection(false);
                setShowServiceSection(false);
                setShowReportSection(false);
                setShowProductsSection(false);
                setShowManagerSection(false);
                setShowServerStateSection(!isShowServerStateSection());
                break;
            case LOG:
                setShowConfigurationSection(false);
                setShowLogSection(!isShowLogSection());
                setShowServiceSection(false);
                break;
            case CONFIG:
                setShowConfigurationSection(!isShowConfigurationSection());
                setShowLogSection(false);
                setShowServiceSection(false);
                break;
            case SERVICES:
                setShowServiceSection(!isShowServiceSection());
                setShowLogSection(false);
                setShowConfigurationSection(false);
                break;
        }


    }


}

package org.es.zolbareshet.entities.users;

import org.es.zolbareshet.queries.QueriesHandler;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class ManagerPageHelperBean {
    private final static String MANAGER = "manager";
    private final static String REPORT = "report";
    private final static String PRODUCT = "product";
    private final static String LOG = "log";
    private final static String CONFIG = "config";

    private boolean showManagerSection = false;
    private boolean showReportSection = false;
    private boolean showProductsSection = false;
    private boolean showLogSection = false;
    private boolean showConfigurationSection = false;

    public ManagerPageHelperBean() {

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

    public void setShowManagerSection() {
        changeContext(MANAGER);
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

    public void setShowReportSection() {
        changeContext(REPORT);
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

    private void changeContext(String s) {
        switch (s) {
            case MANAGER:
                setShowConfigurationSection(false);
                setShowLogSection(false);
                setShowProductsSection(false);
                setShowReportSection(false);
                setShowManagerSection(!isShowManagerSection());
                break;
            case PRODUCT:
                setShowConfigurationSection(false);
                setShowLogSection(false);
                setShowReportSection(false);
                setShowProductsSection(!isShowProductsSection());
                setShowManagerSection(false);
                break;
            case LOG:
                setShowConfigurationSection(false);
                setShowLogSection(!isShowLogSection());
                setShowReportSection(false);
                setShowProductsSection(false);
                setShowManagerSection(false);
                break;
            case REPORT:
                setShowConfigurationSection(false);
                setShowLogSection(false);
                setShowReportSection(!isShowReportSection());
                setShowProductsSection(false);
                setShowManagerSection(false);
                break;
            case CONFIG:
                setShowConfigurationSection(!isShowConfigurationSection());
                setShowLogSection(false);
                setShowReportSection(false);
                setShowProductsSection(false);
                setShowManagerSection(false);
                break;
        }
    }

}


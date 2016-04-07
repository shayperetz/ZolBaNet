package org.es.zolbareshet.JsfHelpers.converters;

import org.es.zolbareshet.entities.products.Category;
import org.es.zolbareshet.queries.SimpleQueryInvoker;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 * Created by eilons on 4/6/2016.
 */
@FacesConverter("org.es.zolbareshet.JsfHelpers.converters.CategoryConverter")
public class CategoryConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        byte[] image=SimpleQueryInvoker.getCategoryImage(s);
        return new Category(s,image);
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        return ((Category)o).getName();
    }



}

package org.es.zolbareshet.entities.products;


import org.es.zolbareshet.queries.QueriesHandler;
import org.es.zolbareshet.utilities.Constants;

import javax.faces.bean.ManagedBean;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static jdk.nashorn.internal.codegen.CompilerConstants.CONSTANTS;

@ManagedBean
public class Category {
    private List<String> categories;

    public Category(){
        categories = new LinkedList<>();
        String[] parameters = {Constants.CATEGORY_TABLE,Constants.CATEGORY_NAME_FIELD};
       /* ResultSet rs= QueriesHandler.getResultQuery(Constants.GET_ALL_FROM_TABLE_QUERY,parameters);
        try {
            while (rs.next() ) {
                categories.add(rs.getString(Constants.CATEGORY_NAME_FIELD));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }
}

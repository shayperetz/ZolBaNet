package org.es.zolbareshet.orders;

import org.es.zolbareshet.entities.products.ProductBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Cart extends AbstractOrder{

    @Override
    public boolean commitOrder() {
        return false;
    }

    @Override
    public boolean addProduct(ProductBean p, int quantity) {
        return false;
    }

    @Override
    public boolean removeProduct(ProductBean p) {
        return false;
    }

    @Override
    public boolean incrementProductQuantity(ProductBean p, int quantity) {
        return false;
    }

    @Override
    public boolean decrementProductQuantity(ProductBean p, int quantity) {
        return false;
    }
}
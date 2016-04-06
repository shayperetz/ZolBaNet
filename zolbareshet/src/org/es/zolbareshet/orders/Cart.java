package org.es.zolbareshet.orders;

import org.es.zolbareshet.entities.products.Product;

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
    public boolean addProduct(Product p, int quantity) {
        return false;
    }

    @Override
    public boolean removeProduct(Product p) {
        return false;
    }

    @Override
    public boolean incrementProductQuantity(Product p, int quantity) {
        return false;
    }

    @Override
    public boolean decrementProductQuantity(Product p, int quantity) {
        return false;
    }
}
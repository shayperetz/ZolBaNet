package org.es.zolbareshet.entities.products;

import javax.faces.bean.ManagedBean;
import java.awt.image.BufferedImage;

@ManagedBean
public class Product {
    private int PartNumber ;
    private String PartName ;
    private String Description ;
    private float Price ;
    private int AvailableQuantity ;
    private boolean IsActive ;
    private float discount ;
    private BufferedImage image;
    private String category;

    public int getPartNumber() {
        return PartNumber;
    }

    public void setPartNumber(int partNumber) {
        PartNumber = partNumber;
    }

    public String getPartName() {
        return PartName;
    }

    public void setPartName(String partName) {
        PartName = partName;
    }

    public String getDescription() {
        return Description;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public void setDescription(String description) {
        Description = description;

    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public int getAvailableQuantity() {
        return AvailableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        AvailableQuantity = availableQuantity;
    }

    public boolean isActive() {
        return IsActive;
    }

    public void setActive(boolean active) {
        IsActive = active;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}

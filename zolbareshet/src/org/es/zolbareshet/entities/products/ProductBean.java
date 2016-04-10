package org.es.zolbareshet.entities.products;

import org.es.zolbareshet.queries.SimpleQueryInvoker;
import org.es.zolbareshet.utilities.Constants;

import javax.faces.bean.ManagedBean;
import javax.servlet.http.Part;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

@ManagedBean
public class ProductBean implements Serializable{
    private String productName;
    private String description;
    private float price;
    private int availableQuantity;
    private boolean isForSale =true ;
    private float discount ;
    private ArrayList<String> categories;
    private Part image;
    private int imagesize;
    private int productNumber;

    //for uploading image
    private  InputStream is = null;
    private File file;
    private FileInputStream fis=null;


    public ProductBean(){
       //setProductNumber(getNextProductNumber());
   }

    public int getProductNumber() {
        return productNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

      public void setDescription(String description) {
        this.description = description;

    }

    public Part getImage() {
        return image;
    }

    public void setImage(Part image) {

       if(image!=null) {
            try {
                        is = image.getInputStream();
                        file = new File("C:\\", "temp"+System.currentTimeMillis()+".png");
                        imagesize = (int)image.getSize();
                        Files.copy(is, file.toPath(), StandardCopyOption.REPLACE_EXISTING);

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    finally {
                        try {
                            is.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
        }
    }

    public ArrayList<String> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<String> categories) {
        this.categories = categories;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public boolean isForSale() {
        return isForSale;
    }

    public void setForSale(boolean forSale) {
        isForSale = forSale;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public String getImageFromServlet(){
        return "/zolbareshet/getPhoto/?source=product&amp;imagename=" + getProductName();
    }

    public String saveProduct(){
        if(productName!=null&&description!=null&&availableQuantity>0&&file!=null){
            try {
                        fis= new FileInputStream(file);
                        SimpleQueryInvoker.addProduct(productNumber,productName,description,price,availableQuantity,discount, isForSale, fis, imagesize);


                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    finally {
                        try {
                            if (fis!=null) {
                                fis.close();
                            }
                                Files.delete(file.toPath());
                            clear();





                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
        }
        return Constants.MANAGEMENT_PAGE;
    }

    public boolean isImageExists(){
        return image!=null;
    }

    public void clear(){
        productName=null;
        description=null;
        price=0;
        availableQuantity=0;
        isForSale=true;
        discount=0;
        categories=new ArrayList<>();
        image=null;
        is=null;
        fis=null;
        file=null;
    }
}

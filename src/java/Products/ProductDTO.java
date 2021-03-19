/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Products;

import java.io.Serializable;

/**
 *
 * @author Quoc Huy
 */
public class ProductDTO  implements Serializable{
    String productID;
    String name;
    int price;
    int quantity;
    String categoryID;

    public ProductDTO() {
    }

    public ProductDTO(String productID, String name, int price, int quantity, String categoryID) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.categoryID = categoryID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    @Override
    public String toString() {
        return "ProductDTO{" + "productID=" + productID + ", name=" + name + ", price=" + price + ", quantity=" + quantity + ", categoryID=" + categoryID + '}';
    }
  
    
}

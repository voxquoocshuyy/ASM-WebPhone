/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CartProducts;

import Products.ProductDTO;
import java.io.Serializable;

/**
 *
 * @author quochuy
 */
public class OrderDTO extends ProductDTO implements Serializable{
    private int Orderquantity;

    public OrderDTO() {
    }
    public OrderDTO(int Orderquantity){
        this.Orderquantity = Orderquantity;
    }
    public int getOrderquantity() {
        return Orderquantity;
    }

    public void setOrderquantity(int Orderquantity) {
        this.Orderquantity = Orderquantity;
    }


    public OrderDTO(String productID, String productName, int productPrice, int productQuantity, String categoryID) {
        super(productID, productName, productPrice, productQuantity, categoryID);
    }



    

}

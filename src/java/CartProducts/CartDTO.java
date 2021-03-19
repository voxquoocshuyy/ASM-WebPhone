/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CartProducts;

import java.util.HashMap;

/**
 *
 * @author quochuy
 */
public class CartDTO {
   private String customerName;
   private HashMap<String, OrderDTO> cart;

    public CartDTO() {
        this.customerName = "GUEST";
        this.cart = new HashMap<>();
    }
    
    public CartDTO(String customerName) {
        this.customerName = customerName;
        this.cart = new HashMap<>();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public HashMap<String, OrderDTO> getCart() {
        return cart;
    }
   
    
   public void addToCart(OrderDTO dto) throws Exception {
       if(this.cart.containsKey(dto.getProductID())) {
           int quantity = this.cart.get(dto.getProductID()).getQuantity() + 1;
           dto.setQuantity(quantity);
       }
       this.cart.put(dto.getProductID(), dto);
   }
        
    public int getTotal() {
        int result = 0;
        for(OrderDTO dto: this.cart.values()) {
            result += dto.getPrice() * dto.getQuantity();
        }
        return result;
    }
    
    public void updateCart(String id, int newQuantity) throws Exception {
        if(this.cart.containsKey(id)) {
            this.cart.get(id).setQuantity(newQuantity);
        }
    }
    
    public void remove(String id) throws Exception {
        if(this.cart.containsKey(id)) {
            this.cart.remove(id);
        }
    }

    @Override
    public String toString() {
        return "CartDTO{" + "customerName=" + customerName + ", cart=" + cart + '}';
    }
    
}

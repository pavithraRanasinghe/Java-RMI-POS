/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author PAVITHRA
 */
public class Item {
    private String code;
    private String description;
    private int qty;
    private double price;

    public Item() {
    }

    public Item(String code, String description, int qty, double price) {
        this.code = code;
        this.description = description;
        this.qty = qty;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   
    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" + "code=" + code + ", description=" + description + ", qty=" + qty + ", price=" + price + '}';
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author pdavila
 */
public class Product {
    
    private int product_id;
    private String product_name;
    private String product_trademark;
    private double prodcut_price;

    public int getProduct_id() {
        return product_id;
    }

    private void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_trademark() {
        return product_trademark;
    }

    public void setProduct_trademark(String product_trademark) {
        this.product_trademark = product_trademark;
    }

    public double getProdcut_price() {
        return prodcut_price;
    }

    public void setProdcut_price(double prodcut_price) {
        this.prodcut_price = prodcut_price;
    }
}

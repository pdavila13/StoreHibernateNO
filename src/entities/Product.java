/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author pdavila
 */
@Entity
@Table(name="products")   
public class Product {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int _1_product_id;
    
    private String _2_product_name;
    
    private String _3_product_trademark;
    
    private double _4_product_price;
    
    @Transient
    private Stock _5_stored;
    
    @Transient
    private Category _6_belongs;
    
    @Transient
    private Client _7_sold;

    public Product() {
        //
    }

    public Product(int _1_product_id, String _2_product_name, String _3_product_trademark, double _4_product_price) {
        this._1_product_id = _1_product_id;
        this._2_product_name = _2_product_name;
        this._3_product_trademark = _3_product_trademark;
        this._4_product_price = _4_product_price;
    }
    
    public long getProduct_id() {
        return _1_product_id;
    }

    private void set1_product_id(int _1_product_id) {
        this._1_product_id = _1_product_id;
    }

    public String get2_product_name() {
        return _2_product_name;
    }

    public void set2_product_name(String _2_product_name) {
        this._2_product_name = _2_product_name;
    }

    public String get3_product_trademark() {
        return _3_product_trademark;
    }

    public void set3_product_trademark(String _3_product_trademark) {
        this._3_product_trademark = _3_product_trademark;
    }

    public double get4_product_price() {
        return _4_product_price;
    }

    public void set4_product_price(double _4_product_price) {
        this._4_product_price = _4_product_price;
    }
    
    public Stock get5_stored() {
        return _5_stored;
    }

    public void set5_stored(Stock _5_stored) {
        this._5_stored = _5_stored;
    }

    public Category get6_belongs() {
        return _6_belongs;
    }

    public void set6_belongs(Category _6_belongs) {
        this._6_belongs = _6_belongs;
    }

    public Client get7_sold() {
        return _7_sold;
    }

    public void set7_sold(Client _7_sold) {
        this._7_sold = _7_sold;
        _7_sold.set7_buy(this);
    }
}

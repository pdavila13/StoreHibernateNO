/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Product;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import utils.HibernateUtil;

/**
 *
 * @author pdavila
 */
public class Model {
    
    //private static Session session = HibernateUtil.getSessionFactory().openSession();
    private ArrayList<Product> products = new ArrayList();
    private ClassDAO product = new ClassDAO(Product.class);
    
    public Model() {
        updatedLists();
    }
    
    public ArrayList<Product> getProducts() {
        return products;
    }
    
    public void createdProduct(String product_name, String product_trademark, double product_price) {
        Product p = new Product(product_name,product_trademark,product_price);
        
        try {
            product.store(p);
        } catch(HibernateException he) {
            tryException(he);
        }
        updatedLists();
    }
    
    public void modifyProduct(int product_id, String product_name, String product_trademark, double product_price) {
        Product modified = null;
        
        try {
            modified = (Product) product.obtain(product_id);
            modified.set2_product_name(product_name);
            modified.set3_product_trademark(product_trademark);
            modified.set4_product_price(product_price);
            product.update(modified);
        } catch(HibernateException he) {
            tryException(he);
        }
        updatedLists();
    }
    
    public void deleteProduct(int product_id) {
        Product delete = null;
        
        try {
            delete = (Product) product.obtain(product_id);
            product.destroy(delete);
        } catch(HibernateException he) {
            tryException(he);
        }
        updatedLists();
    }
    
    private void updatedLists() {
        products = (ArrayList) product.obtainList();
    }
    
    private void tryException(HibernateException he) {
        System.out.println(he.getMessage());
    }
}

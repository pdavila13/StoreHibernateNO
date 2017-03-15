/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storehibernate;

import entities.Product;
import java.util.List;
import model.ClassDAO;

/**
 *
 * @author pdavila
 */
public class StoreHibernate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ClassDAO ClassProductDAO = new ClassDAO(Product.class);
        Product productRecovered = null;
        long destroy_id = 0;
        
        //Created
        Product p1 = new Product(1,"Processador","INTEL",153.56);
        Product p2 = new Product(2,"Motherboard","ASUS",197.23);
        Product p3 = new Product(3,"Hard disk","WD",76.80);
        
        //Save
        destroy_id = ClassProductDAO.store(p1);
        ClassProductDAO.store(p2);
        ClassProductDAO.store(p3);
        
        //Edit and update
        p2.set3_product_trademark("MSI");
        ClassProductDAO.update(p2);
        
        
        //Recovered
        productRecovered = (Product) ClassProductDAO.obtain(Integer.valueOf(String.valueOf(destroy_id)));
        System.out.println("Recuperem a " + productRecovered.get2_product_name());
        
        //Delete
        ClassProductDAO.destroy(productRecovered);
        
        //Obstain list
        List<Product> listProducts = ClassProductDAO.obtainList();
        System.out.println("Hi ha " + listProducts.size() + "productes a la base de dades");
        
        for (Product p : listProducts) {
            System.out.println(" -> " + p.get2_product_name());
        }
        
        System.exit(0);
    }
}
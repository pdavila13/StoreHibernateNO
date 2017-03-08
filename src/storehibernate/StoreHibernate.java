/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storehibernate;

import entities.Product;
import java.util.List;
import model.ClassProductDAO;

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
        ClassProductDAO classProductDAO = new ClassProductDAO(Product.class);
        Product productRecovered = null;
        long destroy_id = 0;
        
        //Created
        Product p1 = new Product(1,"Processador","INTEL",153.56);
        Product p2 = new Product(2,"Motherboard","ASUS",197.23);
        Product p3 = new Product(3,"Hard disk","WD",76.80);
        
        //Save
        destroy_id = classProductDAO.store(p1);
        classProductDAO.store(p2);
        classProductDAO.store(p3);
        
        //Edit and update
        p2.setProduct_trademark("MSI");
        classProductDAO.update(p2);
        
        //Recovered
        productRecovered = classProductDAO.obtain(destroy_id);
        System.out.println("Recuperem a " + productRecovered.getProduct_name());
        
        //Delete
        classProductDAO.destroy(productRecovered);
        
        //Obstain list
        List<Product> listProducts = classProductDAO.obtainList();
        System.out.println("Hi ha " + listProducts.size() + "productes a la base de dades");
        
        for (Product p : listProducts) {
            System.out.println(" -> " + p.getProduct_name());
        }
        System.exit(0);
    }
}

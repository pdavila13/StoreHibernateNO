/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storehibernate;

import entities.Product;
import entities.Stock;
import java.util.List;
import model.ClassDAO;

/**
 *
 * @author pdavila
 */
public class StoreHibernateOneToOne {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ClassDAO ClassProductDAO = new ClassDAO(Product.class);
        ClassDAO ClassStockDAO = new ClassDAO(Stock.class);
        
        Product productRecovered = null;
        Stock stockRecovered = null;
        
        long destroy_product_id = 0;
        long destroy_stock_id = 0;
        
        //Created
        Stock s1 = new Stock(12);
        Stock s2 = new Stock(24);
        Stock s3 = new Stock(46);
        
        //Created
        Product p1 = new Product("Processador","INTEL","7500",153,s1);
        Product p2 = new Product("Motherboard","ASUS","970",197,s2);
        Product p3 = new Product("Hard disk","WD","ST96304826",76,s3);
        
        //Save
        destroy_product_id = ClassProductDAO.store(p1);
        ClassProductDAO.store(p2);
        ClassProductDAO.store(p3);
        
        destroy_stock_id = ClassStockDAO.store(s1);
        ClassStockDAO.store(s2);
        ClassStockDAO.store(s3);
        
        //Edit and update
        p2.set3_product_trademark("MSI");
        ClassProductDAO.update(p2);
        
        s2.set2_stock_total(100);
        ClassStockDAO.update(s2);
               
        //Recovered
        productRecovered = (Product) ClassProductDAO.obtain(Integer.valueOf(String.valueOf(destroy_product_id)));
        System.out.println("Recuperem a " + productRecovered.get2_product_name());
        
        stockRecovered = (Stock) ClassStockDAO.obtain(Integer.valueOf(String.valueOf(destroy_stock_id)));
        System.out.println("Recuperem a " + stockRecovered.get2_stock_total());
        
        //Delete
        ClassProductDAO.destroy(productRecovered);
        
        ClassStockDAO.destroy(stockRecovered);
        
        //Obstain list
        List<Product> listProducts = ClassProductDAO.obtainList();
        System.out.println("Hi ha " + listProducts.size() + " productes a la base de dades");
        
        for (Product p : listProducts) {
            System.out.println(" -> " + p.get2_product_name());
        }
        
        List<Stock> listStock = ClassStockDAO.obtainList();
        System.out.println("Hi ha " + listStock.size() + " stock a la base de dades");
        
        for (Stock s : listStock) {
            System.out.println(" -> " + s.get2_stock_total());
        }
        
        System.exit(0);
    }
}
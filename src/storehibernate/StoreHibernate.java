/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storehibernate;

import controller.Controller;
import entities.Product;
import model.ClassDAO;
import model.Model;
import views.View;

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
        ClassDAO<Product> model = new ClassDAO<>(Product.class);
        View view = new View();
        
        new Controller(view,model);
        
    }
}
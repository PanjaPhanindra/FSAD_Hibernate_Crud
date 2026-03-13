package com.klu.hibernate_crud;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.klu.hibernate_crud.model.Product;
public class App {

    public static void main(String[] args) {

        // Step 1: Load Hibernate Configuration
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");

        // Step 2: Create SessionFactory
        SessionFactory sf = cfg.buildSessionFactory();

        // Step 3: Open Session
        Session session = sf.openSession();

        // Step 4: Begin Transaction
        Transaction tx = session.beginTransaction();

        // INSERT MULTIPLE RECORDS
        Product p1 = new Product();
        p1.setName("Laptop");
        p1.setDescription("Gaming Laptop");
        p1.setPrice(75000);
        p1.setQuantity(5);

        Product p2 = new Product();
        p2.setName("Mobile");
        p2.setDescription("Android Phone");
        p2.setPrice(20000);
        p2.setQuantity(10);

        session.persist(p1);
        session.persist(p2);

        System.out.println("Products Inserted");

        // READ Operation
        Product product = session.get(Product.class, 1);

        if(product != null) {
            System.out.println("Product Name: " + product.getName());
        }

        // UPDATE Operation
        if(product != null) {
            product.setPrice(80000);
            session.merge(product);
            System.out.println("Product Updated");
        }

        // DELETE Operation
        if(product != null) {
            session.remove(product);
            System.out.println("Product Deleted");
        }

        // Commit Transaction
        tx.commit();

        // Close Session
        session.close();
        sf.close();
    }
}
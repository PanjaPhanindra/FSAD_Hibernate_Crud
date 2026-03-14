package com.klu.hibernate_crud;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import com.klu.hibernate_crud.model.Product;

public class PriceRangeQuery {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        // HQL WHERE query to filter products within a price range
        Query<Product> query = session.createQuery("FROM Product WHERE price BETWEEN 10000 AND 15000",Product.class);

        // Get results
        List<Product> list = query.list();

        // Print products
        System.out.println("Products with price between 100 and 500:");
        for(Product p : list) {
            System.out.println(p.getName() + " " + p.getPrice());
        }

        // Close session
        session.close();
        factory.close();
    }
}
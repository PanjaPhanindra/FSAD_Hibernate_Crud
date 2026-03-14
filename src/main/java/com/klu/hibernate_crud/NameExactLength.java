package com.klu.hibernate_crud;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import com.klu.hibernate_crud.model.Product;
public class NameExactLength {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        // Names with exactly 4 characters
        Query<Product> query = session.createQuery("FROM Product WHERE name LIKE '______'", Product.class);
        List<Product> list = query.list();

        System.out.println("Products with exactly 6 character names:");
        for(Product p : list) 
        {
            System.out.println("Name: " + p.getName());
        }
        session.close();
        factory.close();
    }
}
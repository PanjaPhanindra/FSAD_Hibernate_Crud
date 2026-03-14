package com.klu.hibernate_crud;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import com.klu.hibernate_crud.model.Product;
public class NameStartsWith {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        // Names starting with letter 'A'
        Query<Product> query = session.createQuery(
                "FROM Product WHERE name LIKE 'M%'", Product.class);
        List<Product> list = query.list();

        System.out.println("Products with names starting with 'M':");

        for(Product p : list) {
            System.out.println("Name: " + p.getName());
        }
        session.close();
        factory.close();
    }
}
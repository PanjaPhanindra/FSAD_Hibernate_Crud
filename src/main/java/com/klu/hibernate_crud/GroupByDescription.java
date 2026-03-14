package com.klu.hibernate_crud;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class GroupByDescription {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Query<Object[]> query = session.createQuery("SELECT description, COUNT(*) FROM Product GROUP BY description");
        List<Object[]> list = query.list();
        // Print heading
        System.out.println("Description  |  Product Count");
        System.out.println("-----------------------------");
        // Print results
        for(Object[] row : list) {
            System.out.println(row[0] + "  |  " + row[1]);
        }
        // Close session and factory
        session.close();
        factory.close();
    }
}
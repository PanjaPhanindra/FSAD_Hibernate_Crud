package com.klu.hibernate_crud;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import com.klu.hibernate_crud.model.Product;
import java.util.List;
import org.hibernate.query.Query;


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

//        // INSERT MULTIPLE RECORDS
//        Product p1 = new Product();
//        p1.setName("Laptop");
//        p1.setDescription("Gaming Laptop");
//        p1.setPrice(75000);
//        p1.setQuantity(5);
//
//        Product p2 = new Product();
//        p2.setName("Mobile");
//        p2.setDescription("Android Phone");
//        p2.setPrice(20000);
//        p2.setQuantity(10);
//
//        Product p3 = new Product();
//        p3.setName("Tablet");
//        p3.setDescription("Android Tablet");
//        p3.setPrice(15000);
//        p3.setQuantity(8);
//
//        Product p4 = new Product();
//        p4.setName("Monitor");
//        p4.setDescription("LED Monitor");
//        p4.setPrice(12000);
//        p4.setQuantity(6);
//
//        Product p5 = new Product();
//        p5.setName("Keyboard");
//        p5.setDescription("Mechanical Keyboard");
//        p5.setPrice(3000);
//        p5.setQuantity(20);
//
//        session.persist(p1);
//        session.persist(p2);
//
//        session.persist(p3);
//        session.persist(p4);
//        session.persist(p5);
//        System.out.println("Products Inserted");
//        // READ Operation
//        Product product = session.get(Product.class, 1);
//        if(product != null) {
//            System.out.println("Product Name: " + product.getName());
//        }
//        // UPDATE Operation
//        if(product != null) {
//            product.setPrice(80000);
//            session.merge(product);
//            System.out.println("Product Updated");
//        }
//        // DELETE Operation
//        if(product != null) {
//            session.remove(product);
//            System.out.println("Product Deleted");
//        }
//        
//        //Ascending Order
//        Query<Product> query1 = session.createQuery("FROM Product ORDER BY price ASC", Product.class);
//        List<Product> list = query1.list();
//        System.out.println("Products in Ascending Order:");
//        for(Product p : list){
//            System.out.println(p.getName() + " " + p.getPrice());
//        }
//        		
//        		
//        //Descending Order
//        Query<Product> query2 = session.createQuery("FROM Product ORDER BY price DESC", Product.class);
//        List<Product> list1 = query2.list();
//        System.out.println("Products in Descending Order:");
//        for(Product p : list1){
//            System.out.println(p.getName() + " " + p.getPrice());
//        }
//        
//     
//        
//        // Sorting Products by Quantity in Descending Order
//        Query<Product> query3 = session.createQuery("FROM Product ORDER BY quantity DESC", Product.class);
//        List<Product> list2 = query3.list();
//        System.out.println("Products ordered by Quantity (Descending):");
//        for(Product p : list2)
//        {
//            System.out.println(p.getName() + " " + p.getQuantity());
//        }
//        
//        
//        // Fetch 3 records from Product table using pagination
//        Query<Product> query = session.createQuery("FROM Product", Product.class);
//
//        // Set starting position (0 means first record)
//        query.setFirstResult(0);
//
//        // Set maximum number of records to fetch
//        query.setMaxResults(3);
//        List<Product> list = query.list();
//        // Print the fetched products
//        System.out.println("First 3 Products:");
//        for(Product p : list)
//        {
//             System.out.println(p.getName() + " " + p.getPrice());
//        }
//        
//        // Fetch products using pagination
//
//        Query<Product> query = session.createQuery("FROM Product", Product.class);
//        // Skip first 3 records
//        query.setFirstResult(3);
//        // Fetch next 3 records
//        query.setMaxResults(3);
//        // Store result in list
//        List<Product> list = query.list();
//        
//        // Print products
//        for(Product p : list) {
//           System.out.println(p.getName() + " " + p.getPrice());
//        }
       
         
        // Count total products
        Query<Long> query = session.createQuery("SELECT COUNT(*) FROM Product", Long.class);
        Long count = query.uniqueResult();
        System.out.println("Total Products: " + count);
        
        // Count products with quantity greater than 0
        Query<Long> query1 = session.createQuery("SELECT COUNT(*) FROM Product WHERE quantity > 0", Long.class);
        Long count1 = query1.uniqueResult();
        System.out.println("Available Products: " + count1);
        
        // Count products grouped by description
        Query<Object[]> query2 = session.createQuery("SELECT description, COUNT(*) FROM Product GROUP BY description");
        List<Object[]> list = query2.list();
        for(Object[] row : list) {
            System.out.println(row[0] + " " + row[1]);
        }
        
        // Find minimum and maximum price
        Query<Object[]> query3 = session.createQuery("SELECT MIN(price), MAX(price) FROM Product");
        Object[] result = query3.uniqueResult();
        System.out.println("Min Price: " + result[0]);
        System.out.println("Max Price: " + result[1]);
        
        //commit Transaction
        tx.commit();
        // Close Session
        session.close();
        sf.close();
    }
}
package com.krishsolutions.hibernate.client;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.krishsolutions.hibernate.entity.Customer;
import com.krishsolutions.hibernate.entity.Order;

public class ReadClient {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Order.class).buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.getTransaction();

		transaction.begin();
		
//		Order order = session.get(Order.class,2);
//		
//		System.out.println(order);
		
//		Customer customer = session.get(Customer.class,2);
	
 List<Order> list = session.createQuery("select o from Order o where o.customer.id=:customer_id ",Order.class)
		.setParameter("customer_id", 4).list();
 
 
		System.out.println(list);
		

		transaction.commit();
		session.close();
	}
}

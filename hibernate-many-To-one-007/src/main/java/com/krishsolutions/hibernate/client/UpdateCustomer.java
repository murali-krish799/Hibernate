package com.krishsolutions.hibernate.client;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.krishsolutions.hibernate.entity.Customer;
import com.krishsolutions.hibernate.entity.Order;

public class UpdateCustomer {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Order.class).buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.getTransaction();

		transaction.begin();
		
		Customer customer = session.get(Customer.class, 2);
		customer.setName("srav.");
		
		Order order = session.get(Order.class, 5);
		order.setItemPrice(10);
		
		customer.addOrder(order);
		transaction.commit();
		session.close();
	
	}
}

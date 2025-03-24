package com.krishsolutions.hibernate.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.krishsolutions.hibernate.entity.Customer;
import com.krishsolutions.hibernate.entity.Order;

public class SaveOrder {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Order.class).buildSessionFactory();

		Session session = sessionFactory.openSession();

		
		Transaction transaction = session.getTransaction();

//		Customer customer= new Customer();
//		customer.setName("krish-srav");
//		customer.setOccupation("java developer");

		Customer customer=session.get(Customer.class,2);
		Order order= new Order();
		order.setItemPrice(400.00);
		order.setOrderName("rcb cup of 2025");
		order.setCustomer(customer);
		session.persist(order);
		transaction.begin();
		
		
		
		
		transaction.commit();

		session.close();
	}
}

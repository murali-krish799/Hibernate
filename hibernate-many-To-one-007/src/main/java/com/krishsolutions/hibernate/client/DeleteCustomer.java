package com.krishsolutions.hibernate.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.krishsolutions.hibernate.entity.Customer;
import com.krishsolutions.hibernate.entity.Order;

public class DeleteCustomer {
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Order.class).buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.getTransaction();

		transaction.begin();
		
		Order order = session.get(Order.class, 4);

		order.setCustomer(null);
		
		session.remove(order);;
		transaction.commit();
		session.close();
	}
}
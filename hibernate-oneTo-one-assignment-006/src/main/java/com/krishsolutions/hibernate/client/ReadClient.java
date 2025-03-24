package com.krishsolutions.hibernate.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.krishsolutions.hibernate.entity.Address;
import com.krishsolutions.hibernate.entity.Customer;

public class ReadClient {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Address.class).buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.getTransaction();

		transaction.begin();

		Customer customer = session.get(Customer.class, 1);

		System.out.println(customer.getAddress());
		System.out.println("customer data has been coming soon..." + customer);
		transaction.commit();
		session.close();
	}
}

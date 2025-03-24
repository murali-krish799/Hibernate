package com.krishsolutions.hibernate.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.krishsolutions.hibernate.entity.Address;
import com.krishsolutions.hibernate.entity.Customer;

public class Client {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Address.class).buildSessionFactory();

		Session session = sessionFactory.openSession();

		Address address = new Address();
		address.setStreetName("vinayaka street");
		Customer customer = new Customer();
		customer.setName("krish");
		customer.setOccupation("software");
		customer.setAddress(address);

		Transaction transaction = session.getTransaction();

		transaction.begin();
		session.persist(customer);
		transaction.commit();

		session.close();
	}
}

package com.krishsolutions.hibernate.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.krishsolutions.hibernate.entity.Address;
import com.krishsolutions.hibernate.entity.Customer;

public class DeleteCustomer {
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Address.class).buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.getTransaction();

		transaction.begin();

		// remove only address not customer beacuse cascade type remove avoid here
		Address address = session.get(Address.class, 1);
		address.getCustomer().setAddress(null);

		session.delete(address);

		transaction.commit();
		session.close();
	}
}
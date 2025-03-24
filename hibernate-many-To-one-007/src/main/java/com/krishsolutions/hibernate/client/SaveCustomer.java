package com.krishsolutions.hibernate.client;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.krishsolutions.hibernate.entity.Customer;
import com.krishsolutions.hibernate.entity.Order;

public class SaveCustomer {
	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Order.class).buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.getTransaction();

		Order order1 = new Order();
		order1.setItemPrice(233);
		order1.setOrderName("t shirt");

		Order order2 = new Order();
		order2.setItemPrice(233);
		order2.setOrderName("t shirt");

		Customer customer = new Customer();
		customer.setName("omit-1");
		customer.setOccupation("trailor");
		customer.addOrder(order1);
		customer.addOrder(order2);

		transaction.begin();

		session.persist(customer);

		transaction.commit();
		session.close();

	}

}

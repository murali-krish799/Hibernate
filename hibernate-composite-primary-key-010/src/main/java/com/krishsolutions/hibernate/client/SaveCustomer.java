package com.krishsolutions.hibernate.client;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.krishsolutions.hibernate.entity.Customer;
import com.krishsolutions.hibernate.entity.CustomerId;
import com.krishsolutions.hibernate.entity.Employee;
import com.krishsolutions.hibernate.entity.EmployeeId;
import com.krishsolutions.hibernate.entity.Order;

public class SaveCustomer {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Order.class).buildSessionFactory();

		Session currentSession = sessionFactory.getCurrentSession();

		Transaction transaction = currentSession.getTransaction();

		transaction.begin();

		Order tvOrder = new Order();
		tvOrder.setName("tv");
		tvOrder.setStatus("proccessing...");
		Order phoneOrder = new Order();
		phoneOrder.setName("phone");
		phoneOrder.setStatus("deliveryed...");
		Customer customer = new Customer();
		customer.setRating("5*");
		customer.setVisited(true);
		customer.setCustomerId(new CustomerId("krish", "300.00"));
		customer.addOrders(tvOrder);
		customer.addOrders(phoneOrder);
		currentSession.persist(customer);

		transaction.commit();

	}

}

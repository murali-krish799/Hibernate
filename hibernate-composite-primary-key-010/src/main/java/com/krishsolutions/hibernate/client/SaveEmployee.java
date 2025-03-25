package com.krishsolutions.hibernate.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.krishsolutions.hibernate.entity.Employee;
import com.krishsolutions.hibernate.entity.EmployeeId;

public class SaveEmployee {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session currentSession = sessionFactory.getCurrentSession();

		Transaction transaction = currentSession.getTransaction();

		transaction.begin();

		Employee emp = new Employee();
		emp.setEmployeeId(new EmployeeId("krish", "3+"));
		emp.setLocation("damanellore");
		emp.setRole("java developer");

		currentSession.persist(emp);

		transaction.commit();

	}

}

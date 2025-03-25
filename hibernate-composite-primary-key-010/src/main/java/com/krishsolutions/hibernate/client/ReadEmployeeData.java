package com.krishsolutions.hibernate.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.krishsolutions.hibernate.entity.Employee;
import com.krishsolutions.hibernate.entity.EmployeeId;
import com.krishsolutions.hibernate.entity.Student;
import com.krishsolutions.hibernate.entity.StudentId;

public class ReadEmployeeData {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Employee.class)
				.buildSessionFactory();

		Session session = sessionFactory.openSession();
		Transaction transaction = session.getTransaction();

		transaction.begin();

		Employee employee = session.get(Employee.class, new EmployeeId("krish", "3+"));
		
		System.out.println(employee);
		transaction.commit();

		session.close();

	}

}

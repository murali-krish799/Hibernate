package com.krishsolutions.hibernate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import com.krishsolutions.hibernate.entity.Student;
import com.krishsolutions.hibernate.utility.HibernateUtility;

public class CreateStudent {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();

//			findStudentByName(session, "srav");
//			findByStudentAge(session, 20);
//			findStudentStartWith_A(session,"s");
//sumStudentAgeByName(session);

			sumStudentAgeGroupByName(session);
			session.close();// close the connection of session

		}
	}

	public static void sumStudentAgeGroupByName(Session session) {
		session.beginTransaction();

		NativeQuery<Object[]> nativeQuery = session
				.createNativeQuery("select student_name, avg(student_age) from students group by student_name", Object[].class);

		List<Object[]> list = nativeQuery.list();

		
		list.forEach(array->{
			
			
			System.out.println(array[0]+" "+array[1]);
		});
		session.getTransaction().commit();

	}

	public static void sumStudentAgeByName(Session session) {
		session.beginTransaction();

		NativeQuery<Object[]> nativeQuery = session.createNativeQuery("select sum(student_age) from students ",
				Object[].class);
		List<Object[]> list = nativeQuery.list();

		System.out.println("sum of student student_age " + list);

		session.getTransaction().commit();

	}

	public static void findStudentStartWith_A(Session session, String latter) {

		session.beginTransaction();

		Query<Student> namedQuery = session.createNamedQuery("find_startWith_A_latter", Student.class);
		namedQuery.setParameter("NAMELIKE", latter + "%");
		List<Student> list = namedQuery.list();

		System.out.println(list);

		session.getTransaction().commit();
	}

	public static void findByStudentAge(Session session, int age) {
		session.beginTransaction();

		// sql query means native query it is...direct interact with database
		Query<Student> query = session.createNativeQuery("select * from students", Student.class);
		List<Student> list = query.list();

		list.forEach(System.out::println);

		session.getTransaction().commit();

	}

	public static void findStudentByName(Session session, String name) {

		session.beginTransaction();
//create here named query for instantiation to globally...
		Query<Student> namedQuery = session.createNamedQuery("find_students_ByName", Student.class);
		namedQuery.setParameter("NAME", name);
		List<Student> students = namedQuery.list();

		students.forEach(System.out::println);
		session.getTransaction().commit();
	}

}

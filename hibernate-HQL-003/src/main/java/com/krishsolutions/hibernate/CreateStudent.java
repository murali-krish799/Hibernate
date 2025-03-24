package com.krishsolutions.hibernate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.krishsolutions.hibernate.entity.Student;
import com.krishsolutions.hibernate.utility.HibernateUtility;

public class CreateStudent {

	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtility.getSessionFactory();
		if (sessionFactory != null) {
			Session session = sessionFactory.openSession();

//			saveStudent(session);
//			fetchStudents(session);
//			findStudentAgeAndName(session,30,"sai");
//			findStudentAgeOrName(session, 30, "sai");
//			findStudentBetweenMinAndMaxAge(session, 20, 30);

			findAllStudentsNameAndAge(session);
			session.close();// close the connection of session

		}
	}

	private static void findAllStudentsNameAndAge(Session session) {
		session.beginTransaction();// begin transaction of this particular dml->data manipulation language

		Query<Object[]> query = session.createQuery("select s.name,s.age from  Student s", Object[].class);

		 List<Object[]> list = query.list();

		 Map<String, Object>hashMap=new HashMap<>();
		list.forEach(student->{
			
			hashMap.put((String)student[0],student[1]);
		});

		
		System.out.println(hashMap);
		session.getTransaction().commit();// close the transaction

	}

	public static void findStudentBetweenMinAndMaxAge(Session session, int minAge, int maxAge) {
		session.beginTransaction();// begin transaction of this particular dml->data manipulation language

		Query<Student> query = session.createQuery("from Student where age between :MIN_AGE AND :MAX_AGE",
				Student.class);

		query.setParameter("MIN_AGE", minAge);
		query.setParameter("MAX_AGE", maxAge);

		List<Student> list = query.list();

		list.forEach(System.out::println);
		session.getTransaction().commit();// close the transaction

	}

	public static void findStudentAgeOrName(Session session, int age, String name) {
		session.beginTransaction();// begin transaction of this particular dml->data manipulation language

		Query<Student> query = session.createQuery("from Student where age=:AGE OR name=:NAME", Student.class);
		query.setParameter("AGE", age);
		query.setParameter("NAME", name);

		List<Student> student = query.list();

		student.forEach(System.out::println);
		session.getTransaction().commit();// close the transaction

	}

	public static void findStudentAgeAndName(Session session, int age, String name) {
		session.beginTransaction();// begin transaction of this particular dml->data manipulation language

		Query<Student> query = session.createQuery("from Student where age=?1 AND name=?2", Student.class);

		query.setParameter(1, age);
		query.setParameter(2, name);

		List<Student> students = query.list();

		students.forEach(System.out::println);

		session.getTransaction().commit();// close the transaction

	}

	public static void fetchStudents(Session session) {
		session.beginTransaction();// begin transaction of this particular dml->data manipulation language

		Query<Student> queryStudents = session.createQuery("from Student", Student.class);

		List<Student> students = queryStudents.list();

		for (Student stu : students) {

			System.out.println(stu);
		}

		session.getTransaction().commit();// close the transaction

	}

	public static void saveStudent(Session session) {

		session.beginTransaction();// begin transaction of this particular dml->data manipulation language

		Student student = new Student();
		student.setAge(20);
		student.setName("sai");
		student.setStream("degital entrepreneur");

		session.persist(student);

		session.getTransaction().commit();// close the transaction

		System.out.println("student data has been  inserted into data base ");
	}
}

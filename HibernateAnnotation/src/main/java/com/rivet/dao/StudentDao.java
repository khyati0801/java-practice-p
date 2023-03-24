package com.rivet.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.rivet.Student;

public class StudentDao {

	public static SessionFactory SessionFactory() {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml").addAnnotatedClass(Student.class);

		SessionFactory factory = cfg.buildSessionFactory();
		return factory;
	}

	public static void create(Student e1) {

		Session session = StudentDao.SessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(e1);

		tx.commit();
		session.close();
	}

	public static List<Student> ViewAllStudents() throws ClassNotFoundException, SQLException {

		List<Student> allStudents = new ArrayList<Student>();

		Session session = StudentDao.SessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		allStudents = session.createQuery("from Student").getResultList();

		tx.commit();
		session.close();

		return allStudents;

	}

	public static Student ViewStudentByid(int id) throws ClassNotFoundException, SQLException {

		Student User1 = new Student();

		Session session = StudentDao.SessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		User1 = session.get(Student.class, id);
		
		tx.commit();
		
		session.close();
		return User1;
	}

	public static void DeleteByid(Student Stud) throws SQLException, ClassNotFoundException {

		Session session = StudentDao.SessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.delete(Stud);
		
		
		tx.commit();
		session.close();
	}
	public static void UpdateByid(Student Stud)throws SQLException, ClassNotFoundException {
		Session session = StudentDao.SessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.update(Stud);
		tx.commit();
		session.close();
	}

}

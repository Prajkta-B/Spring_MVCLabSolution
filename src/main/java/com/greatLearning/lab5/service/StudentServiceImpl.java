package com.greatLearning.lab5.service;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.greatLearning.lab5.entity.StudentDetails;

@Repository
public class StudentServiceImpl implements StudentService {

	private SessionFactory sessionFactory;
	
	private Session session;

	@Autowired
	StudentServiceImpl(SessionFactory sessionFactory) {
		// super();
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			// TODO: handle exception
			session = sessionFactory.openSession();
		}
	}

	@Transactional
	public List<StudentDetails> findAll() {
		// TODO Auto-generated method stub
		Transaction tr = session.beginTransaction();
		// find all the records from db
		List<StudentDetails> students = session.createQuery("from StudentDetails").list();
		tr.commit();
		return students;
	}

	@Transactional
	public StudentDetails findById(int theId) {
		// TODO Auto-generated method stub
		StudentDetails student = new StudentDetails();
		Transaction tr = session.beginTransaction();
		// find details by student id
		student = session.get(StudentDetails.class, theId);
		tr.commit();
		return student;
	}

	@Transactional
	public void save(StudentDetails theStudent) {
		// TODO Auto-generated method stub
		Transaction tr = session.beginTransaction();
		// save the details and update
		session.saveOrUpdate(theStudent);
		tr.commit();
	}

	@Transactional
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		Transaction tr = session.beginTransaction();
		// delete the details using id
		StudentDetails studentDetails = session.get(StudentDetails.class, theId);
		session.delete(studentDetails);
		tr.commit();
	}
}

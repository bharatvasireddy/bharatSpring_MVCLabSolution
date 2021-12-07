package com.gl.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gl.model.StudentDetails;
import com.gl.service.StudentService;

@Repository
public class StudentServiceImpl implements StudentService {

	private SessionFactory sessionFactory;
	private Session session;

	@Autowired
	StudentServiceImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException ex) {
			session = sessionFactory.openSession();
		}
	}

	@Transactional
	public List<StudentDetails> findAll() {

		List<StudentDetails> studentdetails = session.createQuery("from StudentDetails").list();
		return studentdetails;
	}

	@Transactional
	public StudentDetails findById(int studentId) {
		StudentDetails sd = session.get(StudentDetails.class, studentId);
		return sd;
	}

	@Transactional
	public void save(StudentDetails mystudentdetails) {

		Transaction transaction = session.beginTransaction();
		session.saveOrUpdate(mystudentdetails);
		transaction.commit();

	}

	@Transactional
	public void deleteById(int studentId) {
		Transaction transaction = session.beginTransaction();
		StudentDetails mystudentdetails = session.get(StudentDetails.class, studentId);
		session.delete(mystudentdetails);
		transaction.commit();

	}

	@Transactional
	public void print(List<StudentDetails> studentdetails) {
		for (StudentDetails sd : studentdetails) {
			System.out.println(sd);
		}
	}

}

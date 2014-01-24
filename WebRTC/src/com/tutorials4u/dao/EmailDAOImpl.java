package com.tutorials4u.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tutorials4u.domain.Email;


import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;


public class EmailDAOImpl implements EmailDAO {

	@SessionTarget
	Session session;
	
	@TransactionTarget
	Transaction transaction;

	/**
	 * Used to save or update a email.
	 */
	public void saveOrUpdateEmail(Email email) {
		try {
			session.saveOrUpdate(email);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	/**
	 * Used to delete a email.
	 */
	public void deleteEmail(String sipuri) {
		try {
			Email email = (Email) session.get(Email.class, sipuri);
			session.delete(email);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} 
	}
	
	/**
	 * Used to list all the emails.
	 */
	@SuppressWarnings("unchecked")
	public List<Email> listEmail() {
		List<Email> courses = null;
		try {
			courses = session.createQuery("from Email").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courses;
	}

	/**
	 * Used to list a single email by Id.
	 */
	public Email listEmailById(String sipuri) {
		Email email = null;
		try {
			email = (Email) session.get(Email.class, sipuri);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return email;
	}


}

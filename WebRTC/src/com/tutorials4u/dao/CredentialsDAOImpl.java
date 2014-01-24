package com.tutorials4u.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;

import com.tutorials4u.domain.Credentials;


public class CredentialsDAOImpl implements CredentialsDAO {
	@SessionTarget
	Session session;
	
	@TransactionTarget
	Transaction transaction;
	


	@Override
	public Credentials searchlogin(String sipuri, String password) {
		Credentials Credentials  = null;
		try {
		//	Credentials  = (Credentials) session.createQuery("FROM Credentials where sipuri='"+sipuri+"' AND password='"+password+"' ").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Credentials;
	}
	


	@Override
	public void saveUser(Credentials Credentials) {
		// TODO Auto-generated method stub
		try {
			session.save(Credentials);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} 
		
	}


	@Override
	public List<Credentials> listCredentials() {
		List<Credentials> courses = null;
		try {
			courses = session.createQuery("from Credentials").list();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return courses;
	}
}

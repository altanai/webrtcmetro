package com.tutorials4u.dao;

import java.util.List;

import com.tutorials4u.domain.Email;



public interface EmailDAO {

	public void saveOrUpdateEmail(Email email);
	public List<Email> listEmail();
	public Email listEmailById(String sipuri);
	public void deleteEmail(String sipuri);
}
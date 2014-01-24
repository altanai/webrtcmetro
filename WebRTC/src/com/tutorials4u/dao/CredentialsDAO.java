package com.tutorials4u.dao;

import java.util.List;

import com.tutorials4u.domain.Credentials;
import com.tutorials4u.domain.User;

public interface CredentialsDAO {
	
	public void saveUser(Credentials credentials);
	public List<Credentials> listCredentials();
	
	public Credentials searchlogin(String sipuri, String password);

}

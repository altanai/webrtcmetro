package com.tcs.dao;

import java.util.ArrayList;

import com.tcs.bean.Login;
import com.tcs.bean.QuestionBean;

public interface MyLoginDao_Interface {
	
	public Login readUserDetails(Login bean);
	public boolean register(Login login);
	public boolean verification(Login bean);
	public Login getData(Login bean);
	public ArrayList<Login> getOwnProfile(Login bean);
	public boolean updateProfile(Login login);
	public Login getUserProfilePic(String userId) ;
	public boolean addFriend(Login login);
	public void writepresence(String status, String sipUri) ;
	public boolean addFriend(String mySipuri, String friendSipUri);
	public void logoutUser(String userId);
	public boolean deleteFrnd(String userId, String friendId);
	public Login getDataFacebook(String sipuri);
	public boolean resetPassword(String sipUri, String password);
	public QuestionBean getAnswer(String sipUri);
}

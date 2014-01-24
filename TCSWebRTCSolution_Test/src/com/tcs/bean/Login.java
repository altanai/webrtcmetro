package com.tcs.bean;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table(name="userdetails")
public class Login {
	
	ArrayList<String> privateIdentityFrd;
	ArrayList<String> privateIdentityNotFrd;
	private String displayName;

	@Id
	@GeneratedValue
	private String publicIdentity;
	private String privateIdentity;
	private String realm;	
	private String password;
	private String secretQuestion;
	private String answer;
	private String picfile;
	private byte [] profilepic;
	ArrayList<String> presenceStatus;
	
	public ArrayList<String> getPresenceStatus() {
		return presenceStatus;
	}
	public void setPresenceStatus(ArrayList<String> presenceStatus) {
		this.presenceStatus = presenceStatus;
	}
	
	public ArrayList<String> getPrivateIdentityNotFrd() {
		return privateIdentityNotFrd;
	}
	public void setPrivateIdentityNotFrd(ArrayList<String> privateIdentityNotFrd) {
		this.privateIdentityNotFrd = privateIdentityNotFrd;
	}

	public String getPicfile() {
		return picfile;
	}
	public void setPicfile(String picfile) {
		this.picfile = picfile;
	}
	public byte[] getProfilepic() {
		return profilepic;
	}
	public void setProfilepic(byte[] profilepic) {
		this.profilepic = profilepic;
	}
	
	
	/*
	 * Friends 
	 */
	public ArrayList<String> getPrivateIdentityFrd() {
		return privateIdentityFrd;
	}
	public void setPrivateIdentityFrd(ArrayList<String> privateIdentityFrd) {
		this.privateIdentityFrd = privateIdentityFrd;
	}
	
	/*
	 * forgotpassword
	 */
	public String getSecretQuestion() {
		return secretQuestion;
	}
	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getPublicIdentity() {
		return publicIdentity;
	}
	public void setPublicIdentity(String publicIdentity) {
		this.publicIdentity = publicIdentity;
	}
	public String getPrivateIdentity() {
		return privateIdentity;
	}
	public void setPrivateIdentity(String privateIdentity) {
		this.privateIdentity = privateIdentity;
	}
	public String getRealm() {
		return realm;
	}
	public void setRealm(String realm) {
		this.realm = realm;
	}	
}

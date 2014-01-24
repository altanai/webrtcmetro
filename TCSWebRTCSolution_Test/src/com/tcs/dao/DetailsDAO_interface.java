package com.tcs.dao;

import java.util.ArrayList;

public interface DetailsDAO_interface {
	public ArrayList<String> findUserInfo(String sipuri);
	public ArrayList<String> findStudents(String sipuri);
	public ArrayList<String> findJobseekers(String sipuri);
	public ArrayList<String> findProfessionals(String sipuri);
}

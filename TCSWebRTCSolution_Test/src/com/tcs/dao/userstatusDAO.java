package com.tcs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import com.tcs.bean.Login;
import com.tcs.bean.QuestionBean;
import com.tcs.util.DbConnection;

public class userstatusDAO {

	//table name ,  loggedin
	//column sipuri varchar
	//column sessionid int 
	//column status  varchar ( active and inactive ) 
	
	
	public String readSessionid(String sipuri) {

		System.out.println("---------- session id ----------");
		String sessionid=null; // sttaus in the datase shoudl be active or inactive 
		Login myDetails= new Login();
		Connection conn=null;			
		conn = DbConnection.getConnection();			
		PreparedStatement ps=null;
		try {				
			String query= "Select sessionid from loggedin where sipuri=? and status='active'";
			ps = conn.prepareStatement(query);
			ps.setString(1, sipuri);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {				
				sessionid=rs.getString(1);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		finally
		{
			DbConnection.closeConnection(conn);
			DbConnection.closeStatement(ps);
		}
		return sessionid;
	}
	
	
	
	public String readStatus(String sipuri, String sessionid) {

		String status=null; // sttaus in the datase shoudl be active or inactive 
		Login myDetails= new Login();
		Connection conn=null;			
		conn = DbConnection.getConnection();			
		PreparedStatement ps=null;
		try {				
			String query= "Select status from loggedin where sipuri=? and sessionid=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, sipuri);
			ps.setString(2, sessionid);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {				
				status=rs.getString(1);
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		finally
		{
			DbConnection.closeConnection(conn);
			DbConnection.closeStatement(ps);
		}
		return status;
	}
	
	
	public String MakeActive(String sipuri ) {

		String status=null; // sttaus in the datase shoudl be active or inactive 
		Login myDetails= new Login();
		Connection conn=null;			
		conn = DbConnection.getConnection();			
		PreparedStatement ps=null;
		
		String sessionid=null;
		
		// Java Random number generator 
		
		Random randomGenerator = new Random();
	     int randomInt = randomGenerator.nextInt(100);
         sessionid=String.valueOf(randomInt);
		
		int result = 0;
		try {				
			String query= "Insert into loggedin( status ,  sipuri , sesssionid) values (?,?,?) ";
			ps = conn.prepareStatement(query);
			ps.setString(1, "active");
			ps.setString(1, sipuri);
			ps.setString(1, sessionid);
			result= ps.executeUpdate();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		finally
		{
			DbConnection.closeConnection(conn);
			DbConnection.closeStatement(ps);
		}
		
		if(result==1)   return sessionid;;
		
			return "none";
	}
	
	
	
	public String MakeInActive(String sipuri) {

		String status=null; // sttaus in the datase shoudl be active or inactive 
		Login myDetails= new Login();
		Connection conn=null;			
		conn = DbConnection.getConnection();			
		PreparedStatement ps=null;
		try {				
			String query= "Select status from loggedin where sipuri=? ";
			ps = conn.prepareStatement(query);
			ps.setString(1, sipuri);
			ResultSet rs = ps.executeQuery();
			
			// entry in table exists 
			while (rs.next()) {				
				status=rs.getString(1);	
			}
		
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		finally
		{
			DbConnection.closeConnection(conn);
			DbConnection.closeStatement(ps);
		}
		return status;
	}
	
	
}

package de.vogella.jersey.todo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import de.vogella.jersey.todo.model.*;

public class todojdbc {

	public static void main(String args[]){
		todojdbc jdbc=new todojdbc();
		
		// set for write operations 
		Todo todo=new Todo("test","testing of modules","Juint framework" );
		jdbc.write(todo);
		
		// set for read operations
		ArrayList<Todo> arr=jdbc.read();
		if(arr!=null)
		   System.out.println(" arr "+ arr.size());
		else 
			System.out.println(" arr is empty");
	}
	
	public ArrayList<Todo> read() {
		
		ArrayList<Todo> arr=new ArrayList<Todo>();
		Connection conn=null;			
		conn = DbConnection.getConnection();			
		PreparedStatement ps=null;
		try {				
			String query= "SELECT * FROM rough.resttable";
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {				
				
				System.out.println(" RS : "+ rs.getString(1)+ rs.getString(2)+ rs.getString(3));
				Todo todo= new Todo();
				todo.setId(rs.getString(1));
				todo.setSummary(rs.getString(2));
				todo.setDescription(rs.getString(3));
				arr.add(todo);
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
		return arr;
	}
	
	
	public void write( Todo t){
		
		Connection conn=null;			
		conn = DbConnection.getConnection();			
		PreparedStatement ps=null;
		try {				
			String query= "Insert into resttable values(?,?,?)";
			
			ps = conn.prepareStatement(query);
			ps.setString(1, t.getId());
			ps.setString(2, t.getSummary());
			ps.setString(3, t.getDescription());
			
			int rs = ps.executeUpdate();

			
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
	}
	
	
	
}

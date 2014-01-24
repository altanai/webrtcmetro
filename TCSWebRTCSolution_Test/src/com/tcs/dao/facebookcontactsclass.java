package com.tcs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.tcs.bean.facebookbean;
import com.tcs.util.DbConnection;



public class facebookcontactsclass {
	
ArrayList<facebookbean> fblist=new ArrayList<facebookbean>();	
	
	public int findfacebookfriends(String facebookusername) 
	{
		int resultOfsearch=0;
		Connection conn=null;			
		conn = DbConnection.getConnection();			
		PreparedStatement ps=null;
		ResultSet rs=null;
		try
		{
			ps=conn.prepareStatement("select sipuri from facebooklogin where facebookusername=?" );
			ps.setString(1,facebookusername);
			rs=ps.executeQuery();
			
			
			if(rs.next())
			{
				resultOfsearch=ps.executeUpdate();
			}
			
			else
			{
					resultOfsearch=0;
			}		
		}
		
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			DbConnection.closeConnection(conn);
			DbConnection.closeStatement(ps);
		}

		return resultOfsearch;
	}

	
}

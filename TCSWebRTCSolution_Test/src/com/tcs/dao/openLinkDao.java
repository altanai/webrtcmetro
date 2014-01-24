package com.tcs.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import com.tcs.bean.openLinkBean;
import com.tcs.util.DbConnection;

public class openLinkDao implements OpenLinkDao_interface{
	
	public int addthirdpartyaccountDetails(openLinkBean tpa) 
		{
			int resultOfInsert=0;
			Connection conn=null;			
			conn = DbConnection.getConnection();			
			PreparedStatement ps=null;
			ResultSet rs=null;
			try
			{
				ps=conn.prepareStatement("Select sipuri from m_otheraccounts where sipuri=?");
				ps.setString(1,tpa.getSipuri());
				rs=ps.executeQuery();
				
				if(rs.next())
				{
					ps=conn.prepareStatement("update m_otheraccounts set  googleid=? , facebookid=? ,twitterid =?, yahooid=? where sipuri=?");		
					//add variables 
					ps.setString(1, tpa.getGoogleid());
					ps.setString(2, tpa.getFacebookid());
					ps.setString(3, tpa.getTwitterid());
					ps.setString(4, tpa.getYahooid());
					ps.setString(5, tpa.getSipuri());
					
					resultOfInsert=ps.executeUpdate();
				}
				
				else
				{
					ps=conn.prepareStatement("insert into m_otheraccounts(sipuri,googleid,twitterid,facebookid,yahooid) values (?,?,?,?,?)");
					ps.setString(1,tpa.getSipuri());
					ps.setString(2,tpa.getGoogleid());
					ps.setString(3,tpa.getTwitterid());
					ps.setString(4,tpa.getFacebookid());
					ps.setString(5,tpa.getYahooid());
					resultOfInsert=ps.executeUpdate();
					
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			finally
			{
				try
				{
					conn.close();
				}catch (SQLException e) {e.printStackTrace();}
			}
			return resultOfInsert;
		}
	
	
	public openLinkBean getAccountDetails(String sipUri){
		Connection conn=null;			
		conn = DbConnection.getConnection();			
		PreparedStatement ps=null;
		ResultSet rs=null;
		openLinkBean acc=new openLinkBean();
		try
		{
			ps=conn.prepareStatement("Select * from m_otheraccounts where sipuri=?");
			ps.setString(1,sipUri);
			rs=ps.executeQuery();
			while(rs.next()){
				acc.setSipuri(rs.getString(1));
				acc.setGoogleid(rs.getString(2));
				acc.setTwitterid(rs.getString(3));
				acc.setFacebookid(rs.getString(4));
				acc.setYahooid(rs.getString(5));
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				conn.close();
			}catch (SQLException e) {e.printStackTrace();}
		}
		return acc;
	}

}


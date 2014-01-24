package advertisment.com.tcs.webrtc.customizeinterest.dao;


import java.sql.*;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import advertisment.com.tcs.webrtc.customizeinterest.bean.CustomizeInterestBean;
import advertisment.com.tcs.webrtc.customizeinterest.controller.CustomizeInterestServlet;


public class CustomizeInterestDao {

	static Logger log = Logger.getLogger(CustomizeInterestDao.class.getName());

	String url;
	String uName;
	String pwd;
	Connection conn=null;
	PreparedStatement ps=null;
	ResultSet rs1=null;
	int rs=0;

	public CustomizeInterestDao(){

		url="jdbc:mysql://10.1.5.11:3306/webrtcdb";
		uName="altanai";
		pwd="altanai";

	}

	public boolean checkDataBase(String id) {
		boolean check=false;
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn=DriverManager.getConnection(url, uName, pwd);
			
			String sql="select * from customizeinterest where sipuri='"+id+"'";

			ps=conn.prepareStatement(sql);
			
			rs1=ps.executeQuery();
			if(rs1.next()){
				check=true;
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return check;
	}

	
	
	public boolean addCustomizeInterest(CustomizeInterestBean cib1,String id){

		boolean add= false;

		try
		{	
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url, uName, pwd);
			
			String sql="Insert into customizeinterest values(?,?,?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, cib1.getAccessories());
			ps.setString(3, cib1.getAutomobile());
			ps.setString(4, cib1.getFoodandEntertainment());

			rs=ps.executeUpdate();
			if(rs==1){
				add=true;
			}
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}


		return add;

	}
	
	
	
	
	public boolean updateCustomizeInterest(CustomizeInterestBean cib, String id) {
		boolean update=false;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn=DriverManager.getConnection(url, uName, pwd);
			String sql="update customizeinterest set accessories=?,automobile=?,foodandentertainment=? where sipuri='"+id+"'";

				ps=conn.prepareStatement(sql);

				ps.setString(1, cib.getAccessories());
				ps.setString(2, cib.getAutomobile());
				ps.setString(3, cib.getFoodandEntertainment());
			rs=ps.executeUpdate();
			if(rs==1){
				update=true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return update;
	}

	
	

	public ArrayList<CustomizeInterestBean> getAccessories(String id){


		ArrayList<CustomizeInterestBean> al1=null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url, uName, pwd);
			al1=new ArrayList<CustomizeInterestBean>();
			CustomizeInterestBean cib=null;
			
			String sql="select accessories from customizeinterest where sipuri='"+id+"'";
			
			ps=conn.prepareStatement(sql);
			rs1=ps.executeQuery();
			while(rs1.next()){
				cib=new CustomizeInterestBean();
				
				if (rs1.getString(1)==null){
				}
				else{
				
				cib.setAccessories(rs1.getString(1));
				al1.add(cib);
				}
			}

		} catch (Exception e) {

			e.printStackTrace();
		}
		return al1;
	}


	public static void main(String[] args) {
		CustomizeInterestDao c=new CustomizeInterestDao();
		c.checkDataBase("sip:bob@tcs.com");

	}



	public ArrayList<CustomizeInterestBean> getAutomobile(String id) {

		ArrayList<CustomizeInterestBean> al2=null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn=DriverManager.getConnection(url, uName, pwd);
			al2=new ArrayList<CustomizeInterestBean>();
			CustomizeInterestBean cib=null;

			String sql="select automobile from customizeinterest where sipuri='"+id+"'";

			ps=conn.prepareStatement(sql);
			rs1=ps.executeQuery();

			while(rs1.next()){
				cib=new CustomizeInterestBean();
				if (rs1.getString(1)==null){
						
				}
				else{
				
				cib.setAutomobile(rs1.getString(1));
				al2.add(cib);}
				log.info("in dao getting value of Automobile from bean : "+cib.getAutomobile());

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al2;

	}



	public ArrayList<CustomizeInterestBean> getFoodAndEntertainment(String id)throws java.lang.NullPointerException
	{
		ArrayList<CustomizeInterestBean> al3=null;

		try {
			Class.forName("com.mysql.jdbc.Driver");

			conn=DriverManager.getConnection(url, uName, pwd);
			log.info("after connection....... of FoodAndEntertainment");
			al3=new ArrayList<CustomizeInterestBean>();
			CustomizeInterestBean cib=null;

			String sql="select foodandEntertainment from customizeinterest where sipuri='"+id+"'";

			ps=conn.prepareStatement(sql);
			log.info("creating statement .....reading FoodAndEntertainment from database ");
			rs1=ps.executeQuery();
			
			while(rs1.next()){
				cib=new CustomizeInterestBean();

				if (rs1.getString(1)==null){
					log.info("no interest of food");	
				}
				else{		
				cib.setFoodandEntertainment(rs1.getString(1));
				al3.add(cib);
				}
				
				log.info("in dao getting value of FoodAndEntertainment from bean : "+cib.getFoodandEntertainment());

		}} catch (Exception e) {

			e.printStackTrace();
		}
		log.info("FoodAndEntertainment is empty: "+al3.isEmpty());
		return al3;
	}

}

	
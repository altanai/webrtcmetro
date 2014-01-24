package advertisment.com.tcs.webrtc.customizeinterest.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import advertisment.com.tcs.webrtc.customizeinterest.bean.CustomizeInterestBean;
import advertisment.com.tcs.webrtc.customizeinterest.dao.CustomizeInterestDao;

/**
 * Servlet implementation class CustomizeInterestServlet
 */
public class CustomizeInterestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(CustomizeInterestServlet.class.getName());
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomizeInterestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Accessories = null;
		String Automobile=null;
		String FoodandEntertainment=null;
		String id="sip:bob@tcs.com";

		String[] accessories = request.getParameterValues("checkboxGroup1");
		String[] automobile= request.getParameterValues("checkboxGroup2");
		String[] foodandEntertainment = request.getParameterValues("checkboxGroup3");
		
		StringBuffer result1 = new StringBuffer();
		StringBuffer result2 = new StringBuffer();
		StringBuffer result3 = new StringBuffer();

		if((accessories!=null)&&(automobile!=null)&&(foodandEntertainment!=null))
		{
			log.info("no null");

			for (int i = 0; i < accessories.length; i++) {

				result1.append( accessories[i] );
				result1.append( "," );
			}
			Accessories = result1.toString();
			for (int i = 0; i < automobile.length; i++) {

				result2.append( automobile[i] );
				result2.append( "," );
			}Automobile = result2.toString();
			for (int i = 0; i < foodandEntertainment.length; i++) {

				result3.append( foodandEntertainment[i] );
				result3.append( "," );
			}FoodandEntertainment = result3.toString();
		}



		else if ((accessories!=null)&&(automobile==null)&&(foodandEntertainment!=null))
		{
			log.info("automobile=null");
			for (int i = 0; i < accessories.length; i++) {

				result1.append( accessories[i] );
				result1.append( "," );
			}Accessories = result1.toString();
			Automobile =null;


			for (int i = 0; i < foodandEntertainment.length; i++) {

				result3.append( foodandEntertainment[i] );
				result3.append( "," );
			}FoodandEntertainment = result3.toString();}

		else if ((accessories==null)&&(automobile!=null)&&(foodandEntertainment!=null))
		{
			log.info("accessories=null");
			Accessories = null;
			for (int i = 0; i < automobile.length; i++) {

				result2.append( automobile[i] );
				result2.append( "," );
			}
			Automobile =result2.toString();


			for (int i = 0; i < foodandEntertainment.length; i++) {

				result3.append( foodandEntertainment[i] );
				result3.append( "," );
			}FoodandEntertainment = result3.toString();}
		
		else if ((accessories!=null)&&(automobile!=null)&&(foodandEntertainment==null)){
			log.info("food=null");
			for (int i = 0; i < accessories.length; i++) {

				result1.append( accessories[i] );
				result1.append( "," );
			}Accessories = result1.toString();
			for (int i = 0; i < automobile.length; i++) {

				result2.append( automobile[i] );
				result2.append( "," );
			}Automobile = result2.toString();
			FoodandEntertainment=null;
		}

		else if ((accessories!=null)&&(automobile==null)&&(foodandEntertainment==null)){
			log.info("automobile & food = null");
			for (int i = 0; i < accessories.length; i++) {

				result1.append( accessories[i] );
				result1.append( "," );
			}Accessories = result1.toString();
			Automobile =null;
			FoodandEntertainment=null;
		}
		else if((accessories==null)&&(automobile!=null)&&(foodandEntertainment==null))
		{
			log.info("accessories & food=null");


			Accessories = null;
			for (int i = 0; i < automobile.length; i++) {

				result2.append( automobile[i] );
				result2.append( "," );
			}Automobile = result2.toString();
			FoodandEntertainment=null;
		}
		else if ((accessories==null)&&(automobile==null)&&(foodandEntertainment!=null))
		{
			log.info("accessories & automobile=null");
			Accessories = null;
			Automobile =null;


			for (int i = 0; i < foodandEntertainment.length; i++) {

				result3.append( foodandEntertainment[i] );
				result3.append( "," );
			}FoodandEntertainment = result3.toString();}
		else{
			log.info("accessories & automobile & food=null");
			Accessories = null;
			Automobile =null;
			FoodandEntertainment=null;
		}

		log.info("accessories = "+Accessories);
		log.info("automobile = "+Automobile);
		log.info("food = "+FoodandEntertainment);

		CustomizeInterestBean cib=new CustomizeInterestBean();
		cib.setAccessories(Accessories);
		cib.setAutomobile(Automobile);
		cib.setFoodandEntertainment(FoodandEntertainment);


		boolean check=new CustomizeInterestDao().checkDataBase(id);
		
		if(check){
	
			boolean update= new CustomizeInterestDao().updateCustomizeInterest(cib,id);
	
			if(update){

				log.info("previous records were present ...........entry updated");

				RequestDispatcher rd=request.getRequestDispatcher("ReadCustomizeInterestServlet?action=viewcustomizeinterest");
				rd.include(request, response);
				
			}
		}


		else{

			boolean add= new CustomizeInterestDao().addCustomizeInterest(cib,id);
			if(add){

				log.info("no previous records were present ...........entry inserted");

				RequestDispatcher rd=request.getRequestDispatcher("ReadCustomizeInterestServlet?action=viewcustomizeinterest");
				rd.include(request, response);
				
			}
		}


	}








	private int Food(CustomizeInterestBean cib, String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

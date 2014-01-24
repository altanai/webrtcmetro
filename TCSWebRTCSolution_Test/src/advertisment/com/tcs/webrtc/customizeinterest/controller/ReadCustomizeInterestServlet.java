package advertisment.com.tcs.webrtc.customizeinterest.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import advertisment.com.tcs.webrtc.customizeinterest.bean.CustomizeInterestBean;
import advertisment.com.tcs.webrtc.customizeinterest.dao.CustomizeInterestDao;

/**
 * Servlet implementation class ReadCustomizeInterestServlet
 */
public class ReadCustomizeInterestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(ReadCustomizeInterestServlet.class.getName());

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReadCustomizeInterestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		String id="sip:bob@tcs.com";
		PrintWriter out=response.getWriter();
		
		if(action.equalsIgnoreCase("viewcustomizeinterest")){
			log.info(action);
			ArrayList<CustomizeInterestBean> al=null;
			al=new CustomizeInterestDao().getAccessories(id);
			ArrayList<CustomizeInterestBean> al1=null;
			al1=new CustomizeInterestDao().getAutomobile(id);
			ArrayList<CustomizeInterestBean> al2=null;
			al2=new CustomizeInterestDao().getFoodAndEntertainment(id);
			if((al.isEmpty())&&(al1.isEmpty())&&(al2.isEmpty())){
				request.getRequestDispatcher("advertisment/CustomizeInterestHomePage.jsp").include(request, response);
				out.println("<h3><font color=red >* No records in the database</font></h3>");
				}
			else {		
				request.setAttribute("Accessorie", al);
				request.setAttribute("Automobile", al1);
				request.setAttribute("FoodAndEntertainment", al2);
				request.getRequestDispatcher("advertisment/ViewCustomizeInterest.jsp").forward(request, response);
				
			}}

			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

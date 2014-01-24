package com.tcs.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.tcs.dao.facebookcontactschecksipuriclass;

/**
 * Servlet implementation class facebookcontactsservlet
 */
@WebServlet("/facebookcontactsservlet")
public class facebookcontacts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public facebookcontacts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	HttpSession session=request.getSession();
		
		String fbfriendname=request.getParameter("fbfriendname");
		fbfriendname=fbfriendname.toLowerCase();
		String[] array = fbfriendname.split(" ");
		String fbfriend_firstname=array[0];
		String fbfriend_lastname=array[0];
		
		facebookcontactschecksipuriclass fbcheck =new facebookcontactschecksipuriclass();
		
		String check =null;
		check=fbcheck.checkexists(fbfriend_firstname);
		System.out.println(" user "+ fbfriendname + " on facebook -->  "+ check);
		
		if(check!=null){
			System.out.println("--- / yes ");
			response.setContentType("text/html");
			response.getWriter().println(check);
		}
		else{
	//	response.sendRedirect();
			System.out.println("-- X No");
			response.setContentType("text/html");
			response.getWriter().println(" Not on WebRTC !");
		}

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println(" Facebook Contacst servlet - POST " );
	}

}

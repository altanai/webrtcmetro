package com.tcs.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.tcs.dao.userstatusDAO;

/**
 * Servlet implementation class sessionservlet
 */

public class sessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(sessionServlet.class.getName());
	  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		log.info("-------session servlet -----------------");
		String sipuri=null;
		String sessionid=null;
		String status= null;
		
		sipuri=request.getParameter("sipuri");
		
		userstatusDAO us= new userstatusDAO();
        sessionid= us.readSessionid(sipuri);
		
        if(sessionid!=null){
        us.MakeInActive(sipuri);
		String newsessionid=us.MakeActive(sipuri);
			// user already exists with some session id 
			// truncate exiting session and create new 
		  response.setHeader("content-application", "text/json");
		  response.getWriter().println("");
        }
        else{
        	
        	// user does not exit with any existing active session 
        	// let the action proceed 
        }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("-------session servlet -----------------");
		String sipuri=null;
		String sessionid=null;
		String status= null;
		
		sipuri=request.getParameter("sipuri");
		
		userstatusDAO us= new userstatusDAO();
        sessionid= us.readSessionid(sipuri);
		
        if(sessionid!=null){
        us.MakeInActive(sipuri);
		String newsessionid=us.MakeActive(sipuri);
			// user already exists with some session id 
			// truncate exiting session and create new 
		  response.setHeader("content-application", "text/json");
		  response.getWriter().println("Logout");
        }
        else{
        	
        	// user does not exit with any existing active session 
        	// let the action proceed 
        	 response.setHeader("content-application", "text/json");
   		  response.getWriter().println("None");
        }
	}

}

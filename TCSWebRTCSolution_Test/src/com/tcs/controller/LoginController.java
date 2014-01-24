package com.tcs.controller;

import org.apache.log4j.Logger;

import java.io.*;
import java.sql.SQLException;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tcs.bean.CallLogs;
import com.tcs.bean.Login;
import com.tcs.dao.MyLoginDao;
import com.tcs.dao.SipCallLogDao;


@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(LoginController.class.getName());
	
	String id, password;
	Login myLoginBean = new Login(); // Making an object of Service Class.
	CallLogs callog=new CallLogs();
	MyLoginDao myLoginDao = new MyLoginDao();
	SipCallLogDao sipCallLogDao=new SipCallLogDao();
	RequestDispatcher rd = null;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String act = request.getParameter("action").toString();
		
		log.info("--------------Login Controller-----------------------");
		
		HttpSession session = request.getSession(false);
		
		String button = request.getParameter("submit");
		PrintWriter out = response.getWriter();
		
		try {
			id = request.getParameter("userName"); // getting value of id from											// textfield of U.I.
			password = request.getParameter("password");// getting value of password from textfield of U.I.
		
			myLoginBean.setPrivateIdentity("sip:" + id);
			myLoginBean.setPassword(password);
			
			Login login = new Login();
			
			if (button.equalsIgnoreCase("Login as Admin")) {
				if (id.equalsIgnoreCase("admin")
						&& password.equalsIgnoreCase("admin")) {
					rd = request.getRequestDispatcher("admincontrolusers.jsp");
					rd.forward(request, response);
				}
			}
			else if(button.equalsIgnoreCase("Login as User")){
					boolean flag = myLoginDao.verification(myLoginBean);
					if (flag) {
						log.info(" mylogdao getdata");
						login = myLoginDao.getData(myLoginBean);
						session = request.getSession(); // generating Session
						log.info("setting to session ");
						session.setAttribute("data", login);
						request.getRequestDispatcher("Dashboard.jsp").forward(request, response);
					//	request.getRequestDispatcher("strutslistUser").forward(request, response);
					//	log.info("forwarding to listuser.action");
					//	getServletContext().getRequestDispatcher("/struts/listUser.action").forward(request, response);
					} else {
						request.setAttribute("error",
								"Login id or password do not match.");
						rd = request.getRequestDispatcher("Login.jsp");
						rd.forward(request, response);
					}			
			}
		}
		 catch (Exception e) {
			log.error(e);
		}	
	}
}
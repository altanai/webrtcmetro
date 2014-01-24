package com.tcs.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tcs.bean.Login;
import com.tcs.dao.MyLoginDao;
import com.tcs.dao.facebooklogindao;

import com.tcs.dao.facebookchecksipuri;

/*import phonebook.userfriends;
 import contacts.webrtc.loaduserfrnds;

 import setups.presentation_server;
 import userprofile.beanclass.registration;*/

/**
 * Servlet implementation class facebooklogin
 */

public class googlelogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public googlelogin() {
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
		System.out.println("Status : Google loginservlet mtd :get");
		String username = request.getParameter("userName");
		username = username.toLowerCase();
		facebookchecksipuri fbcheck = new facebookchecksipuri();

		String check = null;
		check = fbcheck.checkexists(username);
		MyLoginDao myLoginDao = new MyLoginDao();
		Login login = new Login(); // Making an object of Service Class.
		HttpSession session = request.getSession(false);

		facebooklogindao fbdao = new facebooklogindao();
		String sipuri = fbdao.checkexists(username);

		if (sipuri != "" && sipuri != null) {
			login = myLoginDao.getDataFacebook(sipuri);
			session = request.getSession(); // generating Session
			session.setAttribute("data", login);
			request.getRequestDispatcher("Dashboard.jsp").forward(request,
					response);
		} else {
			request.getRequestDispatcher("Login.jsp")
					.forward(request, response);
		}

		request.getRequestDispatcher("Dashboard.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

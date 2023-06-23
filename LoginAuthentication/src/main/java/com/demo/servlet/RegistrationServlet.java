package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.MyUser;
import com.demo.beans.RegisterUser;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;

public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int uid = Integer.parseInt(request.getParameter("uid"));
		String name = request.getParameter("nm");
		String addr = request.getParameter("addr");
		String uname = request.getParameter("uname");
		String passwd = request.getParameter("pass");
		String[] skills = request.getParameterValues("skill");
		String gender = request.getParameter("gender");
		String dt = request.getParameter("dt");
		String city = request.getParameter("city");
		
		LocalDate ldt=LocalDate.parse(dt,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		LoginService ls = new LoginServiceImpl();
		RegisterUser ru = new RegisterUser(uid,name,addr,uname,skills,gender,ldt,city);
		MyUser mu = new MyUser(uname,passwd,"user");
		ls.addRegisterUser(ru,mu);
		
		RequestDispatcher rd =request.getRequestDispatcher("Login.html");
		rd.forward(request, response);
	}

}

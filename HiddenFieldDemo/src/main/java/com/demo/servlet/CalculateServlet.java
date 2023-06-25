package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculateServlet
 */
@WebServlet("/calculate")
public class CalculateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String nm = request.getParameter("name");
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
		int ans = num1+num2;
		
		String msg = (String) request.getAttribute("msg");
		
		out.println("Name : "+nm+"<br>");
		out.println("Number1 : "+num1+"<br>");
		out.println("Number2 : "+num2+"<br>");
		out.println("Answer : "+ans+"<br>");
		out.println("Message : "+msg+"<br>");
	}

}

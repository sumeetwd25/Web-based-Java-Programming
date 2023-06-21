package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ConverterServlet extends HttpServlet {

	private static final DecimalFormat df = new DecimalFormat("0.00");

	private double rate;
	private String msg;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		rate = Double.parseDouble(config.getInitParameter("rate"));
		msg = config.getInitParameter("welcome");
	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		String dollar = req.getParameter("dollar");
		String inr = req.getParameter("inr");

		out.println("<h2>" + msg + "</h2>");
		out.println("<form action='convert' method='get'>");
		out.println("<table border='2'><tr><td>Dollar</td><td>INR</td></tr>");

		if (dollar.equals("")) {
			double d = Double.parseDouble(inr) / rate;
			out.println("<tr><td><input type='number' name='dollar' id='doll' value='" + df.format(d) + "' ></td>");
			out.println("<td><input type='number' name='inr' id='inr' value='" + inr + "' ></td></tr>");
//			out.println("Dollar : " + d);
		} else {
			double i = Double.parseDouble(dollar) * rate;
			out.println("<tr><td><input type='number' name='dollar' id='doll' value='" + dollar + "' ></td>");
			out.println("<td><input type='number' name='inr' id='inr' value='" + df.format(i) + "' ></td></tr>");
//			out.println("Inr : " + i);
		}
		out.println("<tr><td colspan='2'><button type='submit' name='btn' id='btn'>Convert</button></td></tr>");
		out.println("</table></form>");
	}
}

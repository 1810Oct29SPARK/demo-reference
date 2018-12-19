package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4217738150363355737L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//PrintWriter - writes to the response 
		PrintWriter pw = resp.getWriter();
		pw.write("Hello World!");
		//access Servlet Config - params unique to this servlet
		ServletConfig config = getServletConfig();
		pw.println(config.getInitParameter("servletMessage"));
		//access Servlet Context  - params shared by all servlets
		pw.println(config.getServletContext().getInitParameter("applicationMessage"));
	}
}

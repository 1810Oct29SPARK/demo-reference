package com.revature.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CalculatorServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1206242231575746111L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// forward the request (pass the request onto another request handler) 
		RequestDispatcher rd = req.getRequestDispatcher("Calculator.html");
		rd.forward(req, resp);
	}

}

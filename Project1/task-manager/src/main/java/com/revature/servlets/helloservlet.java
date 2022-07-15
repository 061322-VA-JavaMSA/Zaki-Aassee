package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class helloservlet extends HttpServlet {
	
	
	protected void doGet (HttpServletRequest res, HttpServletResponse resp) throws IOException, ServletException {
		
		PrintWriter pw = resp.getWriter();
		pw.write("HI");
		pw.close();
		
	
		
	}
protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// we put behavior to handle POST request 
		// how does Tomcat know to send a request to access to helloservlet 
		// we go to web.xml and put some servlet tags and put the servlet-mapping to map to approperiate servlet , need to servelet name and serlet class
		
		
	}

}

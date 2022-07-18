package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dtos.EmployeeDTO;
import com.revature.exceptions.LoginException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Employee;
import com.revature.services.AuthService;
import com.revature.utils.CorsFix;

public class AuthServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private AuthService as = new AuthService();
	private ObjectMapper om = new ObjectMapper();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException,ServletException{
	CorsFix.addCorsHeader(req.getRequestURI(), resp);
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		
		try {
			Employee current = as.login(username, password);
			HttpSession session = req.getSession();
			session.setAttribute("ers_user_id" , current.getId());
			session.setAttribute("user_role", current.getRole());
			
			// chorme cookie problme solves
			String cookie = resp.getHeader("Set-Cookie") + "; SameSite=None; Secure";
			resp.setHeader("Set-Cookie", cookie);;
			EmployeeDTO currentDTO = new EmployeeDTO(current);
			try (PrintWriter pw = resp.getWriter()){
				pw.write(om.writeValueAsString(currentDTO));
				resp.setStatus(200);
			}
				
		}catch (UserNotFoundException | LoginException e ) {
			resp.sendError(400, "Wrong Credentials!");
			e.printStackTrace();
		}
	}
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		CorsFix.addCorsHeader(req.getRequestURI(), resp);
		
		HttpSession session = req.getSession();
		
		session.invalidate();
	}
	
	

	@Override
	protected void doOptions(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		CorsFix.addCorsHeader(req.getRequestURI(),resp);
		super.doOptions(req, resp);
	}
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		CorsFix.addCorsHeader(req.getRequestURI(), resp);
		resp.addHeader("Content-Type", "application/json");
	
	}
}
	



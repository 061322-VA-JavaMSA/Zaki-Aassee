package com.revature.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dtos.EmployeeDTO;
import com.revature.exceptions.UserNotCreatedException;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.services.EmployeeService;
import com.revature.utils.CorsFix;

public class EmployeeServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private EmployeeService es = new EmployeeService();

	private ObjectMapper om = new ObjectMapper();

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		CorsFix.addCorsHeader(req.getRequestURI(), resp);
		resp.addHeader("Content-Type", "application/json");
		
//		PrintWriter pw = resp.getWriter();
//		pw.write("welcome to servlet");
//		pw.close();
//	
//		
		String pathInfo = req.getPathInfo();

		if (pathInfo == null) {
			HttpSession session = req.getSession();

			//if (session.getAttribute("user_role") != null && session.getAttribute("user_role").equals(Role.ADMIN)) {

				List<Employee> employees = es.getEmployees();
				List<EmployeeDTO> employeeDTO = new ArrayList<>();

				employees.forEach(em -> employeeDTO.add(new EmployeeDTO(em)));// convert employes to EmployeeDTO for
																				// data transfer

				PrintWriter pw = resp.getWriter();// to write to the response body

				pw.write(om.writeValueAsString(employeeDTO));
				pw.close();

//			} else {
//				resp.sendError(404, "Unauthorized Access");
//			}
		} else {
			int id = Integer.parseInt(pathInfo.substring(1));

			try (PrintWriter pw = resp.getWriter()) {
				Employee em = es.getEmployeeById(id);
				EmployeeDTO eDTO = new EmployeeDTO(em);

				pw.write(om.writeValueAsString(eDTO));

				resp.setStatus(200);

			} catch (UserNotFoundException e) {

				resp.setStatus(404);
				e.printStackTrace();

			}

		}

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

		InputStream reqBody = req.getInputStream();
		Employee newEmployee = om.readValue(reqBody, Employee.class);

		try {
			es.createEmployee(newEmployee);
			resp.setStatus(201);
		} catch (UserNotCreatedException e) {
			resp.sendError(400, "Can not create new Employee.");
			e.printStackTrace();
		}

	}

}

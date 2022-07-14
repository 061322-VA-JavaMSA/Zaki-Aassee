package com.revature.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.type.descriptor.java.LocalDateJavaType;
import org.hibernate.type.descriptor.java.LocalDateTimeJavaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dtos.ReimbursementDTO;
import com.revature.exceptions.ItemNotCreatedException;
import com.revature.exceptions.ItemNotFoundException;
import com.revature.models.ReStatus;
import com.revature.models.ReimbMain;
import com.revature.services.ReStatusService;
import com.revature.services.ReimbursementService;
import com.revature.utils.CorsFix;

public class ReimbursementServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	
	private ReimbursementService rs = new ReimbursementService();
	private ObjectMapper om = new ObjectMapper();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		resp.addHeader("Content-Type", "application/json");
		
		String pathInfo = req.getPathInfo();
		if (pathInfo == null) {
			
			HttpSession session = req.getSession();
			List< ReimbMain> reimbursements = rs.getReimbursements();
			List<ReimbursementDTO> reimbDTO = new ArrayList<>();
			
			reimbursements.forEach(rm -> reimbDTO.add(new ReimbursementDTO(rm)));
			
			PrintWriter pw = resp.getWriter();
			pw.write(om.writeValueAsString(reimbDTO));
			
			pw.close();
			
			
		} else {
			int id = Integer.parseInt(pathInfo.substring(1)
					);
			
			try (PrintWriter pw = resp.getWriter()){
				ReimbMain rm = rs.getReimbursementsById(id);
				ReimbursementDTO rDTO = new ReimbursementDTO();
				pw.write(om.writeValueAsString(rDTO));
				
				resp.setStatus(200);
			}
			 catch (ItemNotCreatedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}

		
	}
	
	protected void doPost (HttpServletRequest req , HttpServletResponse resp) throws IOException, ServletException {

		String pathInfo = req.getPathInfo();
		InputStream reqBody = req.getInputStream();
		
		ReimbMain newReimb = om.readValue(reqBody, ReimbMain.class);
		
		try {
			
			rs.insertReimb(newReimb);
			resp.setStatus(201);
			
		}
		catch (ItemNotCreatedException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
}



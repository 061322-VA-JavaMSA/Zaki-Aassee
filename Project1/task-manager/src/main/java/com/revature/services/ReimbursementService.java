package com.revature.services;

import java.sql.SQLException;
import java.util.List;

import javax.print.DocFlavor.READER;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.daos.EmployeeHibernate;
import com.revature.daos.ReimbursementDAO;
import com.revature.daos.ReimbursementHibernate;
import com.revature.exceptions.ItemNotCreatedException;
import com.revature.exceptions.ItemNotFoundException;
import com.revature.models.ReimbMain;
import com.revature.models.ReStatus;
public class ReimbursementService {
	private static Logger log = LogManager.getLogger(ReimbMain.class);
	
	public ReimbursementDAO rd = new ReimbursementHibernate();
	
	
	
	public ReimbMain insertReimb (ReimbMain rm) throws ItemNotCreatedException {
		
	
		ReimbMain insertedReimb = rd.insertReimbursement(rm);
		if (insertedReimb.getReimb_Id() == -1) {   // comment this 
			
			throw new ItemNotCreatedException();
			
		}
		log.info("New Reimbursement Request", insertedReimb);
		return  insertedReimb;
	
		
	}
	
	public ReimbMain getReimbursementsById(int id) throws ItemNotFoundException, SQLException {
		
		
		ReimbMain rm = rd.getReimbursementById(id);
		if (rm == null) { throw new ItemNotFoundException();}
		
		return rm;
		
	}
	
	public List<ReimbMain> getReimbursements (){
		List<ReimbMain> rm = rd.getReimbursements();
		log.info("list reimbursements", rm);
		return rm;
		
	}
	public ReimbMain updateReimb (ReimbMain update)throws ItemNotCreatedException {
		ReimbMain updated = rd.updateReimbursement(update);
		
		return updated;
		
	}
	
	public ReimbMain deleteReimb (ReimbMain delete) {
		ReimbMain deleted = rd.deleteReimbursement(delete);
		
		return deleted;
		
	}
	

}

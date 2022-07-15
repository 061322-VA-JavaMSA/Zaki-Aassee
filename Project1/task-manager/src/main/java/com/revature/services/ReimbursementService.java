package com.revature.services;

import java.util.List;

import javax.print.DocFlavor.READER;

import com.revature.daos.EmployeeHibernate;
import com.revature.daos.ReimbursementDAO;
import com.revature.daos.ReimbursementHibernate;
import com.revature.exceptions.ItemNotCreatedException;
import com.revature.models.ReimbMain;

public class ReimbursementService {
	
	public ReimbursementDAO rd = new ReimbursementHibernate();
	
	public ReimbMain insertReimb (ReimbMain rm) throws ItemNotCreatedException {
		
		ReimbMain insertedReimb = rd.insertReimbursement(rm);
//		if (insertedReimb.getReimb_Id() == -1) {
//			throw new ItemNotCreatedException();
//			
//		}
		return  insertedReimb;
		
	}
	
	public ReimbMain getReimbursementsById(int id) throws ItemNotCreatedException {
		
		
		ReimbMain rm = rd.getReimbursementById(id);
		if (rm == null) { throw new ItemNotCreatedException();}
		
		return rm;
		
	}
	
	public List<ReimbMain> getReimbursements (){
		List<ReimbMain> rm = rd.getReimbursements();
		
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

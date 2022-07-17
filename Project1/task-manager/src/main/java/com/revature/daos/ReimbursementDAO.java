package com.revature.daos;

import java.util.List;

import com.revature.models.ReimbMain;

public interface ReimbursementDAO {
	
	ReimbMain insertReimbursement (ReimbMain r);
	ReimbMain updateReimbursement (ReimbMain r);
	List<ReimbMain> getReimbursements();
	List<ReimbMain> getReimbursementByStatus (ReimbMain r);
	List<ReimbMain> getReimbursementByResolver(int id);
	ReimbMain getReimbursementById (int id);
	ReimbMain deleteReimbursement (ReimbMain r);

	
	
	
	
	

}

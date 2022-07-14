package com.revature.services;

import com.revature.daos.ReStatusDAO;
import com.revature.daos.ReStatusHibernate;
import com.revature.exceptions.ItemNotCreatedException;
import com.revature.exceptions.ItemNotFoundException;
import com.revature.models.ReStatus;

public class ReStatusService {
	
	
	private ReStatusDAO rsd = new ReStatusHibernate();
	
	public ReStatus getStatus (String state) throws  ItemNotFoundException {
		
		ReStatus rs = rsd.getStatusByState(state);
		
		if (rsd== null) {
			throw new ItemNotFoundException();
		}
		
		return rs;
		
	}
	public ReStatus getStatusById(int id ) throws ItemNotFoundException {
		ReStatus rs = rsd.getStatusById(id);
		
		if (rs == null) {
			throw new ItemNotFoundException();
			
		}
		return rs;
		
	}
}

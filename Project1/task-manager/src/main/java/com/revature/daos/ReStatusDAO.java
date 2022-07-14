package com.revature.daos;

import com.revature.models.ReStatus;

public interface ReStatusDAO {
	
	ReStatus getStatusById(int id);
	ReStatus getStatusByState (String state);
	

}

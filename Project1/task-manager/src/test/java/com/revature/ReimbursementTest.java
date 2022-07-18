package com.revature;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.revature.daos.ReimbursementDAO;
import com.revature.exceptions.ItemNotFoundException;
import com.revature.services.ReimbursementService;

public class ReimbursementTest {
	
	@Mock
	private static ReimbursementDAO testReimb;

	@InjectMocks
	private static ReimbursementService rs;

	@BeforeAll
	public static void setup() {
		rs = new ReimbursementService();
	}
	
	
	@Test
	public void getReimbursementByIdDoesNotExist() throws ItemNotFoundException {

		Mockito.when(testReimb.getReimbursementById(999)).thenReturn(null);

		assertThrows(ItemNotFoundException.class, () -> rs.getReimbursementsById(999));
	}


}

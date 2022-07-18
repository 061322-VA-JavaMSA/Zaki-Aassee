package com.revature;

import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.naming.AuthenticationException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.revature.daos.EmployeeDAO;
import com.revature.exceptions.UserNotFoundException;
import com.revature.models.Employee;
import com.revature.models.Role;
import com.revature.services.AuthService;

public class AuthTest {
	
	
	@Mock
	private static EmployeeDAO testuser;

	@InjectMocks
	private static AuthService sut;

	@BeforeAll
	public static void setup() {
		sut = new AuthService();
	}



	@Test
	public void loginPasswordMismatch() throws UserNotFoundException, AuthenticationException {
		String username = "admin";
		String password = "pass00";
		
		
		Employee expecteduser = new Employee();
		expecteduser.setId(2);
		expecteduser.setUsername("admin");
		expecteduser.setPassword("pass00");
		expecteduser.setFirstname("admin");
		expecteduser.setLastname("admin");
		expecteduser.setRole(Role.ADMIN);
		
		
	

		Mockito.when(testuser.getEmployeeByUsername(username)).thenReturn(expecteduser);

		assertThrows(AuthenticationException.class, () -> sut.login(username, password));
	}

}

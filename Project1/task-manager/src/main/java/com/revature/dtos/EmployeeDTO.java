package com.revature.dtos;

import java.util.Objects;

import com.revature.models.Employee;
import com.revature.models.Role;

public class EmployeeDTO {
	
	private int id;
	private String username ;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private Role role;
	
	public EmployeeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public EmployeeDTO(Employee em) {
		id = em.getId();
		username = em.getUsername();
		role= em.getRole();
		password= em.getPassword();		
		firstname= em.getFirstname();
		lastname= em.getLastname();
		
				;}

	@Override
	public int hashCode() {
		return Objects.hash(email, firstname, id, lastname, password, role, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeDTO other = (EmployeeDTO) obj;
		return Objects.equals(email, other.email) && Objects.equals(firstname, other.firstname) && id == other.id
				&& Objects.equals(lastname, other.lastname) && Objects.equals(password, other.password)
				&& role == other.role && Objects.equals(username, other.username);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", username=" + username + ", password=" + password + ", firstname="
				+ firstname + ", lastname=" + lastname + ", email=" + email + ", role=" + role + "]";
	}
	
	

	
	
	
	
	

}

package com.revature.dtos;

import java.util.Objects;

import com.revature.models.Employee;
import com.revature.models.Role;

public class EmployeeDTO { // Data Transfer object, represent the resoure without sensitive information for data trnsfer
	
	
	private int id;
	private String userName ;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private Role role;
	
	public EmployeeDTO() {
		super();
	
	}
	
	public EmployeeDTO(Employee em) {
		id = em.getId();
		userName = em.getUsername();
		password= em.getPassword();
		firstname = em.getFirstname();
		lastname = em.getLastname();
		role= em.getRole();
		
		
				}
	

	@Override
	public int hashCode() {
		return Objects.hash(email, firstname, id, lastname, password, role, userName);
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
				&& role == other.role && Objects.equals(userName, other.userName);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String username) {
		this.userName = username;
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
		return "EmployeeDTO [id=" + id + ", username=" + userName + ", password=" + password + ", firstname="
				+ firstname + ", lastname=" + lastname + ", email=" + email + ", role=" + role + "]";
	}
	
	

	
	
	
	
	

}

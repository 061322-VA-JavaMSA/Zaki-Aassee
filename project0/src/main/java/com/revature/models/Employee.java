package com.revature.models;

import java.util.Objects;

public class Employee {
	
	private int id;
	private String employeName;
	private String employeeUsername;
	private String employeePassword;
	private String employeeRole;
	private String employeeAssignedCategory;
	Item itemCategory;
	
	public Employee() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployeName() {
		return employeName;
	}

	public void setEmployeName(String employeName) {
		this.employeName = employeName;
	}

	public String getEmployeeUsername() {
		return employeeUsername;
	}

	public void setEmployeeUsername(String employeeUsername) {
		this.employeeUsername = employeeUsername;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	public String getEmployeeRole() {
		return employeeRole;
	}

	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}

	public String getEmployeeAssignedCategory() {
		return employeeAssignedCategory;
	}

	public void setEmployeeAssignedCategory(String employeeAssignedCategory) {
		this.employeeAssignedCategory = employeeAssignedCategory;
	}

	public Item getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(Item itemCategory) {
		this.itemCategory = itemCategory;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", employeName=" + employeName + ", employeeUsername=" + employeeUsername
				+ ", employeePassword=" + employeePassword + ", employeeRole=" + employeeRole
				+ ", employeeAssignedCategory=" + employeeAssignedCategory + ", itemCategory=" + itemCategory + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(employeName, employeeAssignedCategory, employeePassword, employeeRole, employeeUsername, id,
				itemCategory);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(employeName, other.employeName)
				&& Objects.equals(employeeAssignedCategory, other.employeeAssignedCategory)
				&& Objects.equals(employeePassword, other.employeePassword)
				&& Objects.equals(employeeRole, other.employeeRole)
				&& Objects.equals(employeeUsername, other.employeeUsername) && id == other.id
				&& Objects.equals(itemCategory, other.itemCategory);
	}
	
	
	

}

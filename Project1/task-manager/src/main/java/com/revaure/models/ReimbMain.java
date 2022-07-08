package com.revaure.models;

import java.time.LocalDate;

public class ReimbMain {
	private int id;
	private String descripion ;
	private LocalDate dueDate;
	private String status;
	private Employee userAssigned;
	
	public ReimbMain() {
		super();


	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripion() {
		return descripion;
	}

	public void setDescripion(String descripion) {
		this.descripion = descripion;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Employee getUserAssigned() {
		return userAssigned;
	}

	public void setUserAssigned(Employee userAssigned) {
		this.userAssigned = userAssigned;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", descripion=" + descripion + ", dueDate=" + dueDate + ", status=" + status
				+ ", userAssigned=" + userAssigned + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripion == null) ? 0 : descripion.hashCode());
		result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((userAssigned == null) ? 0 : userAssigned.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimbMain other = (ReimbMain) obj;
		if (descripion == null) {
			if (other.descripion != null)
				return false;
		} else if (!descripion.equals(other.descripion))
			return false;
		if (dueDate == null) {
			if (other.dueDate != null)
				return false;
		} else if (!dueDate.equals(other.dueDate))
			return false;
		if (id != other.id)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (userAssigned == null) {
			if (other.userAssigned != null)
				return false;
		} else if (!userAssigned.equals(other.userAssigned))
			return false;
		return true;
	}
	
	
	

}

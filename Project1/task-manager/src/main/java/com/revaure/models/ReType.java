package com.revaure.models;

public class ReType {
	private int id;
	private String reimbType;
	
	
	
	public ReType() {
		super();


	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getReimbType() {
		return reimbType;
	}



	public void setReimbType(String reimbType) {
		this.reimbType = reimbType;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((reimbType == null) ? 0 : reimbType.hashCode());
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
		ReType other = (ReType) obj;
		if (id != other.id)
			return false;
		if (reimbType == null) {
			if (other.reimbType != null)
				return false;
		} else if (!reimbType.equals(other.reimbType))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "ReType [id=" + id + ", reimbType=" + reimbType + "]";
	}
	

}

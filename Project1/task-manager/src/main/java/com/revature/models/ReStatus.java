package com.revature.models;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ers_reimb_status")

public class ReStatus {
	
	@Id
	@Column(name="reimb_status_id")
	private int id;
	@Column(name="reimb_status")
	private String reStatus ;
	
	
	
	
	public ReStatus() {
		super();
		// TODO Auto-generated constructor stub
	}




	@Override
	public int hashCode() {
		return Objects.hash(id, reStatus);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReStatus other = (ReStatus) obj;
		return id == other.id && Objects.equals(reStatus, other.reStatus);
	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getReStatus() {
		return reStatus;
	}




	public void setReStatus(String reStatus) {
		this.reStatus = reStatus;
	}




	@Override
	public String toString() {
		return "ReStatus [id=" + id + ", reStatus=" + reStatus + "]";
	}
	
		
	
	
}




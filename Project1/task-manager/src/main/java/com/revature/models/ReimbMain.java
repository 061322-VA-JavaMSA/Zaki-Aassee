package com.revature.models;

import java.sql.Blob;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

import org.hibernate.type.descriptor.java.LocalDateJavaType;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name="ers_main")

public class ReimbMain {
	@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY) 
	
	@Column(name="reimb_id")
	private int id;
	@Column(name = "reimb_amount")
	private int amount;
 
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="reimb_submitted")
	private Timestamp sub_Date;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="reimb_resolved")
	private Timestamp res_Date;
	@Column(name="reimb_description")
	private String description ;
	@Column(name="reimb_receipt")
	private String a;
	@ManyToOne
	@JoinColumn(name="reimb_author")
	private Employee author;
	@ManyToOne
	@JoinColumn(name="reimb_resolver")
	private Employee userAssigned;// resolver
	@ManyToOne
	@JoinColumn(name="reimb_status_id")
	private ReStatus reimb_Status_Id;
	@ManyToOne
	@JoinColumn(name="reimb_type_id")
	private ReType reimb_Type_Id;
	

	
	
	public ReimbMain() {
		super();
	}



	public int getReimb_Id() {
		return id;
	}




	public void setReimb_Id(int id) {
		this.id = id;
	}




	public int getAmount() {
		return amount;
	}



	public void setAmount(int amount) {
		this.amount = amount;
	}




	public Timestamp getSub_Date() {
		return sub_Date;
	}




	public void setSub_Date(Timestamp sub_Date) {
		this.sub_Date = sub_Date;
	}




	public Timestamp getRes_Date() {
		return res_Date;
	}




	public void setRes_Date(Timestamp res_Date) {
		this.res_Date = res_Date;
	}




	public String getDescripion() {
		return description;
	}




	public void setDescripion(String description) {
		this.description = description;
	}




	public String getReceipt() {
		return a;
	}




	public void setReceipt(String a) {
		this.a = a;
	}




	public Employee getAuthor() {
		return author;
	}




	public void setAuthor(Employee author) {
		this.author = author;
	}




	public Employee getUserAssigned() {
		return userAssigned;
	}




	public void setUserAssigned(Employee userAssigned) {
		this.userAssigned = userAssigned;
	}




	public ReStatus getReimb_Status_Id() {
		return reimb_Status_Id;
	}




	public void setReimb_Status_Id(ReStatus reimb_Status_Id) {
		this.reimb_Status_Id = reimb_Status_Id;
	}




	public ReType getReimb_Type_Id() {
		return reimb_Type_Id;
	}




	public void setReimb_Type_Id(ReType reimb_Type_Id) {
		this.reimb_Type_Id = reimb_Type_Id;
	}




	@Override
	public String toString() {
		return "ReimbMain [Reimb_Id=" + id + ", amount=" + amount + ", sub_Date=" + sub_Date + ", res_Date="
				+ res_Date + ", description=" + description + ", a=" + a + ", author=" + author
				+ ", userAssigned=" + userAssigned + ", reimb_Status_Id=" + reimb_Status_Id + ", reimb_Type_Id="
				+ reimb_Type_Id + "]";
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((a == null) ? 0 : a.hashCode());
		result = prime * result + id;
		result = prime * result + ((reimb_Status_Id == null) ? 0 : reimb_Status_Id.hashCode());
		result = prime * result + ((reimb_Type_Id == null) ? 0 : reimb_Type_Id.hashCode());
		result = prime * result + ((res_Date == null) ? 0 : res_Date.hashCode());
		result = prime * result + ((sub_Date == null) ? 0 : sub_Date.hashCode());
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
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (a == null) {
			if (other.a != null)
				return false;
		} else if (!a.equals(other.a))
			return false;
		if (id != other.id)
			return false;
		if (reimb_Status_Id == null) {
			if (other.reimb_Status_Id != null)
				return false;
		} else if (!reimb_Status_Id.equals(other.reimb_Status_Id))
			return false;
		if (reimb_Type_Id == null) {
			if (other.reimb_Type_Id != null)
				return false;
		} else if (!reimb_Type_Id.equals(other.reimb_Type_Id))
			return false;
		if (res_Date == null) {
			if (other.res_Date != null)
				return false;
		} else if (!res_Date.equals(other.res_Date))
			return false;
		if (sub_Date == null) {
			if (other.sub_Date != null)
				return false;
		} else if (!sub_Date.equals(other.sub_Date))
			return false;
		if (userAssigned == null) {
			if (other.userAssigned != null)
				return false;
		} else if (!userAssigned.equals(other.userAssigned))
			return false;
		return true;
	}
	
	
	
	

}

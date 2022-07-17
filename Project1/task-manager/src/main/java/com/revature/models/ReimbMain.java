package com.revature.models;


import java.sql.Date;

import java.util.Objects;
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
 
	@Temporal(TemporalType.DATE)
	@Column(name="reimb_submitted")
	private Date sub_Date;
	@Temporal(TemporalType.DATE)
	@Column(name="reimb_resolved")
	private Date res_Date;
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
	@Column(name="status")
	private String status;
	
	
	public ReimbMain() {
		super();
	}



	public int getReimb_Id() {
		return id;
	}




	public void setReimb_Id(int id) {
		this.id = id;
	}




	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public int getAmount() {
		return amount;
	}



	public void setAmount(int amount) {
		this.amount = amount;
	}




	public Date getSub_Date() {
		return sub_Date;
	}




	public void setSub_Date(Date sub_Date) {
		this.sub_Date = sub_Date;
	}




	public Date getRes_Date() {
		return res_Date;
	}




	public void setRes_Date(Date res_Date) {
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
		return "ReimbMain [status=" + status + "]";
	}




	@Override
	public int hashCode() {
		return Objects.hash(status);
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
		return Objects.equals(status, other.status);
	}

}

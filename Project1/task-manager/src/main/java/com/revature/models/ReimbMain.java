package com.revature.models;

import java.sql.Blob;
import java.time.LocalDate;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "reimb_id")
	private int reimb_Id;
	@Column(name = "reimb_amount")
	private int amount;
 
	@Temporal(TemporalType.DATE)
	@Column(name="reimb_submitted")
	private LocalDate sub_Date;
	@Temporal(TemporalType.DATE)
	@Column(name="reimb_resolved")
	private LocalDate res_Date;
	@Column(name="reimb_description")
	private String descripion ;
	@Column(name="reimb_receipt" ,columnDefinition="bytea")
	private Blob receipt;
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
		return reimb_Id;
	}




	public void setReimb_Id(int reimb_Id) {
		this.reimb_Id = reimb_Id;
	}




	public double getAmount() {
		return amount;
	}




	public void setAmount(int amount) {
		this.amount = amount;
	}




	public LocalDate getSub_Date() {
		return sub_Date;
	}




	public void setSub_Date(LocalDate sub_Date) {
		this.sub_Date = sub_Date;
	}




	public LocalDate getRes_Date() {
		return res_Date;
	}




	public void setRes_Date(LocalDate res_Date) {
		this.res_Date = res_Date;
	}




	public String getDescripion() {
		return descripion;
	}




	public void setDescripion(String descripion) {
		this.descripion = descripion;
	}




	public Blob getReceipt() {
		return receipt;
	}




	public void setReceipt(Blob receipt) {
		this.receipt = receipt;
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
		return "ReimbMain [reimb_Id=" + reimb_Id + ", amount=" + amount + ", sub_Date=" + sub_Date + ", res_Date="
				+ res_Date + ", descripion=" + descripion + ", receipt=" + receipt + ", author=" + author
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
		result = prime * result + ((descripion == null) ? 0 : descripion.hashCode());
		result = prime * result + ((receipt == null) ? 0 : receipt.hashCode());
		result = prime * result + reimb_Id;
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
		if (descripion == null) {
			if (other.descripion != null)
				return false;
		} else if (!descripion.equals(other.descripion))
			return false;
		if (receipt == null) {
			if (other.receipt != null)
				return false;
		} else if (!receipt.equals(other.receipt))
			return false;
		if (reimb_Id != other.reimb_Id)
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

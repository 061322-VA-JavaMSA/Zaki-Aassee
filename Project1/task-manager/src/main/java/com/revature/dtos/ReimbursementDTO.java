package com.revature.dtos;

import java.sql.Blob;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Objects;
import com.fasterxml.jackson.datatype.jsr310.deser.key.*;
import com.revature.models.Employee;
import com.revature.models.ReimbMain;

//@SuppressWarnings("unused")
public class ReimbursementDTO {
	private int id;
	private int amount ;
	private Timestamp submittted;
	private Timestamp resolved;
	private String description;
	private String a;
	private Employee reimb_author;
	private int reimb_resolver;
	private int reimb_status_id;
	private int reimb_type_id;
	
	public ReimbursementDTO() {
		super();
	}
	public ReimbursementDTO (ReimbMain rm) {
		id = rm.getReimb_Id();
		amount = rm.getAmount();
		submittted= rm.getSub_Date();
	
		resolved= rm.getRes_Date();
	
		description= rm.getDescripion();
		//reimb_author = rm.getAuthor();
		a = rm.getReceipt();
		
		
		
		
		
	}

	public int getReimb_Id() {
		return id;
	}


	public void setReim_Id(int id) {
		this.id = id;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public Timestamp getSubmitted() {
		return submittted;
	}


	public void setSubmitted(Timestamp submitted) {
		this.submittted = submitted;
	}


	public Timestamp getResolved() {
		return resolved;
	}


	public void setResolved(Timestamp resolved) {
		this.resolved = resolved;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getReceipt() {
		return a;
	}


	public void setReceipt(String a) {
		this.a = a;
	}


	public Employee getReimb_author() {
		return reimb_author;
	}


	public void setReimb_author(Employee reimb_author) {
		this.reimb_author = reimb_author;
	}


	public int getReimb_resolver() {
		return reimb_resolver;
	}


	public void setReimb_resolver(int reimb_resolver) {
		this.reimb_resolver = reimb_resolver;
	}


	public int getReimb_status_id() {
		return reimb_status_id;
	}


	public void setReimb_status_id(int reimb_status_id) {
		this.reimb_status_id = reimb_status_id;
	}


	public int getReimb_type_id() {
		return reimb_type_id;
	}


	public void setReimb_type_id(int reimb_type_id) {
		this.reimb_type_id = reimb_type_id;
	}


	@Override
	public int hashCode() {
		return Objects.hash(amount, description, id, a, reimb_author, reimb_resolver, reimb_status_id,
				reimb_type_id, resolved, submittted);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReimbursementDTO other = (ReimbursementDTO) obj;
		return amount == other.amount && Objects.equals(description, other.description) && id == other.id
				&& Objects.equals(a, other.a) && reimb_author == other.reimb_author
				&& reimb_resolver == other.reimb_resolver && reimb_status_id == other.reimb_status_id
				&& reimb_type_id == other.reimb_type_id && Objects.equals(resolved, other.resolved)
				&& Objects.equals(submittted, other.submittted);
	}


	@Override
	public String toString() {
		return "ReimbursementDTO [Reimb_Id=" + id + ", amount=" + amount + ", submitted=" + submittted + ", resolved="
				+ resolved + ", description=" + description + ", a=" + a + ", reimb_author=" + reimb_author
				+ ", reimb_resolver=" + reimb_resolver + ", reimb_status_id=" + reimb_status_id + ", reimb_type_id="
				+ reimb_type_id + "]";
	}
	
	

}
package com.revature.daos;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import com.revature.exceptions.ItemNotCreatedException;
import com.revature.exceptions.ItemNotFoundException;
import com.revature.models.ReStatus;
import com.revature.models.ReimbMain;
import com.revature.utils.HibernateUtil;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class ReimbursementHibernate implements ReimbursementDAO{

	public ReimbMain insertReimbursement(ReimbMain r) {
		
		r.setStatus("Pending");
	
		try (Session s = HibernateUtil.getSessionFactory().openSession()){
			
			Transaction tx = s.beginTransaction();
			//int id = (int)s.save(r);
			s.save( r);
		
			
			//String username = (String)s.save(r);
			
			
			//r.setReimb_Id(id);
			
			tx .commit();
			
		}catch (ConstraintViolationException e) {
			e.printStackTrace(); // also log it 
		}
		return r;
	}

	public ReimbMain updateReimbursement(ReimbMain r) {
		try (Session s = HibernateUtil.getSessionFactory().openSession()){
			
			Transaction tx = s.beginTransaction();
			s.update(r);
			tx.commit();	
		}

		return r;
	}

	public List<ReimbMain> getReimbursements() {
		
		List<ReimbMain> r = null;
		
		try (Session s = HibernateUtil.getSessionFactory().openSession()){
			r = s.createQuery("from ReimbMain", ReimbMain.class).list();
			
		}
		
		return r;
	}



	public List<ReimbMain> getReimbursementByAuthor(int id) {


		return null;
		
	}
	public List<ReimbMain> getReimbursementByResolver(int id) {
		
		return null;
	}
	@Override
	public List<ReimbMain> getReimbursementByStatus(ReimbMain r) {
		List<ReimbMain> re = null;
		try (Session s = HibernateUtil.getSessionFactory().openSession()){
			
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<ReimbMain> cq = cb.createQuery(ReimbMain.class);
			Root<ReimbMain> root = cq.from(ReimbMain.class);
			Predicate predicateForReimStatus = cb.equal(root.get("reimb_status"), r.getReimb_Status_Id());
			cq.select(root).where(predicateForReimStatus);
			
		re = s.createQuery(cq).list();	
		}
			
		return re;
	}

	@Override
	public ReimbMain getReimbursementById(int id) throws ItemNotFoundException {
		ReimbMain rm = null;
		
		try (Session s = HibernateUtil.getSessionFactory().openSession();){

			rm = s.get(ReimbMain.class, id);
				
		}
		
		return rm;
		
	}

	@Override
	public ReimbMain deleteReimbursement(ReimbMain r) {
		try (Session s = HibernateUtil.getSessionFactory().openSession()){
			Transaction  tx = s.beginTransaction();
			s.delete("ReimbMain", r);
			tx.commit();
		}
		return null;
	}



	
	

}

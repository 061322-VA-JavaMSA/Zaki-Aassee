package com.revature.daos;

import org.hibernate.Session;

import com.revature.models.ReStatus;
import com.revature.utils.HibernateUtil;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class ReStatusHibernate implements ReStatusDAO {

	@Override
	public ReStatus getStatusById(int id) {
		 ReStatus rs = null;
		 try (Session s = HibernateUtil.getSessionFactory().openSession();){
			 
			 rs= s.get(ReStatus.class, id);
			 
			 
		 }
		return rs;
	}

	@Override
	public ReStatus getStatusByState(String state) {
		ReStatus rs = null;

		try (Session s = HibernateUtil.getSessionFactory().openSession();) {
			CriteriaBuilder cb = s.getCriteriaBuilder();
			CriteriaQuery<ReStatus> cq = cb.createQuery(ReStatus.class);
			Root<ReStatus> root = cq.from(ReStatus.class);
			
			Predicate status = cb.equal(root.get("status"), state);
			cq.select(root).where(status);
			
			rs = (ReStatus) s.createQuery(cq).getSingleResult();
		}
		
		
		
		
		
		return rs;
		
	}
	
	
	

}

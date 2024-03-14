package com.lourdes.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.lourdes.entity.Emp;

public class EmpDao {
	
	private SessionFactory sessionFactory;

	public EmpDao(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	public boolean saveEmp(Emp emp) {
		boolean isInserted = false;
		Emp newEmp = null;
		
		newEmp = emp;
		
		Session session = sessionFactory.openSession();
		
		Transaction tx = session.beginTransaction();
		
		int i = (Integer)session.save(newEmp);
		
		if(i > 0) isInserted = true;
		
		tx.commit();
		session.close();
		return isInserted;
	}	
	

}

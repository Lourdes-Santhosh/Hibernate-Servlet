package com.lourdes.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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

		String hql = "INSERT INTO Emp (name, department, salary, email, password) "
				+ "VALUES (:name, :department, :salary, :email, :password)";

		Query query = session.createQuery(hql);
		query.setParameter("name", emp.getName());
		query.setParameter("department", emp.getDepartment());
		query.setParameter("salary", emp.getSalary());
		query.setParameter("email", emp.getEmail());
		query.setParameter("password", emp.getPassword());

		int i = query.executeUpdate();

		if (i > 0)
			isInserted = true;

		tx.commit();
		session.close();
		return isInserted;
	}

}

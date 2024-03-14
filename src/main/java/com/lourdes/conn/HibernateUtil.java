package com.lourdes.conn;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.lourdes.entity.Emp;

public class HibernateUtil {
	
	public static SessionFactory getSessionFactory() {
		
		Configuration configuration = new Configuration();
    	configuration.configure("hibernate.cfg.xml");
    	configuration.addAnnotatedClass(Emp.class);

    	
    	SessionFactory sessionFactory = configuration.buildSessionFactory();
	
	
	return sessionFactory;
	}	

}
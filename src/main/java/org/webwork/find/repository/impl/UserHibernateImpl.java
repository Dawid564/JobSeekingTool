package org.webwork.find.repository.impl;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.criteria.internal.CriteriaUpdateImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.webwork.find.domain.User;
import org.webwork.find.repositor.UserHibernate;

@Repository
public class UserHibernateImpl implements UserHibernate{

	/**
	@Autowired
	private SessionFactory sessionFactory = new Configuration()
											.configure()
											.addAnnotatedClass(UserHibernate.class)
											.buildSessionFactory();
	**/
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional
	public String addNewUser(User user) {
		
		return "yolo";
	}

}

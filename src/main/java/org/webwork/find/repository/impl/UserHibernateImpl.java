package org.webwork.find.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.criteria.internal.CriteriaUpdateImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.webwork.find.domain.User;
import org.webwork.find.domain.UserRole;
import org.webwork.find.repositor.UserHibernate;

@EnableTransactionManagement
@Repository
@Transactional
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
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	
	
	//create new account
	@SuppressWarnings("unchecked")
	public String addNewUser(User user) {
		Session session = this.getSession();
		try{
			User us = user;
			user.setPassword(PasswordEncoderGenerator(user.getPassword()));
			session.save(us);
			
			UserRole userRole = new UserRole();
			userRole.setUser(user);
			userRole.setRole("ROLE_USER");
			session.save(userRole);
			
			return "Account has created";
		}catch(Exception e){
			e.printStackTrace();
			return "ERROR";
		}
	}
	
	
	private String PasswordEncoderGenerator(String pass){
		int i = 0;
		String hashedPass = null;
		while(i<10){
			//String pass = "123456";
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			hashedPass = passwordEncoder.encode(pass);
			i++;
		}
		return hashedPass;
	}

	@SuppressWarnings("unchecked")
	public User findUserByName(String userName) {
		List<User> user = new ArrayList<User>();
		user = getSession().createQuery("FROM User WHERE firstName=?").setParameter(0, userName).getResultList();
		
		if (user.size() > 0) {
			return user.get(0);
		} else {
			return null;
		}
	}
}

package org.webwork.find.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webwork.find.domain.RecrutationProcess;
import org.webwork.find.domain.User;
import org.webwork.find.repositor.InMemoryCompany;
import org.webwork.find.repositor.JdbcCorporate;
import org.webwork.find.repositor.UserHibernate;
import org.webwork.find.servic.ServiceCompany;

@Service
public class ServiceCompanyImpl implements ServiceCompany{
	
	@Autowired
	InMemoryCompany inMemoryCompany;
	
	@Autowired
	UserHibernate userHibernate;
	
	@Autowired // not use this
	JdbcCorporate jdbcCorporate;
	
	public List<RecrutationProcess> getAllCompanys() {
		return inMemoryCompany.getAllCompanys();
	}

	public String addNewUser(User user) {
		return userHibernate.addNewUser(user);
	}

	
	/**  never use this function
	public String updateUser(User user) { // never use this function
		return jdbcCorporate.updateName(user);
	}
	**/
}

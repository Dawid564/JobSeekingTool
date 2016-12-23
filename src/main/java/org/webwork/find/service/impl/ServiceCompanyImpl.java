package org.webwork.find.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webwork.find.domain.RecrutationProcess;
import org.webwork.find.repositor.InMemoryCompany;
import org.webwork.find.servic.ServiceCompany;

@Service
public class ServiceCompanyImpl implements ServiceCompany{
	
	@Autowired
	InMemoryCompany inMemoryCompany;
	
	public List<RecrutationProcess> getAllCompanys() {
		return inMemoryCompany.getAllCompanys();
	}
}

package org.webwork.find.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.webwork.find.domain.RecrutationProcess;
import org.webwork.find.domain.User;
import org.webwork.find.repositor.InMemoryCompany;

@Repository
public class InMemoryCompanyImpl implements InMemoryCompany{
	
	List<RecrutationProcess> listOfCompany = new ArrayList<RecrutationProcess>();

	public InMemoryCompanyImpl(){
		super();
		getAllCompany();
	}
	
	public void getAllCompany(){
		RecrutationProcess recrutation1 = new RecrutationProcess("zut", "firma dla pedizow");
		RecrutationProcess recrutation2 = new RecrutationProcess("tieto", "kutasiarze");
		RecrutationProcess recrutation3 = new RecrutationProcess("iai", "pederasci");
		
		listOfCompany.add(recrutation1);
		listOfCompany.add(recrutation2);
		listOfCompany.add(recrutation3);
	}
	
	
	public List<RecrutationProcess> getAllCompanys() {
		return listOfCompany;
	}

	public String addNewUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}

package org.webwork.find.servic;

import java.util.List;

import org.webwork.find.domain.RecrutationProcess;
import org.webwork.find.domain.User;

public interface ServiceCompany {
	List<RecrutationProcess> getAllCompanys();
	//String updateUser(User user);
	String addNewUser(User user);
}

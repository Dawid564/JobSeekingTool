package org.webwork.find.repositor;

import java.util.List;

import org.webwork.find.domain.RecrutationProcess;
import org.webwork.find.domain.User;

public interface InMemoryCompany {
	List<RecrutationProcess> getAllCompanys();
	String addNewUser(User user);
}

package org.webwork.find.servic;

import java.util.List;

import org.webwork.find.domain.RecrutationProcess;
import org.webwork.find.domain.SeekingProcess;
import org.webwork.find.domain.User;

public interface ServiceCompany {
	List<RecrutationProcess> getAllCompanys();
	//String updateUser(User user);
	String addNewUser(User user);
	void setUserStatus(String status);
	String getStatus();
	List<SeekingProcess> getSeekingProsessNames();
	String createNewProcessName(SeekingProcess seekingProcess);
	String deleteProcessByName(String name);
	SeekingProcess setProperProcess(String procesName);
	boolean checkIsProcessExistInDatabase(String processName);
	String updateSeekingProcess(SeekingProcess seekingProcess);
	void expiredUserPremiumCheck();
}

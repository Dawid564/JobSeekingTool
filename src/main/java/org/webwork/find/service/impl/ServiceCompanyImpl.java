package org.webwork.find.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webwork.find.domain.AlertMessage;
import org.webwork.find.domain.ChangePassword;
import org.webwork.find.domain.ContactMessages;
import org.webwork.find.domain.RecrutationProcess;
import org.webwork.find.domain.SeekingProcess;
import org.webwork.find.domain.User;
import org.webwork.find.repositor.InMemoryCompany;
import org.webwork.find.repositor.JdbcCorporate;
import org.webwork.find.repositor.UserHibernate;
import org.webwork.find.servic.ServiceCompany;

@Service
public class ServiceCompanyImpl implements ServiceCompany{
	private String status;
	
	@Autowired
	InMemoryCompany inMemoryCompany;
	
	@Autowired
	UserHibernate userHibernate;
	
	public List<RecrutationProcess> getAllCompanys() {
		return inMemoryCompany.getAllCompanys();
	}

	public String addNewUser(User user) {
		return userHibernate.addNewUser(user);
	}

	public void setUserStatus(String status){
		this.status = status;
	}
	
	public String getStatus(){
		return this.status;
	}

	public List<SeekingProcess> getSeekingProsessNames() {
		return userHibernate.getSeekingProcessNames();
	}

	public String createNewProcessName(SeekingProcess seekingProcess) {
		return userHibernate.createNewProcessName(seekingProcess);
	}

	public String deleteProcessByName(String name) {
		return userHibernate.deleteProcessByName(name);
	}

	public SeekingProcess setProperProcess(String processName) {
		return userHibernate.setProperProcess(processName);
	}

	public boolean checkIsProcessExistInDatabase(String processName) {
		return userHibernate.checkIsProcessExist(processName);
	}

	public String updateSeekingProcess(SeekingProcess seekingProcess) {
		return userHibernate.updateSeekingProcess(seekingProcess);
	}

	public void expiredUserPremiumCheck() {
		userHibernate.expiredUserPremiumCheck();
	}

	public void sendContactMessage(ContactMessages contactMessages) {
		userHibernate.sendContactMessage(contactMessages);
	}

	public boolean updatePassword(ChangePassword changePassword) {
		return userHibernate.updatePassword(changePassword);
	}

	public boolean userExists(User user) {
		return userHibernate.userExists(user);
	}

	public void deleteAllAlerts() {
		userHibernate.deleteAllAlerts();
	}

	public void createAlertMessage(AlertMessage alertMessage) {
		userHibernate.createAlertMessage(alertMessage);
	}

	public String getAleryMessage() {
		return userHibernate.getAleryMessage();
	}
	
	
	
}

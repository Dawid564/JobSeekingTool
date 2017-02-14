package org.webwork.find.repositor;

import java.util.List;

import org.webwork.find.domain.AlertMessage;
import org.webwork.find.domain.ChangePassword;
import org.webwork.find.domain.ContactMessages;
import org.webwork.find.domain.SeekingProcess;
import org.webwork.find.domain.User;

public interface UserHibernate {
	String addNewUser(User user);
	User findUserByName(String userName);
	List <SeekingProcess> getSeekingProcessNames();
	String createNewProcessName(SeekingProcess seekingProcess);
	String deleteProcessByName(String name);
	SeekingProcess setProperProcess(String processName);
	boolean checkIsProcessExist(String processName);
	String updateSeekingProcess(SeekingProcess seekingProcess);
	String addUserPayment();
	Long getAvaliabilityAccount();
	boolean checkUserPremiumStatus();
	void expiredUserPremiumCheck();
	void sendContactMessage(ContactMessages contactMessages);
	boolean updatePassword(ChangePassword changePassword);
	boolean userExists(User user);
	void deleteAllAlerts();
	void createAlertMessage(AlertMessage alertMessage);
	String getAleryMessage();
}

package org.webwork.find.servic;

public interface ServicePayment {
	boolean verificationPayment(String code);
	String getAvaliabilityAccount();
	String checkUserPremiumStatus();
}

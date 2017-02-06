package org.webwork.find.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webwork.find.repositor.UserHibernate;
import org.webwork.find.servic.ServicePayment;

@Service
public class ServicePaymentImpl implements ServicePayment{
	
	@Autowired
	UserHibernate userHibernate;

	public boolean verificationPayment(String code) {
		String verificationCode = "GkYBkYBKjhl9pKlMiMLIyFrChGV";
		if(verificationCode.equals(code)){
			userHibernate.addUserPayment();
			return true;
		}else{
			return false;
		}
	}

	public String getAvaliabilityAccount() {
		Long milisec = userHibernate.getAvaliabilityAccount();
		Long modernMilisec = milisec;
		if(modernMilisec <= 172800000L){
			modernMilisec = (((milisec/1000)/60)/60);
			return modernMilisec.toString() + " Hours Left";
		}else{
			modernMilisec = ((((milisec/1000)/60)/60)/24);
			return modernMilisec.toString() + " Days Left";
		}
	}
}

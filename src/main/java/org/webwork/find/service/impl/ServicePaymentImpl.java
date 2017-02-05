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
}

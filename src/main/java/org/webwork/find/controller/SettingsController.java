package org.webwork.find.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.webwork.find.domain.ChangePassword;
import org.webwork.find.domain.ContactMessages;
import org.webwork.find.servic.ServiceCompany;
import org.webwork.find.servic.ServicePayment;

@Controller
@RequestMapping("/settings")
public class SettingsController {
	
	@Autowired
	ServiceCompany serviceCompany;
	
	@Autowired
	ServicePayment servicePayment;

	@RequestMapping(method=RequestMethod.GET)
	public String main(Model model){
		ContactMessages contactMessages = new ContactMessages();
		ChangePassword changePassword = new ChangePassword();
		model.addAttribute("passwordForm", changePassword);
		model.addAttribute("contactForm", contactMessages);
		return "settings";
	}
	
	@RequestMapping(value= "/contact",method=RequestMethod.POST)
	public String reciveMessage(Model model, 
			@ModelAttribute("contactForm") ContactMessages contactMessages,
			@ModelAttribute("passwordForm") ChangePassword changePassword, 
			HttpServletRequest request){
		if(request.getParameter("contactForm") != null){
			serviceCompany.sendContactMessage(contactMessages);
		}else if(request.getParameter("passForm") != null){
			serviceCompany.updatePassword(changePassword);
		}
		
		return "redirect:/settings";
	}	
	
	@RequestMapping(value = "/freePremium", method=RequestMethod.GET)
	public String freePremium(){
		servicePayment.freePremium();
		return "redirect:/settings";
	}
}

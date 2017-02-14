package org.webwork.find.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.webwork.find.domain.AlertMessage;
import org.webwork.find.servic.ServiceCompany;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	ServiceCompany serviceCompany;
	
	@RequestMapping(method=RequestMethod.GET)
	public String adminForm(Model model){
		AlertMessage alertMsg = new AlertMessage();
		model.addAttribute("alertMessageForm", alertMsg);
		return "admin";
	}
	
	//display alert on main site
	@RequestMapping(value="/alert", method=RequestMethod.POST)
	public String getAllertMessage(Model model, @ModelAttribute("alertMessageForm") AlertMessage alertMessage){
		System.out.println("alert");
		serviceCompany.createAlertMessage(alertMessage);
		return "redirect:/admin";
	}
	
	//delete all alerts
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String deleteAllAlerts(Model model){
		System.out.println("delete");
		serviceCompany.deleteAllAlerts();
		return "redirect:/admin";
	}
}

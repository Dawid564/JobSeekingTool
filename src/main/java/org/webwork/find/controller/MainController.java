package org.webwork.find.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.webwork.find.servic.ServiceCompany;

@Controller
@RequestMapping(value = "")
public class MainController {

	@Autowired
	ServiceCompany serviceCompany;

	@Autowired
	LoginController loginController;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String setStart (Model model){
		if(serviceCompany.getAleryMessage() != ""){
			model.addAttribute("alertMessage", serviceCompany.getAleryMessage());
		}else{
			//do nothing
		}
		
		model.addAttribute("company", serviceCompany.getAllCompanys());
		model.addAttribute("testUserRole", serviceCompany.getStatus());
		return "main";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String getAllCompanys(Model model) {
		
		if(serviceCompany.getAleryMessage() != ""){
			model.addAttribute("alertMessage", serviceCompany.getAleryMessage());
		}else{
			//do nothing
		}
		
		model.addAttribute("company", serviceCompany.getAllCompanys());
		model.addAttribute("testUserRole", serviceCompany.getStatus());
		return "main";
	}
}

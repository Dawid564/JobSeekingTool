package org.webwork.find.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.webwork.find.servic.ServiceCompany;

@Controller
@RequestMapping("/main")
public class MainController {

	@Autowired
	ServiceCompany serviceCompany;
	
	@RequestMapping(method = RequestMethod.GET)
	public String getAllCompanys(Model model){
		model.addAttribute("company", serviceCompany.getAllCompanys());
		return "main";
	}
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String String (Model model){
		return "index";
	}
}

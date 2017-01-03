package org.webwork.find.controller;

import javax.security.auth.login.AppConfigurationEntry;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String firstLookingAtBeautyWorld(Model model){
		model.addAttribute("pedaly", "witam przyjacielu");
		//return "index";
		
		//only for testing purposes
		return "redirect:main";
	}
	
	public void testDI(){

	}
}

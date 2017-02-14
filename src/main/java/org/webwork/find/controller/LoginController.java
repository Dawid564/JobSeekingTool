package org.webwork.find.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.webwork.find.domain.User;
import org.webwork.find.servic.ServiceCompany;

@Controller
public class LoginController {

	@Autowired
	ServiceCompany serviceCompany;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username or password");
		}
		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully");
		}
		model.addObject("kkk", serviceCompany.getStatus());
		model.setViewName("login");
		return model;
	}

	// method to set user object as form ????
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getAddNewUser(Model model) {
		User user = new User();
		model.addAttribute("newUser", user);
		return "register";
	}

	// this method get user from form and operate at it ????????
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registration(@ModelAttribute("newUser") User user) {
		ModelAndView model = new ModelAndView();
		if(!serviceCompany.userExists(user)){//user already exists
			//can't create user
			model.addObject("userError", "user already exists");
			model.setViewName("/register");
		}else{
			//can create user
			model.addObject("response", serviceCompany.addNewUser(user));
			model.addObject("loginInfo", "Account has created, now you can Log In");
			model.setViewName("/login");
		}
		
		return model;
	}
}

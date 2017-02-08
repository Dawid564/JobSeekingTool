package org.webwork.find.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/settings")
public class SettingsController {

	@RequestMapping(method=RequestMethod.GET)
	public String main(Model model){
		return "settings";
	}
}

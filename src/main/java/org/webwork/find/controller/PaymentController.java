package org.webwork.find.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.webwork.find.servic.ServicePayment;

@Controller
@RequestMapping(value="/payment")
public class PaymentController {
	
	@Autowired
	ServicePayment servicePayment;
	
	@RequestMapping(method=RequestMethod.GET)
	public String payment (Model model){
		model.addAttribute("timeRemaining", servicePayment.getAvaliabilityAccount());
		return "payment";
	}
	
	@RequestMapping(value="/finish/{code}", method=RequestMethod.GET)
	public String finishPayment(Model model, @PathVariable String code){
		if(servicePayment.verificationPayment(code)){
			model.addAttribute("result", "Payment Accepted");
			return "redirect:/payment";
		}else{
			model.addAttribute("result", "Payment Does not Accepted");
			return "redirect:/payment";
		}
		
	}
}

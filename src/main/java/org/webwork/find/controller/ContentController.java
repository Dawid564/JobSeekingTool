package org.webwork.find.controller;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.webwork.find.domain.SeekingProcess;
import org.webwork.find.servic.ServiceCompany;

@Controller
@RequestMapping(value="/content")
public class ContentController {
	
	@Autowired
	ServiceCompany ServiceCompany;
	

	@RequestMapping(method = RequestMethod.GET)
	public String mainProcessNames(Model model, @ModelAttribute("seekingObject") SeekingProcess seekingProcessMapping){ //get object for other controller     //old name login
		SeekingProcess seek = new SeekingProcess();
		model.addAttribute("companyName", seekingProcessMapping.getCompanyName());
		model.addAttribute("companyDescription", seekingProcessMapping.getCompanyDescription());
		model.addAttribute("dataResumeSend", seekingProcessMapping.getDataResumeSend());
		model.addAttribute("awaitSalary", seekingProcessMapping.getAwaitSalary()); //set proper wages
		model.addAttribute("listOfProcess", ServiceCompany.getSeekingProsessNames());
		model.addAttribute("nameOfCurrentProcess", seekingProcessMapping.getProcessName());
		model.addAttribute("contactEmail", seekingProcessMapping.getContactEmail());
		model.addAttribute("contactPhone", seekingProcessMapping.getContactPhone());
		model.addAttribute("responseDate", seekingProcessMapping.getResponseDate());
		model.addAttribute("questionsPhoneCall", seekingProcessMapping.getQuestionsPhoneCall());
		model.addAttribute("notesPhoneCall", seekingProcessMapping.getNotesPhoneCall());
		model.addAttribute("strengths", seekingProcessMapping.getStrengths());
		model.addAttribute("weakness", seekingProcessMapping.getWeakness());
		model.addAttribute("interviewPlace", seekingProcessMapping.getInterviewPlace());
		model.addAttribute("interviewTime", seekingProcessMapping.getInterviewTime());
		if(seekingProcessMapping.isSendResume()){
			model.addAttribute("checkBoxVal", true);
		}else{
			model.addAttribute("checkBoxVal", false);
		}
		if(seekingProcessMapping.isRightClothing()){
			model.addAttribute("rightClothing", true);
		}else{
			model.addAttribute("rightClothing", false);
		}
		if(seekingProcessMapping.isRemindResume()){
			model.addAttribute("remindResume", true);
		}else{
			model.addAttribute("remindResume", false);
		}
		if(seekingProcessMapping.isImportantDocs()){
			model.addAttribute("importantDocs", true);
		}else{
			model.addAttribute("importantDocs", false);
		}
		model.addAttribute("numberOfProcesses", ServiceCompany.getSeekingProsessNames().size());
		model.addAttribute("createNewProcess", seek);
		return "content";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setLenient(true);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}
	
	//create or update process
	@RequestMapping(method = RequestMethod.POST)
	public String createNewProcessName(@ModelAttribute("createNewProcess") SeekingProcess seekingProcess, BindingResult result){
		if(ServiceCompany.checkIsProcessExistInDatabase(seekingProcess.getProcessName())){// check is in the database is this process exists
			ServiceCompany.createNewProcessName(seekingProcess); //when process does not exists
		}else{
			
			ServiceCompany.updateSeekingProcess(seekingProcess); //only update existing process
		}
		return "redirect:/content";
	}
	

	// delete process from database
	@RequestMapping(value = "/del/", method = RequestMethod.GET)
	public String deleteProcessByName(Model model, @RequestParam("processTitle") String processTitle) {
		ServiceCompany.deleteProcessByName(processTitle);
		model.addAttribute("createNewProcess", new SeekingProcess());
		return "redirect:/content";
	}
	
	//set proper process on the front
	@RequestMapping(value="/look/", method=RequestMethod.GET)
	public String setProperProcess(Model model, @RequestParam("getProcess") String processName, final RedirectAttributes redirectAttributes){
		redirectAttributes.addFlashAttribute("seekingObject", ServiceCompany.setProperProcess(processName));// send object to another controller
		model.addAttribute("seekingObject", ServiceCompany.setProperProcess(processName));
		model.addAttribute("createNewProcess", new SeekingProcess());
		return "redirect:/content";
	}
	
	//download files
	@RequestMapping(value="/download/{resume:.+}", method=RequestMethod.GET)
	public void downloadResume(HttpServletRequest request, HttpServletResponse response, @PathVariable String resume){
		String dataDirectory  = request.getServletContext().getRealPath("/resources/images/");
		Path file = Paths.get(dataDirectory, resume);
		if(Files.exists(file)){
			response.setContentType("test.png");
			response.addHeader("Content-Disposition",  "attachment; filename=" + resume);
			try{
				Files.copy(file, response.getOutputStream());
				response.getOutputStream().flush();
			}catch(IOException e){
				e.printStackTrace();
			}
		}else{
			System.out.println("Sorry File not found!!!");
		}
	}
}
/** TODO known problems
 *  catch error when user add the same name second time 
 *  set maximum active process
 *  check if user choose one of existing process before he press mile stone button
 *  try to type not normal date
 *  possibility to change password
 *  problem with new line symbol (enter) in text area
 *  user role
 */

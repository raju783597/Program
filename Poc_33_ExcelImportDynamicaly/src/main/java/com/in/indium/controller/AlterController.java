package com.in.indium.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.in.indium.iservice.IAlternateService;
import com.in.indium.model.Alternate;
@Controller
public class AlterController {
	
	@Autowired
	IAlternateService aservice;

	

	@GetMapping(value ="/alter")
	public String home(Model model) {
	model.addAttribute("clientUser", new Alternate());
	
	
	
	List<Alternate>clientUser=aservice.findAll();
	model.addAttribute("clientUser", clientUser);
	
		return "Documents";		
	}
	@PostMapping("/fileupload1")
	public String uploadFile(@ModelAttribute Alternate  alternate ,RedirectAttributes redirect) {
		boolean isFlag=aservice.saveDataFromUploadFile(alternate.getFiletype());
		if(isFlag) {
			redirect.addFlashAttribute("success","upload successfully");
		}else {
			redirect.addFlashAttribute("errormassage","file not upload successfully");
			
		}
		
		return "redirect:/";
		
	}
	
}

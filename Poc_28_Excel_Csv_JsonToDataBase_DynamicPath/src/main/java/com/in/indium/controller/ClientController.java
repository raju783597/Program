package com.in.indium.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.in.indium.iservice.IClientUserService;
import com.in.indium.model.ClientUser;

import javassist.expr.NewArray;

//@RestController
//@RequestMapping("/web")
@Controller
public class ClientController {
	@Autowired
	private IClientUserService service;
	
	@GetMapping(value ="/")
	public String home(Model model) {
	model.addAttribute("clientUser", new ClientUser());
	List<ClientUser>clientUser=service.findAll();
	model.addAttribute("clientUser", clientUser);
	
		return "Documents";		
	}
	@PostMapping("/fileupload")
	public String uploadFile(@ModelAttribute ClientUser  clientUser ,RedirectAttributes redirect) {
		boolean isFlag=service.saveDataFromUploadFile(clientUser.getFiletype());
		if(isFlag) {
			redirect.addFlashAttribute("success","upload successfully");
		}else {
			redirect.addFlashAttribute("errormassage","file not upload successfully");
			
		}
		
		return "redirect:/";
		
	}
	
}

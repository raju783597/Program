package com.in.indium.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.in.indium.iservice.IRoleService;
import com.in.indium.model.Role;

@Controller//object+http request
@RequestMapping("/role")
public class RoleControler {
	
	@Autowired
	private IRoleService service;
	
	//1 show register
	@GetMapping("/registers")
	public String register() {
		return "roleRegister";
		
	}
	//insert on submit button
	@PostMapping("/save")
	public String save(@ModelAttribute Role role ,
			        Model model) 
	{
		Integer id= service.saveRole(role);
		String msg="save data"+id;
		model.addAttribute("msg", msg);
		return "roleRegister" ;
		
	}
	

}

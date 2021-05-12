package com.in.indium.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.in.indium.model.User;
import com.in.indium.service.IUserService;

//object+http request
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService service;
	
    //.1 show registe page
	/* url :/register, Type:GET
	 * GOTO userRegister.html page
	*/
	@GetMapping("/register")
	public String showRegister(Model model) {
		//form backing object
		model.addAttribute("user", new User());
		return "userRegister";
		
	}
	//2 save:on click
	@PostMapping("/save")
	public String save(
	                  //read data from ui ()		
			          @ModelAttribute User user,
			          //send data from controller to ui
			          Model model
			          )
	{ 
		//data is save and get id
	Integer id=service.saveUser(user);
	//
	String msg="user saved succesfully "+id;
	//send massage to ui
	model.addAttribute("msg", msg);
	        //form backing object
	//model.addAttribute("user", new User());
		return "userRegister";
		
	}
	//3.display data
	/*fetch all data from db
	 * 
    */
	@GetMapping("/all")
	public String fatchAll( Model model) {
		
	List<User> list=service.getAllUser();
	model.addAttribute("list", list);
		return "userData";
		
	}
	
	//4remove one by on
	//url 
	@GetMapping("/delete/{id}")
	public String removeById(@PathVariable Integer id, Model model) {
		service.deleteUser(id);
		String massage="udesr "+id+" deleted";
		model.addAttribute("massage", massage);
		
		  List<User> list=service.getAllUser(); 
		  model.addAttribute("list", list);
		  return "userData";
		 
		//return "../all";
		
	}
	//5show edit page
	/* on click  edit hyperLink at ui
	 * read one path variable fron service
	 * if exist send to edit page else redirect data page
	 * */
	@GetMapping("/edit/{id}")
	   public String showEdit(@PathVariable Integer id,Model model) {
	   //it go to db and check id is present or not if present then goto if block
		Optional<User> opt=	service.getOneUser(id);
	String page=null;
	if(opt.isPresent()) {
		//opt.get() is method on optional class get the value
		User u=opt.get();
		model.addAttribute("user", u);
	page="userEdit";
	}else
	{
		page="redirect:../all";
	}
		return page;
		   
	   }
		/*
		 * on click update button read form 
		 * data and perform update operation
		 * send back to data page with sucess message
		 * 
		 */
	//6 update : on click
	@PostMapping("update")
	public String update(@ModelAttribute User user,Model model) {
		service.updateUser(user);
		String msg="user updated "+user.getId();
		model.addAttribute("msg", msg );
		//store in db and show in ui
		  List<User> list=service.getAllUser(); 
		  model.addAttribute("list", list);
		//form backing object
			model.addAttribute("user", new User());
		return "userData";
		
	}
	
}

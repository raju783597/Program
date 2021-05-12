
  package com.in.indium.controller;
  
  import org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.stereotype.Controller; import
  org.springframework.ui.Model; import
  org.springframework.web.bind.annotation.GetMapping; import
  org.springframework.web.bind.annotation.ModelAttribute; import
  org.springframework.web.bind.annotation.PostMapping; import
  org.springframework.web.bind.annotation.PutMapping; import
  org.springframework.web.bind.annotation.RequestMapping;
  
  import com.in.indium.model.Ragister; import
  com.in.indium.service.IRagisterService;
  
  @Controller
  
  @RequestMapping("/user") public class RedisterController {
  
  @Autowired private IRagisterService service;
  
  @GetMapping("/register") public String register() {
  System.out.println("ragister page>>>>>>>>>>>>"); return "Register";
  
  }
  
  @PostMapping("/save") public String saveData( 
		  //read data from ui
  
  @ModelAttribute Ragister rag 
  //add massage and send to ui 
   ,Model model) {
  //save operation 
  Integer id = service.saveRagisterData(rag); 
  //custom message
  String message="Ragister Id "+id+" SAVE ";
  
  model.addAttribute(message, message);
  
  return "Register";
  
  }
  
  }
 
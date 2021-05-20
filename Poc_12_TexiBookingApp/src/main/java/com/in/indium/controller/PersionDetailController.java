package com.in.indium.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.in.indium.iservice.IPersionService;
import com.in.indium.model.PersionDetail;
import com.in.indium.utill.PersionDetailUtility;
import com.in.indium.view.PersionDetailExcelView;
import com.in.indium.view.PersionDetailView;

import jdk.internal.org.jline.utils.Log;

@Controller
@RequestMapping("/persiondetail")
public class PersionDetailController {

	@Autowired
	private IPersionService service;
	
	@Autowired
	private ServletContext context;
    
	@Autowired
	private PersionDetailUtility util;

	//1 show login page
	@RequestMapping("/login")
	public String LogInPage() {
		return "Login1";

	}
	
	//1 show login page
	@RequestMapping("/register")
	public String Register(Model model) {

		model.addAttribute("persionDetail", new PersionDetail());
		//return "Home";
		return "Register";

	}

	//2 save:on click
	@PostMapping("/save")
	public String save(
			//read data from ui ()		
			@ModelAttribute PersionDetail persiondetail,
			//send data from controller to ui
			Model model
			)
	{ 
		//data is save and get id
		Integer id=service.savePersionDetail(persiondetail);
		//
		String msg="saved with "+id;
		//send massage to ui
		model.addAttribute("msg", msg);
		//form backing object
		//model.addAttribute("user", new User());
	//	return "Home";
		return "Register";

	}

	//3 getall deta
	/*
	 * @GetMapping("/all") public String getAllData(Model model ) {
	 * List<PersionDetail>list=service.getAllPersionDetail();
	 * model.addAttribute("list", list); return "Dataoldold";
	 * 
	 * }
	 */
	 
	//3 getall deta for pagination
		@GetMapping("/all")
		public String getAllData(@PageableDefault(page=0,size = 6)  Pageable pageable, Model model ) {
			Page<PersionDetail>page=service.getAllPersionDetail(pageable);
			model.addAttribute("page", page);
			return "Dataoldold";

		}
	//4 delete
	@GetMapping("/delete/{id}")
	public String deletePersionDetailById(@PathVariable Integer id,
			Model model
			) {
		String page1=null;
		if(service.isPersionDetailExist(id)) {
			service.deletePersionDetail(id);
			/*
			 * List<PersionDetail>list=service.getAllPersionDetail();
			 * model.addAttribute("list", list);
			 */
			//page=pagination+list
			Page<PersionDetail>page=service.getAllPersionDetail(PageRequest.of(0, 6));
			model.addAttribute("page", page);

			String msg="DELETED "+id+" PROPERLY";
			model.addAttribute("msg", msg);
			page1="Dataoldold";
		}
		else {
			/*
			 * List<PersionDetail>list=service.getAllPersionDetail();
			 * model.addAttribute("list", list);
			 */
			Page<PersionDetail>page=service.getAllPersionDetail(PageRequest.of(0, 3));
			model.addAttribute("page", page);
			
			//  page="redirect:../all";
			page1="Dataoldold";
			model.addAttribute("msg",id+"NOT EXIST");

		}
		return page1;			
	}
	// edit
	@GetMapping("/edit/{id}")
	public String editData(@PathVariable Integer id, Model model) {
		String page1=null;
		Optional<PersionDetail>op=service.getOneData(id);
		if(op.isPresent()) {
			PersionDetail p=op.get();
			model.addAttribute("persionDetail", p);
			//model.addAttribute("msg","UPDATED THE PAGE "+id+"SUCESSFULLY");

			page1="Editoldold";
		}

		else { 
			
			/*
			 * List<PersionDetail>list=service.getAllPersionDetail();
			 * model.addAttribute("list", list);
			 */
			Page<PersionDetail>page=service.getAllPersionDetail(PageRequest.of(0, 6));
			model.addAttribute("page", page);
			
			model.addAttribute("msg","DATA IS NOT FOUND of "+id);
			page1="Dataoldold"; 
		}

		return page1;
	}



	@PostMapping("/update")
	public String updated(
		@ModelAttribute PersionDetail persionDetail
		,Model model) {
		Integer id= service.persionDetailUpdate(persionDetail);
		/*
		 * List<PersionDetail>list=service.getAllPersionDetail();
		 * model.addAttribute("list", list);
		 */	
		Page<PersionDetail>page=service.getAllPersionDetail(PageRequest.of(0, 6));
		model.addAttribute("page", page);
		
		model.addAttribute("msg","DATA UPDATED "+id);
		return "Dataoldold";

	}
	// pdf view
	@GetMapping("/pdf")
	public ModelAndView exportPdf() {
		ModelAndView m=new ModelAndView();
		m.setView(new PersionDetailView());
		
	List<PersionDetail>list=service.getAllPersionDetail();
		m.addObject("list",list);
		return m;
		
	}
	// excel view
	@GetMapping("/excel")
	public ModelAndView exportExcel() {
		ModelAndView m=new ModelAndView();
		m.setView(new PersionDetailExcelView());
		
	List<PersionDetail>list=service.getAllPersionDetail();
		m.addObject("list",list);
		return m;
		
	}
	
	// generage chart
	
	@GetMapping("/charts")
	public String showPiAndChart() {
		//DATA is show in chart
	List<Object[]>list=	service.persionDetailVehicelTypeCount1();
	//dynamic temp folder location
	String location= context.getRealPath("/");
	
	System.out.println("chart location is"+location);
	
	//call chart method
	util.generateBarChart(location, list);
	util.generatePiChart(location, list);
	return"PersionCharts";
		}
		
		
		
	
}

package com.in.indium.contaroller.rest;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus.Series;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.in.indium.model.Ragister;
import com.in.indium.repo.RagisterRepo;
import com.in.indium.service.IRagisterService;

import net.bytebuddy.implementation.bytecode.Throw;

@RestController
@RequestMapping("rest/user") // controll+httpmethod
public class RagisterControllerRest {
	@Autowired
	private IRagisterService service;

	@Autowired
	private RagisterRepo repo;

	// 1.save one recode
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Ragister ragister) {
		ResponseEntity<String> resp = null;
		Integer id = service.saveRagisterData(ragister);
		try {
			//body+status(201)>>>CREATED(201, Series.SUCCESSFUL, "Created"),
			resp = new ResponseEntity<String>("SAVED '" + id + "'WITH RAGISTER", HttpStatus.CREATED);

		} catch (Exception e) {

			//body+status(500)>>>INTERNAL_SERVER_ERROR(500, Series.SERVER_ERROR, "Internal Server Error"),
			resp = new ResponseEntity<String>("UNABLE TO SAVE", HttpStatus.INTERNAL_SERVER_ERROR);
		}

		return resp;

	}

	// 2.getAll recode
	@GetMapping("/all")
	public ResponseEntity<List<Ragister>>getAllData() throws JsonGenerationException, JsonMappingException, IOException
	{
		//one row of data of db convert in list>>list.get(0)
		//2nd row of data of db convert in list>>list.get(1)
		List<Ragister>list=service.getAllRagisterData();
		/*
		 * System.out.println("allllllllllllll>>>"+list.size());
		 * System.out.println(list);
		 * System.out.println(list.get(0)+">>>>>>???????"+list.get(1));
		 */
		//body+status >>>OK(200, Series.SUCCESSFUL, "OK"),
		return new ResponseEntity<List<Ragister>>(list,HttpStatus.OK);

	}
	
	

	//3.getone  recode

	@PostMapping("/one") public
	ResponseEntity<String>getNameAndPwd(
		
			@RequestBody  Ragister ragister) throws JsonGenerationException,
	
	                                      JsonMappingException, IOException
     	{
		
	//	ResponseEntity<String> res=null;
		
	      Ragister list=repo.findByNameAndPassward(ragister.getName(), ragister.getPassward());
	          if(list!=null) {
	    	  return  new ResponseEntity<String>(list.getName().toUpperCase()+"<<<<SUCCESSFULLY LOGIN >>>>",HttpStatus.OK); 
	           }
	
	          return new  ResponseEntity<String>(" INVALID USER ",HttpStatus.BAD_REQUEST);
		  

	}
	
   //fatch data by id
	@GetMapping("/one/{id}") 
	public
	       ResponseEntity<?>getOneData(
			@PathVariable Integer id

			)
				throws JsonGenerationException,
	                   JsonMappingException, IOException
	{
          //get the dat from db
           Optional<Ragister> opt =  repo.findById(id);
                                  repo.getOne(id);
           
           System.out.println( ">>>>>>>"+repo.findById(id));
           System.out.println( ">>>>>>>"+repo.getOne(id));
           
           ResponseEntity<?> resp=null;
           
       //if id is present
           if(opt.isPresent()) {
				/*
				 * //responseentity have two things body+header(status) //get() if data is there
				 * then it return value otherwise //it return throw new
				 * NoSuchElementException("No value present"
				 */
        	   
        	   //body+status>>OK(200, Series.SUCCESSFUL, "OK"),  
        	   resp= new ResponseEntity<Ragister>(opt.get(),HttpStatus.OK); 
           } else {
        	   //string+400>>>badrequest BAD_REQUEST(400, Series.CLIENT_ERROR, "Bad Request"),
        	   resp=new ResponseEntity<String>("THIS ID"+id+" OF DATA NOT FOUND>>>>> ",HttpStatus.BAD_REQUEST);
           }
		 
	
		return  resp; 

	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> DeleteById(
		          @PathVariable Integer id
			){
		//boolean exist= repo.existsById(id);
	      ResponseEntity<?> resp=null;
		
		if(repo.existsById(id)) {
			   repo.deleteById(id);
			   resp= new ResponseEntity<String>("DATA THIS ID>>>"+id+"DELRTED  ",HttpStatus.OK); 
		}
		else {
			//body+ststus>>>NOT_FOUND(404, Series.CLIENT_ERROR, "Not Found")
			resp=new ResponseEntity<String>("THIS ID>>"+id+">> DATA NOT FOUND ",HttpStatus.NOT_FOUND);
			
		}
		return resp;
		
	}

	
	
	
	
	
	
	
	
	
	
	

	/*
	 * //3.getAll recode
	 * 
	 * @GetMapping("/one/{name}/{pwd}") public ResponseEntity<String>getNameAndPwd(
	 * 
	 * //get the data from postman bar
	 * 
	 * @PathVariable String name,
	 * 
	 * @PathVariable String pwd ) throws JsonGenerationException,
	 * JsonMappingException, IOException { ResponseEntity<String> res=null;
	 * 
	 * //Hibernate: select id1_0_, dob_col2_0_, //email_co3_0_, gender_c4_0_,
	 * last_nam5_0_, //name_col6_0_, pass_col7_0_, phono_co8_0_ //from reg_tab where
	 * name_col=? and pass_col=?
	 * 
	 * // List<Object[]> list= repo.findByNameAndPassward(name, pwd); //
	 * System.out.println(list.get(0)+" "+list.get(1));
	 * 
	 * // ((Iterable<Ragister>) repo.findByNameAndPassward(name,
	 * pwd)).forEach(System.out::println);
	 * 
	 * Ragister list= repo.findByNameAndPassward(name, pwd);
	 * 
	 * 
	 * 
	 * System.out.println(list.getName()+"FATCH FROM DATABASE "+list.getPassward());
	 * 
	 * System.out.println(name+"  <<<<<<COME FROM BROWSER>>>>>>  "+pwd);
	 * System.out.println(list);
	 * 
	 * 
	 * 
	 * 
	 * if(list.getName().equals(name) && list.getPassward().equals(pwd)) {
	 * 
	 * res= new ResponseEntity<String>(list.getName().toUpperCase()
	 * +"<<<<SUCCESSFULLY LOGIN >>>>",HttpStatus.OK);
	 * //System.out.println(list.getName().equals(name)+"<inside if block> "+list.
	 * getPassward().equals(pwd));
	 * 
	 * } else {
	 * 
	 * res= new ResponseEntity<String>(" INVALID USER ",HttpStatus.BAD_REQUEST);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * if( list.getName()== null ||list.getPassward()==null) { // else { res= new
	 * ResponseEntity<String>(" INVALID USER ",HttpStatus.BAD_REQUEST);
	 * 
	 * System.out.println(list.getName()+"<<FATCH NULL DATA FROM DATABASE "+list.
	 * getPassward()); }
	 * 
	 */

	/*
	 * else {
	 * 
	 * res= new ResponseEntity<String>(" INVALID USER ",HttpStatus.BAD_REQUEST);
	 * System.out.println(list.getName().equals(name)+"< inside else block> "+list.
	 * getPassward().equals(pwd)); }
	 * 
	 */

	// repo.findByNameAndPassward("raju","123").forEach(System.out::println);

	// List<Ragister>list2= repo.findByNameAndPassward("raju","123");
	// System.out.println(list2.indexOf(0));
	//return res;

     //}

}
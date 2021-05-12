/*
 * package com.in.indium.contaroller.rest;
 * 
 * import java.io.IOException; import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.fasterxml.jackson.core.JsonGenerationException; import
 * com.fasterxml.jackson.databind.JsonMappingException; import
 * com.in.indium.model.Ragister; import com.in.indium.service.IRagisterService;
 * 
 * @RestController
 * 
 * @RequestMapping("rest/user") public class RagisterControllerRest2 {
 * 
 * @Autowired private IRagisterService service;
 * 
 * //1.save one recode
 * 
 * @PostMapping("/save") public ResponseEntity<String>save(
 * 
 * @RequestBody Ragister ragister ){ ResponseEntity<String>resp=null; Integer
 * id=service.saveRagisterData(ragister); try { resp=new
 * ResponseEntity<String>("SAVED '"+id+"'WITH RAGISTER",HttpStatus.CREATED);
 * 
 * } catch (Exception e) {
 * 
 * resp=new
 * ResponseEntity<String>("UNABLE TO SAVE",HttpStatus.INTERNAL_SERVER_ERROR); }
 * 
 * return resp;
 * 
 * } //1.getAll recode
 * 
 * @GetMapping("/all") public ResponseEntity<List<Ragister>>getAll() throws
 * JsonGenerationException, JsonMappingException, IOException {
 * 
 * List<Ragister>list=service.getAllRagisterData();
 * 
 * 
 * return new ResponseEntity<List<Ragister>>(list,HttpStatus.OK);
 * 
 * } //3.getAll recode
 * 
 * @GetMapping("/one/{name}/{pwd}") public
 * ResponseEntity<List<Ragister>>getNameAndPwd(
 * 
 * @PathVariable String name,
 * 
 * @PathVariable Integer pwd ) throws JsonGenerationException,
 * JsonMappingException, IOException { ResponseEntity<List<Ragister>> res=null;
 * List<Ragister>list= service.findByNameAndPwd(name, pwd);
 * 
 * if(list.get(0).equals(name) && list.get(1).equals(pwd) ) { res= new
 * ResponseEntity<List<Ragister>>(list,HttpStatus.OK); } else { res= new
 * ResponseEntity<List<Ragister>>(HttpStatus.BAD_REQUEST);
 * 
 * }
 * 
 * 
 * return res;
 * 
 * } }
 */
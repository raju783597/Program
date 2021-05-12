package com.in.indium.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


/*Indicates that an annotated class is a "component".
 * Such classes are considered as candidates for auto-detection
 * when using annotation-based configuration and classpath scanning.
 */
@Component
public class OrderRestConsumer {
	
	@Autowired
	private LoadBalancerClient client ;

	
	  public String doHttpcall() {
	  
	  //select serviceinstance having less load factor 
		  ServiceInstance
	  si=client.choose("PRODUCER-(ORDER-SERVICE)");
	  
	  //read uri and path 
	  String URL= si.getUri()+"/show";
	  
	  //MAKE HTTP CALL 
	  RestTemplate rt=new RestTemplate();
	  
	  String msg=rt.getForObject(URL, String.class);
	  
	  return msg;
	  
	  }
	  
	     // instead of method we can use feign client=ribbon+loadbalance client
	 

}

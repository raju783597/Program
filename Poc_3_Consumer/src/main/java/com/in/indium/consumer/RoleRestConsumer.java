package com.in.indium.consumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class RoleRestConsumer {

	@Autowired
	private DiscoveryClient client;
	
	public String doHttpcall() {
		
     //define resttemplete
	RestTemplate rt=new RestTemplate(); 
	
	//get serviceinstance data using service -name/Application-name  
	List<ServiceInstance> silist=client.getInstances("PRODUCER");
	
	//3 read one service Instance using index
	ServiceInstance si= silist.get(0);
	
	//read uri and add path
	String url= si.getUri()+"/rest/role/all";
	
	//make http request
	String respmsg=rt.getForObject(url, String.class);
	
	
	return respmsg;
		
	}
	
}

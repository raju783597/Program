package com.in.indium.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("VENDOR-SERVICE")
public interface VendorRestConsumer {
	
	@GetMapping("/vendor/data")
	public String getVendorData();
	
	
}

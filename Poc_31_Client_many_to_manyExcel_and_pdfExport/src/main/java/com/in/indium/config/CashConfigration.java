package com.in.indium.config;

import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CashConfigration {
	@Bean
	public CacheManagerCustomizer<ConcurrentMapCacheManager> customizer(){
		return new ConcurrentCustomizer();
		
	}
	
	
}
class ConcurrentCustomizer implements CacheManagerCustomizer<ConcurrentMapCacheManager>
{
	@Override
	public void customize(ConcurrentMapCacheManager cacheManager) {
		// TODO Auto-generated method stub
		cacheManager.setAllowNullValues(false);
	     cacheManager.setStoreByValue(true);
	     System.out.println("customizer invoke");
	}
}

package com.in.indium.config;

import javax.cache.expiry.Duration;

import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.core.Ehcache;
import org.ehcache.jsr107.Eh107Configuration;
import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@EnableCaching
public class CashConfigration   {
	/*
	 * private final javax.cache.configuration.Configuration<Object, Object>
	 * jcacheConfiguration=null;
	 * 
	 * public void CachConfiguration() { JHipsterProperties.Cache.Ehcache ehcache =
	 * jHipsterProperties.getCache().getEhcache();
	 * 
	 * jcacheConfiguration = //Creates a new JSR-107 {@link Configuration} from the
	 * provided {@link CacheConfiguration}. Eh107Configuration
	 * .fromEhcacheCacheConfiguration( CacheConfigurationBuilder
	 * .newCacheConfigurationBuilder (Object.class, Object.class,
	 * ResourcePoolsBuilder. heap(ehcache //size of heap .getMaxEntries() ) )
	 * .withExpiry(ExpiryPolicyBuilder.timeToLiveExpiration(Duration.ofSeconds(
	 * ehcache.getTimeToLiveSeconds()))) .build() ); }
	 */
}

package com.example.peliculasSpring.config;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cache.jcache.JCacheCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.cache.jcache.config.JCacheConfigurer;
import org.springframework.cache.jcache.config.JCacheConfig;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        return new JCacheCacheManager(jcacheManager());
    }

    @Bean
    public javax.cache.CacheManager jcacheManager() {
        return javax.cache.Caching.getCachingProvider().getCacheManager();
    }
}

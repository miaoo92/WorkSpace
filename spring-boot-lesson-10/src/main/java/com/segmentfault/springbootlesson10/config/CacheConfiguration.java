package com.segmentfault.springbootlesson10.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * TODO
 *
 * @author miaoo
 * @since 2018/10/30
 */
@Configuration
@EnableCaching
public class CacheConfiguration {


    @Bean("simpleCacheManager")
    public CacheManager simpleCacheManager(){
        SimpleCacheManager simpleCacheManager = new SimpleCacheManager();
        ConcurrentMapCache cache = new ConcurrentMapCache("cache-1");
        ConcurrentMapCache persons = new ConcurrentMapCache("persons");
        simpleCacheManager.setCaches(Arrays.asList(cache,persons));
        return simpleCacheManager;
    }
}

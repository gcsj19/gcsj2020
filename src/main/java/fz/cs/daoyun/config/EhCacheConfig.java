package fz.cs.daoyun.config;

import fz.cs.daoyun.utils.shiro.spring.SpringCacheManagerWrapper;
import net.sf.ehcache.CacheManager;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;


/**
 * @author cjbi
 */
@Configuration
public class EhCacheConfig {

    /**
     * 缓存管理器
     *
     * @return
     */
    @Bean
    public SpringCacheManagerWrapper cacheManager(EhCacheCacheManager springCacheManager) {
        SpringCacheManagerWrapper cacheManager = new SpringCacheManagerWrapper();
        cacheManager.setCacheManager(springCacheManager);
        return cacheManager;
    }


    /**
     * EhCache的配置
     */
    @Bean
    public EhCacheCacheManager springCacheManager(CacheManager cacheManager) {
        return new EhCacheCacheManager(cacheManager);
    }

    /**
     * EhCache的配置
     */
    @Bean
    public EhCacheManagerFactoryBean ehcacheManager() {
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        Resource resource = new ClassPathResource("ehcache.xml");
        ehCacheManagerFactoryBean.setConfigLocation(resource);
        return ehCacheManagerFactoryBean;
    }

}

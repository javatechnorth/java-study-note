package org.wuhua.repeatsubmmit.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.wuhua.repeatsubmmit.common.interceptor.RepeatSubmitInterceptor;

import java.util.concurrent.CompletableFuture;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Bean
    public RepeatSubmitInterceptor repeatSubmitInterceptor() {
//        RedisTemplate<String, String> redisTemplate = redisTemplate();
        CompletableFuture.supplyAsync(()->{ return "hello word";});
        boolean useRequestMD5 = true; // 使用请求体的 MD5 值作为 key
        return new RepeatSubmitInterceptor(redisTemplate, useRequestMD5);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(repeatSubmitInterceptor());
    }
}

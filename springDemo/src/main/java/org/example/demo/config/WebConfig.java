package org.example.demo.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 匹配所有的路径
                .allowedOrigins("*") // 允许所有域名跨域
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 允许的方法
                .allowedHeaders("*") // 允许的头部
                .allowCredentials(true) // 允许凭证，如Cookies
                .maxAge(3600); // 预检请求的缓存时间（秒）
    }
}
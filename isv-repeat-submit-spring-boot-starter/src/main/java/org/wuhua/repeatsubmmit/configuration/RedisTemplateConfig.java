package org.wuhua.repeatsubmmit.configuration;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;

//@Configuration
//@EnableConfigurationProperties(RedisProperties.class)
//@ConditionalOnClass(RedisTemplate.class)
public class RedisTemplateConfig {

    private final RedisProperties redisProperties;

    public RedisTemplateConfig(RedisProperties redisProperties) {
        this.redisProperties = redisProperties;
    }

//    @Bean
//    public RedisConnectionFactory redisConnectionFactory() {
//        return new LettuceConnectionFactory(redisProperties.getHost(), redisProperties.getPort());
//    }
//
//
//    @Bean
//    public RedisTemplate<String, String> redisTemplate() {
//        RedisTemplate<String, String> template = new RedisTemplate<>();
//        template.setConnectionFactory(redisConnectionFactory());
//        return template;
//    }
}
package org.wuhua.repeatsubmmit.common.interceptor;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.wuhua.repeatsubmmit.common.RepeatSubmit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;


public class RepeatSubmitInterceptor implements HandlerInterceptor {

    private RedisTemplate<String, String> redisTemplate;
    private boolean useRequestMD5;

    public RepeatSubmitInterceptor(RedisTemplate<String, String> redisTemplate, boolean useRequestMD5) {
        this.redisTemplate = redisTemplate;
        this.useRequestMD5 = useRequestMD5;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            RepeatSubmit annotation = handlerMethod.getMethodAnnotation(RepeatSubmit.class);
            if (annotation != null && annotation.enable()) {
                String key = buildKey(request);
                if (StringUtils.hasText(redisTemplate.opsForValue().get(key))) {
                    response.getWriter().write("repeat request, please try again later！");
                    return false;
                } else {
                    redisTemplate.opsForValue().set(key, Arrays.toString(request.getInputStream().readAllBytes()), annotation.timeout(), TimeUnit.SECONDS);
                }
            }
        }
        return true;
    }

    private String buildKey(HttpServletRequest request) throws IOException, NoSuchAlgorithmException {
        String key = useRequestMD5 ? hashRequest(request) : request.getRequestURI();
        return "repeat-submit:" + key;
    }

    private String hashRequest(HttpServletRequest request) throws IOException, NoSuchAlgorithmException {
        byte[] hashBytes = MessageDigest.getInstance("MD5").digest(request.getInputStream().readAllBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    // 在这里留空即可
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}

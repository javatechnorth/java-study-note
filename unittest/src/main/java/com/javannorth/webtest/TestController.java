package com.javannorth.webtest;


import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class TestController {


    @Bean
    public  RestTemplate buildPoolingRestTemplate(RestTemplateBuilder builder){
        PoolingHttpClientConnectionManager connectionPoolManager = new PoolingHttpClientConnectionManager();
        connectionPoolManager.setMaxTotal(100);//最大连接数
        connectionPoolManager.setDefaultMaxPerRoute(200);//每个路由默认接收的最大连接数

        HttpClient httpClient = HttpClientBuilder.create()
                .setConnectionManager(connectionPoolManager).build();

        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setHttpClient(httpClient);
        httpRequestFactory.setConnectionRequestTimeout(3000);//获取链接超时时间
        httpRequestFactory.setConnectTimeout(3000);// 指客户端和服务器建立连接的timeout
        httpRequestFactory.setReadTimeout(120000);// 读取数据的超时时间

        return builder.requestFactory(()-> httpRequestFactory).build();
    }
}

package com.gupaoedu.vip.springwebmvc.client;

import com.gupaoedu.vip.springwebmvc.domain.User;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class RestClient {

    public static void main(String[] args) {
        HttpClientBuilder builder = HttpClientBuilder.create();

        HttpClient httpClient = builder.build();
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);

        RestTemplate restTemplate = new RestTemplate(httpRequestFactory);

        String content = restTemplate.getForObject("http://localhost:8080/json/user",String.class);

        User  user = restTemplate.getForObject("http://localhost:8080/json/user",User.class);
        System.out.println(content);
        System.out.println(user);
    }
}

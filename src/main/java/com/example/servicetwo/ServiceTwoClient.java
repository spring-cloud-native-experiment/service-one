package com.example.servicetwo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ServiceTwoClient {
    private final RestTemplate restTemplate;

    @Autowired
    public ServiceTwoClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "defaultResponse")
    public String retrieveFromServiceTwo() {
        ResponseEntity<ServiceTwoResponse> response = this.restTemplate
                .getForEntity("http://service-two/greet", ServiceTwoResponse.class);
        return response.getBody().getHello();
    }

    public String defaultResponse() {
        return "default";
    }

}

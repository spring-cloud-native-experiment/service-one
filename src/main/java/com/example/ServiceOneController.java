package com.example;

import com.example.servicetwo.ServiceTwoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
class ServiceOneController {
    private final ServiceTwoClient serviceTwoClient;

    @Autowired
    ServiceOneController(ServiceTwoClient serviceTwoClient) {
        this.serviceTwoClient = serviceTwoClient;
    }

    @RequestMapping(value = "/greet", method = RequestMethod.GET)
    Map<String, String> greet() {
        return Collections.singletonMap("hello", "world");
    }

    @RequestMapping(value = "/greet-coordinated", method = RequestMethod.GET)
    Map<String, String> greetCoordinated() {
        String greetingFromServiceTwo = serviceTwoClient.retrieveFromServiceTwo();
        return Collections.singletonMap("hello", greetingFromServiceTwo);
    }
}

package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class ServiceOneController {
    @RequestMapping(value = "/greet", method = RequestMethod.GET)
    public @ResponseBody Map<String, String> greet() {
        return Collections.singletonMap("hello", "world");
    }
}

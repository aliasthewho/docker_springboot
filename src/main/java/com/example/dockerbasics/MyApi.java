package com.example.dockerbasics;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class MyApi {

    @GetMapping("/getTestParam")
    public String getMethodNameParam(@RequestParam String param) {
        return new String("hello " + param + "!");
    }

    @GetMapping("/getTestVariable")
    public String getMethodNameVariable(@PathVariable String name) {
        return new String("hello " + name + "!");
    }
    
}

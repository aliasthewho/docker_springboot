package com.example.dockerbasics.api;

import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class MyApi {


    @GetMapping("/getTestParam")
    public String getMethodNameParam(@RequestParam String param) {
        return new String("hello " + param + "!");
    }

    @GetMapping("/getTestVariable/{name}")
    public String getMethodNameVariable(@PathVariable String name) {
        return new String("hello " + name + "!");
    }
    
    @GetMapping
    public String getMethodName() {
        return "hello world infinitew!";
    }

    @GetMapping("/gettest")
    public String getMethodName(String param) {
        return "get test()";
    }

    @GetMapping("/write/{name}")
    public String getMethodNameWrite(@PathVariable String name) {
      
        return new String();
    }
}



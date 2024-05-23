package com.example.dockerbasics;

import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class MyApi {

    @Autowired
    private FileWriterService fileWriterService;

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
        fileWriterService.writeToFile(name);
        return new String();
    }
}

@Service
class FileWriterService {
    private static final String FILE_PATH = "/app/data/output.txt";
    public void writeToFile(String name) {
        try (FileWriter fileWriter = new FileWriter(FILE_PATH, true)) {
            fileWriter.write(name + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

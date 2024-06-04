package com.example.dockerbasics.api;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

@WebMvcTest(MyApi.class)
public class MyApiTest {

    @Autowired
    private MockMvc mockMvc;



    @InjectMocks
    private MyApi myApi;

    @Test
    public void testGetMethodNameParam() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/getTestParam")
                .param("param", "world"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("hello world!"));
    }

    @Test
    public void testGetMethodNameVariable() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/getTestVariable/{name}", "John"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("hello John!"));
    }

    @Test
    public void testGetMethodName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("hello world infinitew!"));
    }

    @Test
    public void testGetMethodNameWithoutParam() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/gettest"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("get test()"));
    }

    @Test
    public void testGetMethodNameWrite() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/write/{name}", "John"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(""));
        // Verify that the writeToFile method is called with the correct argument
        // Mockito.verify(fileWriterService).writeToFile("John");
    }
}
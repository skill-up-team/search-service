package com.healthcare.searchservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.healthcare.searchservice.dto.Doctor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class SearchControllerTest {

    private  final MockMvc mockMvc;

    @Autowired
    public SearchControllerTest(MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    public void helloWorld_basic() throws Exception {
        //call GET "/hello-world"  application/json

        RequestBuilder request = MockMvcRequestBuilders
                .get("/api/v1/search")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("hello world"))
                .andReturn();

        //verify "Hello World"
        assertEquals("hello world", result.getResponse().getContentAsString());
    }

    @Test
    public void searchAvailableDoctor() throws Exception
    {
        mockMvc.perform( MockMvcRequestBuilders
                .post("/api/v1/search")
                .content(asJsonString(new Doctor(1, "Lalith", "Perera", "Physician")))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.firstName").value("Lalith"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.lastName").value("Perera"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.specialization").value("Physician"));
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}

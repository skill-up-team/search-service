package com.healthcare.searchservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/search")
public class SearchController {

    @GetMapping()
    public String getTestMessage() {
       throw new RuntimeException("test exception");
    }
}
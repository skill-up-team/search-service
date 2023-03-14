package com.healthcare.searchservice.controller;

import com.healthcare.searchservice.dto.Doctor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/search")
public class SearchController {

    @GetMapping()
    public String getTestMessage() {
       return "hello world";
    }

    @PostMapping
    public ResponseEntity<Doctor> searchAvailableDoctor(@RequestBody @Validated Doctor doctor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(doctor);
    }
}

package it.bitrock.ssooauth2jwtdemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HrController {

    @GetMapping("/hr")
    public ResponseEntity<String> getAccountList() {
        return ResponseEntity.ok("Hi Hr");
    }
}

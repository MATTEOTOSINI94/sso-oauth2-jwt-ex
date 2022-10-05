package it.bitrock.ssooauth2jwtdemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DevController {

    @GetMapping("/dev")
    public ResponseEntity<String> getAccountList() {
        return ResponseEntity.ok("Hi Dev");
    }
}

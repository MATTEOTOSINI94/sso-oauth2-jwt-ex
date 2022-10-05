package it.bitrock.ssooauth2jwtdemo.controller;

import it.bitrock.ssooauth2jwtdemo.dto.AccountListInformationDTO;
import it.bitrock.ssooauth2jwtdemo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class AccountController {

        @Autowired
        AccountService accountService;


        @GetMapping("/account")
        public ResponseEntity<List<AccountListInformationDTO>> getAccountList() {
                return accountService.getAccountList();
        }

}

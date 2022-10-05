package it.bitrock.ssooauth2jwtdemo.service;

import it.bitrock.ssooauth2jwtdemo.dto.AccountListInformationDTO;
import it.bitrock.ssooauth2jwtdemo.dto.transformer.AccountTransformer;
import it.bitrock.ssooauth2jwtdemo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Transactional
    public ResponseEntity<List<AccountListInformationDTO>> getAccountList() {
        return ResponseEntity.ok(accountRepository.findAll().stream()
                .map(acc -> AccountTransformer.fromAccountViewToAccountListInformationDTO(acc)).toList());

    }
}

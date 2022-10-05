package it.bitrock.ssooauth2jwtdemo.dto.transformer;

import it.bitrock.ssooauth2jwtdemo.dto.AccountListInformationDTO;
import it.bitrock.ssooauth2jwtdemo.dto.RoleDTO;
import it.bitrock.ssooauth2jwtdemo.model.Account;

public class AccountTransformer {


    private AccountTransformer() {

    }

    public static AccountListInformationDTO fromAccountViewToAccountListInformationDTO(Account account) {
        AccountListInformationDTO accountDetailsDTO = new AccountListInformationDTO();
        accountDetailsDTO.setId(account.getId());
        accountDetailsDTO.setFirstName(account.getName());
        accountDetailsDTO.setUsername(account.getUsername());
        accountDetailsDTO.setLastName(account.getSurname());
        accountDetailsDTO.setEmail(account.getEmail());
        accountDetailsDTO.setRole(new RoleDTO(account.getRole().getId(), account.getRole().getName()));
        return accountDetailsDTO;
    }
}

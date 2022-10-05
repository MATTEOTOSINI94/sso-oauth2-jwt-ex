package it.bitrock.ssooauth2jwtdemo.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class AccountListInformationDTO extends AccountDTO implements Serializable {
    private String lastLogin;
    private RoleDTO role;

}

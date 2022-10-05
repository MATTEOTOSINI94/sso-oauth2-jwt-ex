package it.bitrock.ssooauth2jwtdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class AccountDTO implements Serializable {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;


    public AccountDTO(String username, String firstName, String lastName, String email) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public AccountDTO(Long id) {
        this.id = id;
    }

}

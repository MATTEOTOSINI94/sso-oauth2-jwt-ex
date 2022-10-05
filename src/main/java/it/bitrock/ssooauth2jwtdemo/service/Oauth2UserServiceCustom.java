package it.bitrock.ssooauth2jwtdemo.service;

import io.vavr.control.Option;
import it.bitrock.ssooauth2jwtdemo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class Oauth2UserServiceCustom {

    @Autowired
    AccountRepository accountRepository;

    public OAuth2UserService<OidcUserRequest, OidcUser> oidcUserService() {
        final OidcUserService delegate = new OidcUserService();

        return (userRequest) -> {
            OidcUser oidcUser = delegate.loadUser(userRequest);
            return Option.of(accountRepository.findByEmail(oidcUser.getEmail()))
                    .map(account -> new DefaultOidcUser(Set.of(new SimpleGrantedAuthority(account.getRole().getName())),
                            oidcUser.getIdToken(), oidcUser.getUserInfo()))
                    .getOrElseThrow(() -> new OAuth2AuthenticationException("the account " + oidcUser.getEmail() + " is not registered"));
        };
    }

}

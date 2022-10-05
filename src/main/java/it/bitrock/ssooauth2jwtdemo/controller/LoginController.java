package it.bitrock.ssooauth2jwtdemo.controller;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class LoginController {

        @GetMapping("/loginSuccess")
        public Map<String, Object> login(OAuth2AuthenticationToken authentication) {
            OAuth2AuthenticationToken oAuth2AuthenticationToken = authentication;
            return authentication.getPrincipal().getAttributes();
        }
}

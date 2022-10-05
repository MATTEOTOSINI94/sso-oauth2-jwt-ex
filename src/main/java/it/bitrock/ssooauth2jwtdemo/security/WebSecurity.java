package it.bitrock.ssooauth2jwtdemo.security;

import it.bitrock.ssooauth2jwtdemo.service.Oauth2UserServiceCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableOAuth2Client
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurity {


    @Autowired
    private Oauth2UserServiceCustom oauth2UserServiceCustom;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.httpBasic().disable().
                csrf().disable()
                .authorizeHttpRequests(auth -> auth.antMatchers("/login").permitAll()
                        .antMatchers(HttpMethod.GET, "/account").hasAuthority("dev")
                        .antMatchers(HttpMethod.GET, "/dev").hasAuthority("dev")
                        .antMatchers(HttpMethod.GET, "/hr").hasAuthority("hr")
                        .anyRequest().authenticated()
                )
                .oauth2Login().userInfoEndpoint().oidcUserService(oauth2UserServiceCustom.oidcUserService())
                .and()
                .defaultSuccessUrl("/loginSuccess").failureUrl("/loginFailure")
                .and()
                .logout().invalidateHttpSession(true)
                .clearAuthentication(true).logoutSuccessUrl("/login");

        return http.build();
    }

}

package com.SpringBootTutorial.TodoApp.SecurityController;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

@Configuration
public class SecurityController {

    Function<String , String> myPassWordEncoder =
            input-> getPasswordEncoder().encode(input);

    @Bean
    public InMemoryUserDetailsManager getUserDetailManager(){

        UserDetails userDetails = getUser("ayon","12345","USER");
        UserDetails userDetails1 = getUser("zenin","12345","USER");

        return new InMemoryUserDetailsManager(userDetails,userDetails1);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public UserDetails getUser(String name, String password,
                               String roles){
        return User.builder().passwordEncoder(myPassWordEncoder)
                .username(name).password(password)
                .roles(roles).build();
    }

    @Bean
    public SecurityFilterChain filer(HttpSecurity http)
            throws Exception {

        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated()
        );

        http.formLogin(Customizer.withDefaults());
        http.csrf().disable();
        http.headers().frameOptions().disable();

        return http.build();
    }
}

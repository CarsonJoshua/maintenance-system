package com.example.MaintenanceSystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig{


//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .formLogin(form -> form
////                        .defaultSuccessUrl(determineTargetURL(SecurityContextHolder.getContext().getAuthentication()))//TODO this causes an error I don't quite understand yet
//                                .defaultSuccessUrl("/request")
//                )
//                .logout(logout -> logout
//                                .logoutSuccessUrl("/")
//                );
//        return http.build();
//    }
//    private String determineTargetURL(Authentication auth){
//        if(auth.getAuthorities().stream().anyMatch(r->r.getAuthority().equals("MANAGER")))
//            return "/manager";
//        if(auth.getAuthorities().stream().anyMatch(r->r.getAuthority().equals("MAINTENANCE")))
//            return "/maintenance";
//        if(auth.getAuthorities().stream().anyMatch(r->r.getAuthority().equals("TENANT")))
//            return "/request";
//        return "/";
////        return switch(auth){
////            case "MANAGER" -> "/manager";
////            case "MAINTENANCE" -> "/maintenance";
////            case "TENANT" -> "/request";
////            default -> "/";
////        };
//    }
//    @Bean
//    public InMemoryUserDetailsManager userDetailsService() {
////        UserDetails user = User.withDefaultPasswordEncoder()
////                .username("admin")
////                .password("passw0rd")
////                .roles("USER")
////                .build();
//        UserDetails[] users = {
//                User.builder()
//                        .username("manager")
//                        .password("{noop}manager")
//                        .roles("MANAGER")
//                        .build(),
//                User.builder()
//                        .username("maintenance")
//                        .password("{noop}maintenance")
//                        .roles("MAINTENANCE")
//                        .build(),
//                User.builder()
//                        .username("DURI6qZTaFNqZpyINBCY")
//                        .password("{noop}password")
//                        .roles("TENANT")
//                        .build(),
//        };
//        return new InMemoryUserDetailsManager(users);
//    }//TODO multiple users

}

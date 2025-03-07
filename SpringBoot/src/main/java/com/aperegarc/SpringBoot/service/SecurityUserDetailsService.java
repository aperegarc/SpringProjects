package com.aperegarc.SpringBoot.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import com.aperegarc.SpringBoot.repository.UserRepository;
import com.aperegarc.SpringBoot.security.SecurityUser;

@Service
public class SecurityUserDetailsService implements UserDetailsService{

    private final UserRepository userRepository;

    public SecurityUserDetailsService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var optUser = this.userRepository.findByUsername(username);

        if(optUser.isPresent()){
            System.out.println("Encontrado"); 
            return new SecurityUser(optUser.get());
        }

        System.out.println("No encontrado");
        throw new UsernameNotFoundException("User not found: " + username);

    }


}
package com.aperegarc.SpringBoot.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import com.aperegarc.SpringBoot.repository.ClienteRepository;
import com.aperegarc.SpringBoot.security.SecurityUser;

@Service
public class SecurityUserDetailsService implements UserDetailsService{

    private final ClienteRepository clienteRepository;

    public SecurityUserDetailsService(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var optUser = this.clienteRepository.findByUsername(username);

        if(optUser.isPresent()){
            System.out.println("Encontrado"); 
            return new SecurityUser(optUser.get());
        }

        System.out.println("No encontrado");
        throw new UsernameNotFoundException("User not found: " + username);

    }


}
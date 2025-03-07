
package com.aperegarc.SpringBoot.security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.aperegarc.SpringBoot.entity.Cliente;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecurityUser implements UserDetails{

    private final Cliente cliente;

    @Override
    public String getUsername() {
        return cliente.getUsername();
    }

    @Override
    public String getPassword() {
        return cliente.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return cliente.getAuthorities().stream().map(SecurityAuthority::new).toList();
    }

    public boolean isAccountNonExpired(){
        return true;
    }

    public boolean isAccountNonLocked(){
        return true;
    }

    public boolean isCredentialNonExpired(){
        return true;
    }
    
    public boolean isEnabled(){
        return true;
    }
}
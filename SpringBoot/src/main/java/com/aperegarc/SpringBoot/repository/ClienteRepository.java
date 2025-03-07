package com.aperegarc.SpringBoot.repository;


import com.aperegarc.SpringBoot.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    Optional<Cliente> findByUsername(String username);

}

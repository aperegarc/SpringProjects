package com.aperegarc.SpringBoot.repository;


import com.aperegarc.SpringBoot.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {


}

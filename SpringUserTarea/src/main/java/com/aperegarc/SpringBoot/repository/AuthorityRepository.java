package com.aperegarc.SpringBoot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aperegarc.SpringBoot.entity.Authority;
import com.aperegarc.SpringBoot.utils.AuthorityName;


@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long>{

    Optional<Authority> findByName(AuthorityName name);
    
}

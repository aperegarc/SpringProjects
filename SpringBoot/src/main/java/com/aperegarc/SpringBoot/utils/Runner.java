package com.aperegarc.SpringBoot.utils;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.aperegarc.SpringBoot.entity.Authority;
import com.aperegarc.SpringBoot.entity.User;
import com.aperegarc.SpringBoot.repository.AuthorityRepository;
import com.aperegarc.SpringBoot.repository.UserRepository;

@Component
public class Runner implements CommandLineRunner {

    private final UserRepository userRepository;
    private final AuthorityRepository authorityRepository;

    public Runner(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.authorityRepository.count() == 0) {
            this.authorityRepository.saveAll(List.of(
                    new Authority(AuthorityName.ADMIN),
                    new Authority(AuthorityName.READ),
                    new Authority(AuthorityName.WRITE)));
        }

        if (this.userRepository.count() == 0) {
            this.userRepository.saveAll(List.of(
                    new User("admin", "admin", "admin", List.of(
                            this.authorityRepository.findByName(AuthorityName.ADMIN).get(),
                            this.authorityRepository.findByName(AuthorityName.READ).get(),
                            this.authorityRepository.findByName(AuthorityName.WRITE).get()
                            ))));
        }

    }

}

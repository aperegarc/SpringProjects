package com.aperegarc.SpringBoot.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "clientes")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String username;
    private String password;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private List<Tarea> tareas;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "cliente-authority",
        joinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))
    private List<Authority> authorities;


    public Cliente(String name, String username, String pasword, List<Tarea> tareas, List<Authority> authorities) {
        this.name = name;
        this.username = username;
        this.password = pasword;
        this.tareas = tareas;
        this.authorities = authorities;
    }

    

    public Cliente(String name, String username, String pasword, List<Authority> authorities) {
        this.name = name;
        this.username = username;
        this.password = pasword;
        this.tareas = new ArrayList<>();
        this.authorities = authorities;
    }
}

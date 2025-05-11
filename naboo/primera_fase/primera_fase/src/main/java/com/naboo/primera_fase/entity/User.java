package com.naboo.primera_fase.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "naboo_users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name; //Nombre de la empresa
    private String email; // Correo electrónico del usuario
    private String role; // Rol del usuario (ADMIN, HOSTELERO, PROVEEDOR)
    private String nif; // Número de identificación fiscal (si aplica)
    private String phoneNumber; // Número de teléfono del usuario

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", role='" + role + '\'' + '}';
    }
}

package com.naboo.primera_fase.DTO;

public class UserDTOImpl implements UserDTO {
    private Long id;
    private String name;
    private String role;

    public UserDTOImpl(Long id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    @Override
    public Long getId() { return id; }

    @Override
    public String getName() { return name; }

    @Override
    public String getRole() { return role; }
}


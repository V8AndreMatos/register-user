package com.register.user.dto;

import com.register.user.entity.User;

public class UserDTO {

    private Long id;
    private String name;
    private Integer idade;;
    private String email;

    public UserDTO(User entity) {

        id = entity.getId();
        name = entity.getName();
        email = entity.getEmail();
        idade = entity.getIdade();

    }

    public UserDTO(Long id, String name, Integer idade , String email) {
        this.id = id;
        this.name = name;
        this.idade = idade;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}

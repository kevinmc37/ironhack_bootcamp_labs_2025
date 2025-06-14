package com.ironhack.final_project.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.FetchType.EAGER;

/**
 * Entity class for representing a User in the database
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String username;
    private String password;

    @ManyToMany(fetch = EAGER) // forzamos que cuando traemos un usuario de BBDD se traiga su lista de roles
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles = new ArrayList<>(); // mutable, puedo añadir luego roles a este usario

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }
}
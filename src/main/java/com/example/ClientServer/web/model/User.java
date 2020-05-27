package com.example.ClientServer.web.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import com.example.ClientServer.web.model.MySerialization;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "surname")
    private String surName;

    @Column(name = "email")
    private String email;

    @Column(name = "age")
    private String age;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {}

    public User(Long id, String firstName, String password, String age, String lastName, String email, Set<Role> roles) {
        this.id = id;
        this.name = firstName;
        this.password = password;
        this.surName = lastName;
        this.email = email;
        this.age = age;
        this.roles = roles;
    }

    public User(Long id, String firstName, String password, String age, String lastName, String email) {
        this.id = id;
        this.name = firstName;
        this.password = password;
        this.surName = lastName;
        this.email = email;
        this.age = age;
    }

    public User(String firstName, String password, String age, String lastName, String email) {
        this.name = firstName;
        this.password = password;
        this.surName = lastName;
        this.email = email;
        this.age = age;
    }

}

package com.example.securingweb;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
@Data
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;

}

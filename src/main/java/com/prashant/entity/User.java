package com.prashant.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "user_tbl")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int uid;
    private String username;
    private String password;
    private boolean isActive;
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "roles",
    joinColumns = @JoinColumn(name = "uid"))
    private List<String> roles;
}

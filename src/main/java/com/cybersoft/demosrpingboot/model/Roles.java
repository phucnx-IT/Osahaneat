package com.cybersoft.demosrpingboot.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Table(name = "roles")
@Entity(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private int id;
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "description")
    private String desc;
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private Set<Users> users;
}

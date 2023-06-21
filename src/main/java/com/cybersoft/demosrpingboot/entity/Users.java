package com.cybersoft.demosrpingboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    private String username;
    private String password;
    private String email;
    @Column(name = "full_name")
    private String fullName;
    @ManyToOne()
    @JoinColumn(name = "role_id")
    private Roles role;
    @OneToMany(mappedBy = "user")
    private Set<RatingFood> ratingFoods;
    @OneToMany(mappedBy = "user")
    private Set<RatingRestaurant> ratingRestaurants;
    @OneToMany(mappedBy = "user")
    private Set<Orders> orders;

}

package com.cybersoft.demosrpingboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.Set;

@Entity(name="restaurant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String subTitle;
    private String description;
    private String image;
    private Boolean isFreeShip;
    private String address;
    private Date openDate;
    @OneToMany(mappedBy = "restaurant")
    private Set<RatingRestaurant> ratingRestaurants;
    @OneToMany(mappedBy = "restaurant")
    private Set<Orders> orders;
    @OneToMany(mappedBy = "restaurant")
    private Set<MenuRestaurant> menuRestaurants;
    @OneToMany(mappedBy = "restaurant")
    private Set<Promotion> promotions;

}

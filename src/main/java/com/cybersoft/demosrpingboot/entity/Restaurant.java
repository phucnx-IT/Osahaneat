package com.cybersoft.demosrpingboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
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
    @Column(name = "sub_title")
    private String subTile;
    private String description;
    private String image;
    @Column(name = "is_freeship")
    private boolean isFreeship;
    private String address;
    @Column(name = "open_date")
    private LocalDateTime openDate;
    @OneToMany(mappedBy = "restaurant")
    private Set<RatingRestaurant> ratingRestaurants;
    @OneToMany(mappedBy = "restaurant")
    private Set<Orders> orders;
    @OneToMany(mappedBy = "restaurant")
    private Set<MenuRestaurant> menuRestaurants;
    @OneToMany(mappedBy = "restaurant")
    private Set<Promotion> promotions;

}

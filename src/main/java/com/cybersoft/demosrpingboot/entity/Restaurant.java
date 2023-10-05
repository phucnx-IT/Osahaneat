package com.cybersoft.demosrpingboot.entity;

import com.cybersoft.demosrpingboot.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;
import java.util.Set;

@Entity(name="restaurant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Restaurant extends BaseEntity {
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
    @ManyToMany(mappedBy = "restaurants")
    private Set<Category> categories;
    @OneToMany(mappedBy = "restaurant")
    private Set<Promotion> promotions;

}

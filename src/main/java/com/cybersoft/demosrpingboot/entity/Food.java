package com.cybersoft.demosrpingboot.entity;

import com.cybersoft.demosrpingboot.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity(name = "food")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Food extends BaseEntity {

    private String title;
    private String images;
    private String timeShip;
    private boolean isFreeShip;
    private String description;
    private float price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @OneToMany(mappedBy = "food")
    private Set<RatingFood> ratingFoods;
    @ManyToMany(mappedBy = "foods")
    private Set<Orders> orders;

}

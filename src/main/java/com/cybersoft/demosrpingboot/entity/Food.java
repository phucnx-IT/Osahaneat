package com.cybersoft.demosrpingboot.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity(name = "food")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String images;
    private String timeShip;
    private boolean isFreeship;
    private float price;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @OneToMany(mappedBy = "food")
    private Set<RatingFood> ratingFoods;
    @OneToMany(mappedBy = "food")
    private Set<OrderItem> orderItems;

}

package com.cybersoft.demosrpingboot.entity;

import com.cybersoft.demosrpingboot.entity.keys.KeyMenuRestaurant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "menu_restaurant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenuRestaurant {
    @EmbeddedId
    private KeyMenuRestaurant keyMenuRestaurant;
    @ManyToOne
    @JoinColumn(name = "restaurant_id",insertable = false,updatable = false)
    private Restaurant restaurant;
    @ManyToOne
    @JoinColumn(name = "category_id",insertable = false,updatable = false)
    private Category category;

}

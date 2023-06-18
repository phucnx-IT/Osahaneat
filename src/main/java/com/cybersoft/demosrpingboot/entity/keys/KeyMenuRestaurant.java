package com.cybersoft.demosrpingboot.entity.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class KeyMenuRestaurant implements Serializable {
    @Column(name = "category_id")
    private int categoryId;
    @Column(name = "restaurant_id")
    private int restaurantId;
}

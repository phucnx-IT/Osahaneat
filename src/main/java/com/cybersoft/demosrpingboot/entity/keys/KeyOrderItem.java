package com.cybersoft.demosrpingboot.entity.keys;

import com.cybersoft.demosrpingboot.entity.Food;
import com.cybersoft.demosrpingboot.entity.Orders;
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
public class KeyOrderItem implements Serializable {
    @Column(name = "order_id")
    private int order;
    @Column(name = "food_id")
    private int food;
}

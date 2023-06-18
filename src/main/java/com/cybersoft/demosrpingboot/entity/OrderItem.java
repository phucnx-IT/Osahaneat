package com.cybersoft.demosrpingboot.entity;

import com.cybersoft.demosrpingboot.entity.keys.KeyOrderItem;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "order_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {
    @EmbeddedId
    private KeyOrderItem keyOrderItem;
    @ManyToOne
    @JoinColumn(name = "order_id", updatable = false, insertable = false)
    private Orders order;
    @ManyToOne
    @JoinColumn(name = "food_id", updatable = false, insertable = false)
    private Food food;

}

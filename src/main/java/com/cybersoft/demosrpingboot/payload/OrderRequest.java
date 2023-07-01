package com.cybersoft.demosrpingboot.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private int restaurantId;
    private int userId;
    private int[] foodId;
}

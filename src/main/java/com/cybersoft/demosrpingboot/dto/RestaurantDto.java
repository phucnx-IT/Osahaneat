package com.cybersoft.demosrpingboot.dto;

import lombok.*;

import java.util.Date;

@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDto {
    private int id;
    private String title;
    private String subTile;
    private String image;
    private boolean isFreeship;
    private float rating;
}

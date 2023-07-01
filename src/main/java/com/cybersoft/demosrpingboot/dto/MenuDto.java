package com.cybersoft.demosrpingboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenuDto {
    private int id;
    private String title;
    private String images;
    private String timeShip;
    private boolean isFreeShip;
    private String description;
    private float price;
}

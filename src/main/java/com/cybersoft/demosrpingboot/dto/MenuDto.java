package com.cybersoft.demosrpingboot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MenuDto {
    private UUID id;
    private String title;
    private String images;
    private String timeShip;
    private boolean isFreeShip;
    private String description;
    private float price;
}

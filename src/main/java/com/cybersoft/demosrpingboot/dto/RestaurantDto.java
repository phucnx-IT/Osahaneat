package com.cybersoft.demosrpingboot.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RestaurantDto {
    private int id;
    private String title;
    private String subTitle;
    private String image;
    private String description;
    private Boolean isFreeShip;
    private String address;
    private Date openDate;
    private float rating;
    private List<CategoryDto> categoryDtos;
}

package com.cybersoft.demosrpingboot.service.imp;

import com.cybersoft.demosrpingboot.dto.RestaurantDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

public interface RestaurantImp {
    Boolean uploadRestaurant(MultipartFile uploadFile, String title, String subTile, String description, Boolean isFreeship,
                                   String address, Date openDate);
    List<RestaurantDto> getAllRestaurants();

    RestaurantDto getDetailRestaurant(int id);
}

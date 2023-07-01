package com.cybersoft.demosrpingboot.mapping;

import com.cybersoft.demosrpingboot.dto.RestaurantDto;
import com.cybersoft.demosrpingboot.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface RestaurantMapper {
    RestaurantMapper INSTANCE = Mappers.getMapper(RestaurantMapper.class);
    RestaurantDto restaurantToRestaurantDto(Restaurant restaurant);
}

package com.cybersoft.demosrpingboot.mapping;

import com.cybersoft.demosrpingboot.dto.MenuDto;
import com.cybersoft.demosrpingboot.entity.Food;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodMapper {
    FoodMapper INSTANCE = Mappers.getMapper(FoodMapper.class);
    MenuDto foodToMenuDto (Food food);
}

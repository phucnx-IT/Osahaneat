package com.cybersoft.demosrpingboot.mapping;

import com.cybersoft.demosrpingboot.dto.CategoryDto;
import com.cybersoft.demosrpingboot.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {
    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
    CategoryDto categoryToCategoryDto (Category category);
}

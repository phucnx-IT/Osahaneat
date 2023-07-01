package com.cybersoft.demosrpingboot.service;

import com.cybersoft.demosrpingboot.dto.CategoryDto;
import com.cybersoft.demosrpingboot.dto.MenuDto;
import com.cybersoft.demosrpingboot.entity.Category;
import com.cybersoft.demosrpingboot.mapping.FoodMapper;
import com.cybersoft.demosrpingboot.repository.CategoryRepository;
import com.cybersoft.demosrpingboot.service.imp.CategoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService implements CategoryImp {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> getCategoryDtoHomepage() {
        PageRequest pageRequest = PageRequest.of(0,2, Sort.by("nameCate"));
        Page<Category> listCategory = categoryRepository.findAll(pageRequest);
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        listCategory.forEach(category -> {
                CategoryDto categoryDto = new CategoryDto(category.getNameCate(),
                        getMenuDto(category)
                        );
                categoryDtoList.add(categoryDto);
        });
        return categoryDtoList;
    }

    private List<MenuDto> getMenuDto(Category category) {
        return category.getFoods().stream().map(FoodMapper.INSTANCE::foodToMenuDto).collect(Collectors.toList());
    }
}

package com.cybersoft.demosrpingboot.service;

import com.cybersoft.demosrpingboot.repository.FoodRepository;
import com.cybersoft.demosrpingboot.service.imp.FileServiceImp;
import com.cybersoft.demosrpingboot.service.imp.MenuServiceImp;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
@RequiredArgsConstructor
public class MenuService implements MenuServiceImp {

    private final FoodRepository foodRepository;
    private final FileServiceImp fileServiceImp;
    private final Logger logger = LoggerFactory.getLogger(MenuService.class);
    @Override
    public boolean uploadMenu(MultipartFile uploadFile, String title, String timeShip, float price, boolean isFreeShip, int categoryId) {
//        try {
//            fileServiceImp.saveFile(uploadFile);
//            Food food = new Food();
//            food.setTitle(title);
//            food.setTimeShip(timeShip);
//            food.setPrice(price);
//            food.setFreeShip(isFreeShip);
//            food.setImages(uploadFile.getOriginalFilename());
//            Category category = new Category();
//            category.setId(categoryId);
//            food.setCategory(category);
//            foodRepository.save(food);
//            return true;
//        } catch (Exception e) {
//            logger.warn(e.getMessage());
//        }
        return false;
    }
}

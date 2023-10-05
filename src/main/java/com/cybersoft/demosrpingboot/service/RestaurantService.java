package com.cybersoft.demosrpingboot.service;

import com.cybersoft.demosrpingboot.dto.CategoryDto;
import com.cybersoft.demosrpingboot.dto.MenuDto;
import com.cybersoft.demosrpingboot.dto.RestaurantDto;
import com.cybersoft.demosrpingboot.entity.Category;
import com.cybersoft.demosrpingboot.entity.RatingRestaurant;
import com.cybersoft.demosrpingboot.entity.Restaurant;
import com.cybersoft.demosrpingboot.mapping.CategoryMapper;
import com.cybersoft.demosrpingboot.mapping.FoodMapper;
import com.cybersoft.demosrpingboot.mapping.RestaurantMapper;
import com.cybersoft.demosrpingboot.repository.RestaurantRepository;
import com.cybersoft.demosrpingboot.service.imp.FileServiceImp;
import com.cybersoft.demosrpingboot.service.imp.RestaurantImp;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.lang.reflect.Type;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class RestaurantService implements RestaurantImp {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private FileServiceImp fileServiceImp;

    @Autowired
    private Gson gson;

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    private final Logger logger = LoggerFactory.getLogger(RestaurantService.class);
    @Override
    public Boolean uploadRestaurant(MultipartFile uploadFile, String title, String subTile, String description,
                                           Boolean isFreeShip, String address, Date openDate) {
        try {
        fileServiceImp.saveFile(uploadFile);
        Restaurant restaurant = new Restaurant();
        restaurant.setTitle(title);
        restaurant.setSubTitle(subTile);
        restaurant.setDescription(description);
        restaurant.setImage(uploadFile.getOriginalFilename());
        restaurant.setIsFreeShip(isFreeShip);
        restaurant.setAddress(address);
            restaurant.setOpenDate(openDate);
            restaurantRepository.save(restaurant);
            return true;
        } catch (Exception e) {
            logger.warn(e.getMessage());
        }
        return false;
    }
//    @Cacheable(cacheNames = "getAllRestaurant")
    @Override
    public List<RestaurantDto> getAllRestaurants() {
        List<RestaurantDto> restaurantDtos = new ArrayList<>();
//        String dataRedis = redisTemplate.opsForValue().get("restaurant");
//        if (!StringUtils.hasText(dataRedis)) {
            PageRequest pageRequest = PageRequest.of(0, 6);
            Page<Restaurant> restaurantPage = restaurantRepository.findAll(pageRequest);
            for (Restaurant res : restaurantPage
            ) {
                RestaurantDto restaurantDto = RestaurantMapper.INSTANCE.restaurantToRestaurantDto(res);
                restaurantDto.setRating(calculateRating(res.getRatingRestaurants()));
                restaurantDtos.add(restaurantDto);
            }
//            String dataJson = gson.toJson(restaurantDtos);
//            redisTemplate.opsForValue().set("restaurant", dataJson);
//        } else {
//            Type listType = new TypeToken<List<RestaurantDto>>(){}.getType();
//            restaurantDtos = gson.fromJson(dataRedis,listType);
//        }
        return restaurantDtos;
    }

//    @Override
    public RestaurantDto getDetailRestaurant(int id) {
//        Optional<Restaurant> restaurant = restaurantRepository.findById(id);
//        if (restaurant.isPresent()) {
//            RestaurantDto restaurantDto = RestaurantMapper.INSTANCE.restaurantToRestaurantDto(restaurant.get());
//            restaurantDto.setRating(calculateRating(restaurant.get().getRatingRestaurants()));
//            restaurantDto.setCategoryDtos(getCategoryFromRestaurant(restaurant.get().getMenuRestaurants()));
//            return restaurantDto;
//        }
        return null;
    }

//    private List<CategoryDto> getCategoryFromRestaurant(Set<MenuRestaurant> menuRestaurants) {
//        List<CategoryDto> categoryDtoList = new ArrayList<>();
//        menuRestaurants.forEach(menuRestaurant -> {
//            CategoryDto categoryDto = CategoryMapper.INSTANCE.categoryToCategoryDto(menuRestaurant.getCategory());
//            categoryDto.setMenus(getMenuInCategory(menuRestaurant.getCategory()));
//            categoryDtoList.add(categoryDto);
//        });
//        return categoryDtoList;
//    }

    private List<MenuDto> getMenuInCategory(Category category) {
        return category.getFoods().stream().map(FoodMapper.INSTANCE::foodToMenuDto).collect(Collectors.toList());
    }

    private float calculateRating(Set<RatingRestaurant> ratingRestaurants){
        float totalPoint = 0;
        for (RatingRestaurant rating:ratingRestaurants
             ) {
            totalPoint+=rating.getRatePoint();
        }
        return totalPoint /ratingRestaurants.size();
    }
}

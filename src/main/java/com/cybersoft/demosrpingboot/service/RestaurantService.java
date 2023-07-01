package com.cybersoft.demosrpingboot.service;

import com.cybersoft.demosrpingboot.dto.RestaurantDto;
import com.cybersoft.demosrpingboot.entity.RatingRestaurant;
import com.cybersoft.demosrpingboot.entity.Restaurant;
import com.cybersoft.demosrpingboot.repository.RestaurantRepository;
import com.cybersoft.demosrpingboot.service.imp.FileServiceImp;
import com.cybersoft.demosrpingboot.service.imp.RestaurantImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service

public class RestaurantService implements RestaurantImp {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private FileServiceImp fileServiceImp;
    @Override
    public Boolean uploadRestaurant(MultipartFile uploadFile, String title, String subTile, String description,
                                           boolean isFreeship, String address, Date openDate) {
        try {
        fileServiceImp.saveFile(uploadFile);
        Restaurant restaurant = new Restaurant();
        restaurant.setTitle(title);
        restaurant.setSubTile(subTile);
        restaurant.setDescription(description);
        restaurant.setImage(uploadFile.getOriginalFilename());
        restaurant.setFreeship(isFreeship);
        restaurant.setAddress(address);
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm");
//            Date openDateNew = dateFormat.parse(openDate);
            restaurant.setOpenDate(openDate);
            restaurantRepository.save(restaurant);
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public List<RestaurantDto> getAllRestaurants() {
        List<RestaurantDto> restaurantDtos = new ArrayList<>();
        PageRequest pageRequest = PageRequest.of(0,6);
        Page<Restaurant> restaurantPage = restaurantRepository.findAll(pageRequest);
        for (Restaurant res: restaurantPage
             ) {
            restaurantDtos.add(new RestaurantDto(res.getId()
                    ,res.getTitle()
                    ,res.getSubTile()
                    ,res.getImage()
                    ,res.isFreeship()
                    ,calculateRating(res.getRatingRestaurants())));
        }
        return restaurantDtos;
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

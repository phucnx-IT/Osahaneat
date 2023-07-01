package com.cybersoft.demosrpingboot.controller;

import com.cybersoft.demosrpingboot.common.helper.ResponseHelper;
import com.cybersoft.demosrpingboot.service.imp.FileServiceImp;
import com.cybersoft.demosrpingboot.service.imp.RestaurantImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
@CrossOrigin("http://127.0.0.1:5500")
@RequestMapping("/restaurant")
@RestController
public class RestaurantController {
    @Autowired
    private FileServiceImp fileServiceImp;
    @Autowired
    private RestaurantImp restaurantImp;
    @PostMapping("/upload")
    public ResponseEntity<?> uploadFileRestaurant(@RequestParam MultipartFile uploadFile,
                                                  @RequestParam String title,
                                                  @RequestParam String subTile,
                                                  @RequestParam String description,
                                                  @RequestParam boolean isFreeship,
                                                  @RequestParam String address,
                                                  @RequestParam ("openDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date openDate
                                                  ){
        if (restaurantImp.uploadRestaurant(uploadFile,title,subTile,description,isFreeship,address,openDate)) {
            return ResponseHelper.getResponse("Uploaded", HttpStatus.OK);
        }
        return ResponseHelper.getError("Can not upload restaurant", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getfile/{filename:.*}")
    public ResponseEntity<?> getFileRestaurant(@PathVariable String filename){
        Resource resource = fileServiceImp.loadFile(filename);
        if (resource.exists()) {
//            return ResponseEntity.ok().header(
//                    HttpHeaders.CONTENT_DISPOSITION,
//                    "attachment: filename*\"" + resource.getFilename() + "\"").body(resource);
            return new ResponseEntity<>(resource,HttpStatus.OK);
        }
        return ResponseHelper.getError("Can not get images restaurant", HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAllRestaurants(){
        return ResponseHelper.getResponse(restaurantImp.getAllRestaurants(),HttpStatus.OK);
    }
}

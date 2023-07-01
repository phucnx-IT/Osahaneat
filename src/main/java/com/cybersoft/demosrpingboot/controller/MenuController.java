package com.cybersoft.demosrpingboot.controller;

import com.cybersoft.demosrpingboot.common.helper.ResponseHelper;
import com.cybersoft.demosrpingboot.service.imp.MenuServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin("http://127.0.0.1:5500")
@RequestMapping("/menu")
@RestController
public class MenuController {
    @Autowired
    private MenuServiceImp menuServiceImp;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFileMenu(@RequestParam MultipartFile uploadFile,
                                                  @RequestParam String title,
                                                  @RequestParam String timeShip,
                                                  @RequestParam float price,
                                                  @RequestParam boolean isFreeship,
                                                  @RequestParam int categoryId
    ){
        if (menuServiceImp.uploadMenu(uploadFile,title,timeShip,price,isFreeship,categoryId)) {
            return ResponseHelper.getResponse("Uploaded", HttpStatus.OK);
        }
        return ResponseHelper.getError("Can not upload restaurant", HttpStatus.BAD_REQUEST);
    }
}

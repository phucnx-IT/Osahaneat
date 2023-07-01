package com.cybersoft.demosrpingboot.controller;

import com.cybersoft.demosrpingboot.common.helper.ResponseHelper;
import com.cybersoft.demosrpingboot.dto.CategoryDto;
import com.cybersoft.demosrpingboot.service.imp.CategoryImp;
import com.cybersoft.demosrpingboot.service.imp.FileServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://127.0.0.1:5500")
@RequestMapping("/category")
@RestController
public class CategoryController {

    @Autowired
    private CategoryImp categoryImp;

    @Autowired
    private FileServiceImp fileServiceImp;

    @GetMapping("/getmenucategory")
    public ResponseEntity<?> getMenuCategory(){
        List<CategoryDto> categoryDtoList = categoryImp.getCategoryDtoHomepage();
        if (!categoryDtoList.isEmpty()) {
            return ResponseHelper.getResponse(categoryDtoList, HttpStatus.OK);
        }
        return ResponseHelper.getResponse("Empty list", HttpStatus.NO_CONTENT);
    }

    @GetMapping("/getfile/{filename:.*}")
    public ResponseEntity<?> getFileRestaurant(@PathVariable String filename){
        Resource resource = fileServiceImp.loadFile(filename);
        if (resource.exists()) {
            return new ResponseEntity<>(resource,HttpStatus.OK);
        }
        return ResponseHelper.getError("Can not get images menu category", HttpStatus.BAD_REQUEST);
    }
}

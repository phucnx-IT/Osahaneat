package com.cybersoft.demosrpingboot.controller;

import com.cybersoft.demosrpingboot.common.helper.ResponseHelper;
import com.cybersoft.demosrpingboot.payload.OrderRequest;
import com.cybersoft.demosrpingboot.service.imp.OrderServiceImp;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderServiceImp orderServiceImp;

    @PostMapping()
    public ResponseEntity<?> orderRequest(@Valid @RequestBody OrderRequest orderRequest, BindingResult bindingResult){
        if (!bindingResult.hasErrors()) {
            orderServiceImp.insertOrder(orderRequest);
            return ResponseHelper.getResponse("Order is successful", HttpStatus.OK);
        }
        return ResponseHelper.getError("Cant not oder", HttpStatus.BAD_REQUEST);
    }
}

package com.cybersoft.demosrpingboot.service.imp;

import com.cybersoft.demosrpingboot.dto.UserDto;
import com.cybersoft.demosrpingboot.payload.PayloadRequest;
import org.springframework.stereotype.Service;


public interface LoginServiceImp {
    UserDto checkLogin(String username, String password);
    Boolean checkSignup(PayloadRequest payloadRequest);
}

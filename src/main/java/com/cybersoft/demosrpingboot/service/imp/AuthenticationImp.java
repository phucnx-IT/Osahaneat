package com.cybersoft.demosrpingboot.service.imp;

import com.cybersoft.demosrpingboot.dto.AuthenticationResponse;
import com.cybersoft.demosrpingboot.payload.AuthenticationRequest;
import com.cybersoft.demosrpingboot.payload.RegisterRequest;

public interface AuthenticationImp {
    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}

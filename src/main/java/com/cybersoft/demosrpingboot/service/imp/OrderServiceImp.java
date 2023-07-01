package com.cybersoft.demosrpingboot.service.imp;

import com.cybersoft.demosrpingboot.payload.OrderRequest;

public interface OrderServiceImp {
    Boolean insertOrder(OrderRequest orderRequest);
}

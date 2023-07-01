package com.cybersoft.demosrpingboot.service.imp;

import org.springframework.web.multipart.MultipartFile;

public interface MenuServiceImp {
    boolean uploadMenu( MultipartFile uploadFile, String title, String timeShip, float price, boolean isFreeship, int categoryId);
}

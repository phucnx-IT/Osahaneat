package com.cybersoft.demosrpingboot.service.imp;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileServiceImp {
    Boolean saveFile(MultipartFile multipartFile);
    Resource loadFile(String fileName);
}

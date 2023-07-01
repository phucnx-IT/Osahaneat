package com.cybersoft.demosrpingboot.service;

import com.cybersoft.demosrpingboot.service.imp.FileServiceImp;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.*;

@Service
public class FileService implements FileServiceImp {

    @Value("${fileUpload.rootPath}")
    private String rootPath;

    private Path root;

    private void init(){
        try {
            root = Paths.get(rootPath);
            if (!Files.exists(root)) {
                Files.createDirectories(root);
            }
        }catch (Exception e){

        }
    }
    @Override
    public Boolean saveFile(MultipartFile multipartFile) {
        init();
        try {
            Files.copy(multipartFile.getInputStream(), root.resolve(multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public Resource loadFile(String fileName) {
        init();
        try {
            Path file = root.resolve(fileName);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() && resource.isReadable()) {
                return resource;
            }
        } catch (Exception e) {
        }
        return null;
    }
}

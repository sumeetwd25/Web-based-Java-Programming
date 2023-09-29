package com.demo.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.demo.entity.ImageData;
import com.demo.respository.StorageRepository;
import com.demo.util.ImageUtils;

@Service
public class StorageService {

    @Autowired
    private StorageRepository repository;

    public String uploadImage(MultipartFile file) throws IOException {
        //to store LOB data we need to build the entity, so we are using 
    	//ImageData.builder() to get this method in entity class we have
    	//used @Build annotation
        ImageData imageData = repository.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes())).build());
        System.out.println(imageData);
        if (imageData != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return null;
    }

    public byte[] downloadImage(String fileName){
        Optional<ImageData> dbImageData = repository.findByName(fileName);
        //retireve data from optional object
        if(dbImageData.isPresent()) {
        	ImageData ob=dbImageData.get();
        	byte[] images=ImageUtils.decompressImage(ob.getImageData());
            return images;
        }
        return null;
        
    }
}

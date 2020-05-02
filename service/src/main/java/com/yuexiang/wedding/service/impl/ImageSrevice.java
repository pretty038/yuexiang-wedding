package com.yuexiang.wedding.service.impl;

import com.yuexiang.wedding.dao.ImageDAO;
import com.yuexiang.wedding.domain.model.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageSrevice {

    @Autowired
    ImageDAO imageDAO;
    public List<Image> getImages(String appKey,String type){
        return imageDAO.getImageList(appKey,type);
    }
}

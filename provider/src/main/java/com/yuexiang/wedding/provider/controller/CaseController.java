package com.yuexiang.wedding.provider.controller;

import com.yuexiang.wedding.domain.model.AppInfo;
import com.yuexiang.wedding.domain.model.Case;
import com.yuexiang.wedding.domain.model.Image;
import com.yuexiang.wedding.service.impl.CaseService;
import com.yuexiang.wedding.service.impl.FileService;
import com.yuexiang.wedding.service.impl.ImageSrevice;
import lombok.Cleanup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/wedding")
public class CaseController {





    @RequestMapping(value = "/getappinfo")
    public AppInfo getAppInfo(){
        return new AppInfo("眼镜超市","眼镜超市");
    }


    @Autowired
    CaseService caseService;

    @RequestMapping(value = "/addcase")
    public int addCase(Case ca){return caseService.addcase(ca);}

    @RequestMapping(value = "/caselist")
    public List<Case> searchCaseList(@RequestParam(value = "name")String name,@RequestParam(value = "sortedColumn")String sortedColumn){
        return caseService.searchCaseList(name,sortedColumn);
    }






}

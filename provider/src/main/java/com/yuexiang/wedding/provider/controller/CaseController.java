package com.yuexiang.wedding.provider.controller;

import com.yuexiang.wedding.domain.model.AppInfo;
import com.yuexiang.wedding.domain.model.Case;
import com.yuexiang.wedding.domain.model.Comment;
import com.yuexiang.wedding.domain.model.Image;
import com.yuexiang.wedding.service.impl.CaseService;
import com.yuexiang.wedding.service.impl.CommentService;
import com.yuexiang.wedding.service.impl.FileService;
import com.yuexiang.wedding.service.impl.ImageSrevice;
import lombok.Cleanup;
import org.apache.ibatis.annotations.Param;
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
        return new AppInfo("相约婚礼","相约婚礼");
    }


    @Autowired
    CaseService caseService;

    @Autowired
    CommentService commentService;

    @RequestMapping(value = "/addcase")
    public int addCase(Case weddingCase){return caseService.addcase(weddingCase);}

    @RequestMapping(value = "/caselist")
    public List<Case> searchCaseList(@RequestParam(value = "name")String name,@RequestParam(value = "sortedColumn")String sortedColumn){
        return caseService.searchCaseList(name,sortedColumn);
    }

    @RequestMapping(value = "/getcasedetail")
    public Case getCaseById(@Param(value = "id") long id){
        return caseService.getCaseById(id);
    }

    @RequestMapping(value = "/likecase")
    public int likeCase(@Param(value = "caseId")int caseId,@Param(value = "status")int status,@Param(value = "openId")String openId){
        return caseService.updateLiked( caseId, status, openId);
    }

    @RequestMapping(value = "/userlikecase")
    public List<Case> userlikeCases(@Param(value = "openId")String openId){
        return caseService.getLikedCasesByUser( openId);
    }

    @RequestMapping(value = "/addcomment")
    public int addComment(Comment comment){
        return commentService.addComment(comment);
    }

    @RequestMapping(value = "/getcomment")
    public List<Comment> getComment(@Param(value = "objectId")int objectId,@Param(value = "objectType") int objectType){
        return commentService.getComment(objectId,objectType);
    };






}

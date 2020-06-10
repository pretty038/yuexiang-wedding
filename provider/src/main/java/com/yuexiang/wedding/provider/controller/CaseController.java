package com.yuexiang.wedding.provider.controller;

import com.google.common.collect.Lists;
import com.yuexiang.wedding.domain.model.*;
import com.yuexiang.wedding.service.impl.*;
import lombok.Cleanup;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/wedding")
public class CaseController {

    @RequestMapping(value = "/getappinfo")
    public AppInfo getAppInfo(){
        return new AppInfo("悦享婚礼","悦享婚礼");
    }


    @Autowired
    CaseService caseService;

    @Autowired
    CommentService commentService;

    @Autowired
    TeamMemberService teamMemberService;

    @Autowired
    PriceService priceService;

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

    @RequestMapping(value = "/clicklike")
    public int likeCase(@Param(value = "objectId")int objectId,@Param(value="objectType")int objectType,@Param(value = "status")int status,@Param(value = "openId")String openId){
        return caseService.updateLiked( objectId, objectType,status, openId);
    }

    @RequestMapping(value = "/userlikedObjects")
    public <E> List<E> userlikedObjects(@Param(value = "openId")String openId, @Param(value="objectType")int objectType){
        switch (objectType){
            case 1:
                return (List<E>) caseService.getLikedCasesByUser(openId);
            case 2:
                return (List<E>) teamMemberService.getLikedTeamMemberByUser(openId);
            default:
                return Lists.newArrayList();
        }

    }

    @RequestMapping(value = "/addcomment")
    public int addComment(Comment comment){
        return commentService.addComment(comment);
    }

    @RequestMapping(value = "/getcomment")
    public List<Comment> getComment(@Param(value = "objectId")int objectId,@Param(value = "objectType") int objectType){
        return commentService.getComment(objectId,objectType);
    }

    @RequestMapping(value = "/getCommentReply")
    public List<Comment> getCommentReply(@Param(value = "initCommentId")int initCommentId){
        return commentService.getCommentReply(initCommentId);
    }

    @RequestMapping(value = "/addTeamMember")
    public int addTeamMember(TeamMember teamMember){
        return teamMemberService.addTeamMember(teamMember);
    }

    @RequestMapping(value = "/getTeamMemberByIds")
    public List<TeamMember> getTeamMemberByIds(@Param(value = "ids")String ids){
        return teamMemberService.getTeamMemberByIds(ids);
    }


    @RequestMapping(value = "/getPriceByCase")
    public Map<String,List<Price>> getPriceByCase(@Param(value = "caseId")int caseId){

        List<Price> prices= priceService.getPriceByCase(caseId);
        System.out.println(prices);
        Map<String,List<Price>> map=new HashMap<>();
        for(Price price:prices){
            if(map.containsKey(price.getType())){
                ((List<Price>)map.get(price.getType())).add(price);
            }else{
                map.put(price.getType(),Lists.newArrayList(price));
            }
        }
        return map;
    }

    @RequestMapping(value = "/addPriceToCase")
    public int addPriceToCase(Price price){
        return priceService.addPriceDeatil(price);
    }








}

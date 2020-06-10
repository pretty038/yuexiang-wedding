package com.yuexiang.wedding.provider.controller;

import com.yuexiang.wedding.domain.model.*;
import com.yuexiang.wedding.service.impl.*;
import lombok.Cleanup;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

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
    }

    @RequestMapping(value = "/addTeamMember")
    public int addTeamMember(TeamMember teamMember){
        return teamMemberService.addTeamMember(teamMember);
    }

    @RequestMapping(value = "/getTeamMemberByIds")
    public List<TeamMember> getTeamMemberByIds(@Param(value = "ids")String ids){
        return teamMemberService.getTeamMemberByIds(ids);
    }


    @RequestMapping(value = "/likeTeamMember")
    public int likeTeamMember(@Param(value = "teamMemberId")int teamMemberId,@Param(value = "status")int status,@Param(value = "openId")String openId){
        return teamMemberService.updateLiked( teamMemberId, status, openId);
    }

    @RequestMapping(value = "/getLikeTeamMember")
    public List<TeamMember> getLikeTeamMember(@Param(value = "openId")String openId){
        return teamMemberService.getLikedTeamMemberByUser(openId);
    }

    @RequestMapping(value = "/getPriceByCase")
    public List<Price> getPriceByCase(@Param(value = "caseId")int caseId){
        return priceService.getPriceByCase(caseId);
    }

    @RequestMapping(value = "/addPriceToCase")
    public int addPriceToCase(Price price){
        return priceService.addPriceDeatil(price);
    }








}

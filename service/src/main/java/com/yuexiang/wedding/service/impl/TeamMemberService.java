package com.yuexiang.wedding.service.impl;

import com.yuexiang.wedding.dao.CommentDAO;
import com.yuexiang.wedding.dao.TeamMemberDAO;
import com.yuexiang.wedding.domain.enums.ObjectTypeEnum;
import com.yuexiang.wedding.domain.model.TeamMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamMemberService {

    @Autowired
    TeamMemberDAO teamMemberDAO;

    @Autowired
    CommentDAO commentDAO;

    public int addTeamMember(TeamMember teamMember){
        return teamMemberDAO.addTeamMember(teamMember);
    }

    public List<TeamMember> getTeamMemberByIds(String teamMemberIds){
        return teamMemberDAO.getTeamMemberByIds(teamMemberIds);
    }

    public int updateLiked(int teamMemberId,int status,String openId){
        int cnt=commentDAO.updateUserLiked(openId,teamMemberId, ObjectTypeEnum.TEAMMEMBER.getCode(),status);
        if(cnt>0){
            teamMemberDAO.updateLiked(teamMemberId,status);
        }
        return cnt;
    }

    public List<TeamMember> getLikedTeamMemberByUser(String openId){
        return teamMemberDAO.getLikedTeamMemberByUser(openId);
    }

}

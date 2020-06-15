package com.yuexiang.wedding.service.impl;

import com.yuexiang.wedding.dao.CaseDAO;
import com.yuexiang.wedding.dao.CommentDAO;
import com.yuexiang.wedding.dao.TeamMemberDAO;
import com.yuexiang.wedding.domain.model.Case;
import com.yuexiang.wedding.tools.helper.StringUtil;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CaseService {
    @Autowired
    private CaseDAO caseDAO;

    @Autowired
    private TeamMemberDAO teamMemberDAO;

    @Autowired
    private CommentDAO commentDAO;


    /**
     * 案例列表
     * @param name
     * @param sortedColumn
     * @return
     */
    public List<Case> searchCaseList(String name,String sortedColumn){
        List<Case> cases= caseDAO.searchCaseList(name,sortedColumn);
        cases.stream().forEach(x->{
            String team=x.getTeam().replaceAll("\\$\\{","").replaceAll("}","");
            x.setTeam(team);
        });
        return cases;
    }


    public List<Case> getCaseListByTeamMember(int teamMemberId){
        List<Case> cases= caseDAO.getCaseListByTeamMember(teamMemberId);
        cases.stream().forEach(x->{
            String team=x.getTeam().replaceAll("\\$\\{","").replaceAll("}","");
            x.setTeam(team);
        });
        return cases;
    }

    /**
     * 插入案例
     * @param weddingCase
     * @return
     */
    public int addcase(Case weddingCase){
        String[] team=weddingCase.getTeam().split(",");
        weddingCase.setTeam(StringUtils.join(Arrays.stream(team).map(x->"${"+x+"}").collect(Collectors.toList()),','));
        return caseDAO.addCase(weddingCase);
    }

    /**
     * 按id取案例
     * @param id
     * @return
     */
    public Case getCaseById(long id){
         Case c= caseDAO.getCaseById(id);
         c.setTeam(c.getTeam().replaceAll("\\$\\{","").replaceAll("}",""));
         return c;
    }

    /**
     * 点收藏(或取消收藏)
     * @param objectId
     * @param status
     * @param openId
     * @return
     */
    public int updateLiked(int objectId,int objectType,int status,String openId){
        int cnt=commentDAO.updateUserLiked(openId,objectId, objectType,status);
        if(cnt>0){
            switch (objectType){
                case 1:
                    caseDAO.updateLiked(objectId,status);
                    break;
                case 2:
                    teamMemberDAO.updateLiked(objectId,status);
                    break;
                default:
                    break;
            }
        }
        return cnt;
    }

    /**
     * 通过openid获取用户的搜藏案例列表
     * @param openId
     * @return
     */
    public List<Case> getLikedCasesByUser(String openId){
        System.out.println(openId);
        List<Case> cases= caseDAO.getLikedCasesByUser(openId);
        cases.stream().forEach(x->{
            String team=x.getTeam().replaceAll("\\$\\{","").replaceAll("}","");
            x.setTeam(team);
        });
        return cases;
    }






}

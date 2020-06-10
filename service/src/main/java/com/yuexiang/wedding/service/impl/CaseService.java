package com.yuexiang.wedding.service.impl;

import com.yuexiang.wedding.dao.CaseDAO;
import com.yuexiang.wedding.dao.CommentDAO;
import com.yuexiang.wedding.dao.TeamMemberDAO;
import com.yuexiang.wedding.domain.model.Case;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return caseDAO.searchCaseList(name,sortedColumn);
    }

    /**
     * 插入案例
     * @param weddingCase
     * @return
     */
    public int addcase(Case weddingCase){
        return caseDAO.addCase(weddingCase);
    }

    /**
     * 按id取案例
     * @param id
     * @return
     */
    public Case getCaseById(long id){
        return caseDAO.getCaseById(id);
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
        return caseDAO.getLikedCasesByUser(openId);
    }






}

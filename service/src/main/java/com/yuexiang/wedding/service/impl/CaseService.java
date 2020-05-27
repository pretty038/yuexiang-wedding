package com.yuexiang.wedding.service.impl;

import com.yuexiang.wedding.dao.CaseDAO;
import com.yuexiang.wedding.dao.CommentDAO;
import com.yuexiang.wedding.domain.enums.ObjectTypeEnum;
import com.yuexiang.wedding.domain.model.Case;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaseService {
    @Autowired
    private CaseDAO caseDAO;

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
     * @param caseId
     * @param status
     * @param openId
     * @return
     */
    public int updateLiked(int caseId,int status,String openId){
        int cnt=commentDAO.updateUserLiked(openId,caseId, ObjectTypeEnum.WEDDINGCASE.getCode(),status);
        if(cnt>0){
            caseDAO.updateLiked(caseId,status);
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

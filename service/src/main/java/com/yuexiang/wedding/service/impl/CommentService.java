package com.yuexiang.wedding.service.impl;

import com.yuexiang.wedding.dao.CommentDAO;
import com.yuexiang.wedding.domain.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentDAO commentDAO;

    /**
     * 插入评论
     * @param comment
     * @return
     */
    public int addComment(Comment comment){
        return commentDAO.addComment(comment);
    }

    /**
     * 通过案例或者团队人员id获取评论列表
     * @param objectId
     * @param objectType
     * @return
     */
    public List<Comment> getComment(int objectId, int objectType){
        return commentDAO.getCommentByObject(objectId,objectType);
    }
}

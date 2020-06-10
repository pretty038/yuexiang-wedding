package com.yuexiang.wedding.dao;

import com.yuexiang.wedding.domain.model.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CommentDAO {

    @Insert("INSERT INTO user_comment (open_id,object_id,object_type,status,star,content,created,modified) VALUES (#{openId},#{objectId},#{objectType},#{status},#{star},#{content},now(),now())")
    public int addComment(Comment comment);



    @Insert("INSERT INTO user_liked (open_id,object_id,object_type,status,created,modified) VALUES (#{openId},#{objectId},#{objectType},#{status},now(),now()) ON DUPLICATE KEY UPDATE status=#{status},modified=now()")
    public int updateUserLiked(@Param(value = "openId") String openId, @Param(value = "objectId") int objectId, @Param(value = "objectType") int objectType, @Param(value = "status") int status);


    @Select("select * from user_comment where object_id=#{objectId} and object_type=#{objectType} and status=1")
    List<Comment> getCommentByObject(@Param(value = "objectId") int objectId,@Param(value = "objectType") int objectType);


    @Select("select * from user_comment where object_id=#{initCommentId} and object_type=3 and status=1")
    List<Comment> getCommentReply(@Param(value = "initCommentId") int initCommentId);


}

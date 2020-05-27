package com.yuexiang.wedding.dao;

import com.yuexiang.wedding.domain.model.Case;
import com.yuexiang.wedding.domain.model.TeamMember;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CaseDAO {
    @Select("select * from wedding.case where name like '%${name}%' order by ${sortedColumn}")
    List<Case> searchCaseList(@Param(value = "name") String name,@Param(value = "sortedColumn")String sortedColumn);

    @Select("select * from wedding.case where id = #{id}")
    Case getCaseById(@Param(value = "id") long id);


    @Insert("insert ignore into wedding.case (name,image_url,description,tags,init_price,price,liked,team,status,created,modified) values(#{name},#{imageUrl},#{description},#{tags},#{initPrice},#{price},#{liked},#{team},#{status},now(),now())")
    int addCase(Case weddingCase);

    @Update("update  `case` set liked=liked+#{status} where id = #{id}")
    int updateLiked(@Param(value = "id")long id,@Param(value = "status") int status);

    @Update("update  `case` set view=view+1 where id = #{id}")
    int updateViewNum(@Param(value = "id")long id);

    @Select("select * from `case` where id in(select object_id from user_liked where open_id=#{openId} and status=1 and object_type=1)")
    List<Case> getLikedCasesByUser(@Param(value = "openId")String openId);

    @Select("select * from team_member where id in(select object_id from user_liked where open_id=#{openId} and status=1 and object_type=2)")
    List<TeamMember> getLikedTeamMemberByUser(@Param(value = "openId")String openId);




}

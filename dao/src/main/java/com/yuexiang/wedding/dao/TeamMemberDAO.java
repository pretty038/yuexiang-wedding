package com.yuexiang.wedding.dao;

import com.yuexiang.wedding.domain.model.TeamMember;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TeamMemberDAO {




    @Insert("insert ignore into team_member (name,age,gender,city,avatar_url,description,role,liked,view,order_number,book_number,status,created,modified) values(#{name},#{age},#{gender},#{city},#{avatarUrl},#{description},#{role},#{liked},#{view},#{orderNumber},#{bookNumber},#{status},now(),now())")
    int addTeamMember(TeamMember teamMember);

    @Select("select * from team_member where id in(${teamMemberIds})")
    List<TeamMember> getTeamMemberByIds(@Param(value = "teamMemberIds")String teamMemberIds);


    @Select("select * from team_member where id in(select object_id from user_liked where open_id=#{openId} and status=1 and object_type=2)")
    List<TeamMember> getLikedTeamMemberByUser(@Param(value = "openId")String openId);


    @Update("update team_member  set liked=liked+#{status} where id = #{id}")
    int updateLiked(@Param(value = "id")long id,@Param(value = "status") int status);




}

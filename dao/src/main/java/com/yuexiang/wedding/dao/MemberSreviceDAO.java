package com.yuexiang.wedding.dao;

import com.yuexiang.wedding.domain.model.MemberService;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MemberSreviceDAO {

    @Select("select * from teammember_service where member_id=#{memberId}")
    public List<MemberService> getMemberServiceByMemberId(@Param(value = "memberId") Integer memberId);

    @Insert("insert ignore teammember_service (member_id,service_name,description,price,unit,status,created,modified) values(#{memberId},#{serviceName},#{description},#{price},#{unit},#{status},now(),now())")
    public int addMemberService(MemberService memberService);
}

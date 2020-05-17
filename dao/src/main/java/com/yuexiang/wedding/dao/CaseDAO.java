package com.yuexiang.wedding.dao;

import com.yuexiang.wedding.domain.model.Case;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CaseDAO {
    @Select("select * from wedding.case where name like '%${name}%' order by ${sortedColumn}")
    List<Case> searchCaseList(@Param(value = "name") String name,@Param(value = "sortedColumn")String sortedColumn);

    @Select("select * from wedding.case where id = #{id}")
    Case getCaseById(@Param(value = "id") long id);


    @Insert("insert ignore into wedding.case (name,image_url,description,tags,price,liked,team,status,created,modified) values(#{name},#{imageUrl},#{description},#{tags},#{price},#{liked},#{team},#{status},now(),now())")
    int addCase(Case ca);





}

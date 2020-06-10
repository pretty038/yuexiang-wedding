package com.yuexiang.wedding.dao;

import com.yuexiang.wedding.domain.model.Price;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PriceDAO {

    @Select("select * from price_detail where case_id=#{caseId} order by type")
    public List<Price> getPriceDetailByCase(@Param(value = "caseId") int caseId);

    @Insert("replace into price_detail (case_id,name,price,type,status,created,modified) values(#{caseId},#{name},#{price},#{type},#{status},now(),now())")
    public int addPriceToCase(Price price);

}

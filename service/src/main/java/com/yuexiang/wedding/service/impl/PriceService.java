package com.yuexiang.wedding.service.impl;

import com.yuexiang.wedding.dao.PriceDAO;
import com.yuexiang.wedding.domain.model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {
    @Autowired
    PriceDAO priceDAO;

    public List<Price> getPriceByCase(int caseId){
        return priceDAO.getPriceDetailByCase(caseId);
    }

    public int addPriceDeatil(Price price){
        return priceDAO.addPriceToCase(price);
    }

}

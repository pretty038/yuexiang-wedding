package com.yuexiang.wedding.service.impl;

import com.yuexiang.wedding.dao.CaseDAO;
import com.yuexiang.wedding.domain.model.Case;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaseService {
    @Autowired
    private CaseDAO caseDAO;

    public List<Case> searchCaseList(String name,String sortedColumn){
        return caseDAO.searchCaseList(name,sortedColumn);
    }

    public int addcase(Case ca){
        return caseDAO.addCase(ca);
    }

}

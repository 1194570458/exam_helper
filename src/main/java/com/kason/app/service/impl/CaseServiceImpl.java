package com.kason.app.service.impl;

import com.kason.app.dao.CaseMapper;
import com.kason.app.entity.Case;
import com.kason.app.enums.ResultEnum;
import com.kason.app.exception.AppException;
import com.kason.app.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaseServiceImpl implements CaseService {

    @Autowired
    private CaseMapper caseMapper;

    @Override
    public Case addCase(Case c) {
        caseMapper.insertSelective(c);
        return c;
    }

    @Override
    public Case updateCase(Case c) {
        caseMapper.updateByPrimaryKeySelective(c);
        return caseMapper.selectByPrimaryKey(c.getCaseId());
    }

    @Override
    public List<Case> getCases() {
        return caseMapper.selectAll();
    }

    @Override
    public void delCase(Integer id) {
        caseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Case getCase(Integer id) {
        return caseMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Case> getCase(Integer cerId, Integer proId) {
        return caseMapper.selectByCerIdAndProId(cerId,proId);
    }
}

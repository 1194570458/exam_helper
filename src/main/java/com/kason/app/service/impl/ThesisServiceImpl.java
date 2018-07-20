package com.kason.app.service.impl;

import com.kason.app.dao.ThesisMapper;
import com.kason.app.entity.Thesis;
import com.kason.app.service.ThesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ThesisServiceImpl implements ThesisService {

    @Autowired
    private ThesisMapper thesisMapper;

    @Override
    public Thesis addThesis(Thesis thesis) {
        thesisMapper.insertSelective(thesis);
        return thesis;
    }

    @Override
    public Thesis updateThesis(Thesis thesis) {
        thesisMapper.updateByPrimaryKeySelective(thesis);
        return thesisMapper.selectByPrimaryKey(thesis.getThesisId());
    }

    @Override
    public Thesis getThesis(Integer id) {
        return thesisMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Thesis> getTheses() {
        return thesisMapper.selectAll();
    }

    @Override
    public void delThesis(Integer id) {
        thesisMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Thesis> getThesis(Integer cerId, Integer proId) {
        return thesisMapper.selectByCerIdAndProId(cerId,proId);
    }
}

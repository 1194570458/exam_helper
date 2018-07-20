package com.kason.app.service.impl;

import com.kason.app.dao.SynthesizeMapper;
import com.kason.app.entity.Synthesize;
import com.kason.app.service.SynthesizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SynthesizeServiceImp implements SynthesizeService {

    @Autowired
    private SynthesizeMapper synthesizeMapper;

    @Override
    public Synthesize addSynthesize(Synthesize synthesize) {
         synthesizeMapper.insertSelective(synthesize);
        return synthesize;
    }

    @Override
    public Synthesize updateSynthesize(Synthesize synthesize) {
        synthesizeMapper.updateByPrimaryKeySelective(synthesize);
        return synthesizeMapper.selectByPrimaryKey(synthesize.getSynId());
    }

    @Override
    public Synthesize getSynthesize(Integer id) {
        return synthesizeMapper.selectByPrimaryKey(id);
    }

    @Override
    public void delSynthesize(Integer id) {
        synthesizeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Synthesize> getSynthesize(Integer cerId, Integer proId) {
        return synthesizeMapper.selectByCerIdAndProId(cerId,proId);
    }

    @Override
    public List<Synthesize> getSynthesizes() {
        return synthesizeMapper.selectAll();
    }
}

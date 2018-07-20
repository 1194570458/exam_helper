package com.kason.app.service;

import com.kason.app.entity.Synthesize;

import java.util.List;

public interface SynthesizeService {
    Synthesize addSynthesize(Synthesize synthesize);

    Synthesize updateSynthesize(Synthesize synthesize);

    Synthesize getSynthesize(Integer id);

    void delSynthesize(Integer id);

    List<Synthesize> getSynthesize(Integer cerId, Integer proId);

    List<Synthesize> getSynthesizes();
}

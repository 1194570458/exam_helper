package com.kason.app.service;

import com.kason.app.entity.Thesis;

import java.util.List;

public interface ThesisService {
    Thesis addThesis(Thesis thesis);

    Thesis updateThesis(Thesis thesis);

    Thesis getThesis(Integer id);

    List<Thesis> getTheses();

    void delThesis(Integer id);

    List<Thesis> getThesis(Integer cerId, Integer proId);
}

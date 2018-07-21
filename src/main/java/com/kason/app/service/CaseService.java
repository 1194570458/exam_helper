package com.kason.app.service;

import com.kason.app.entity.Case;

import java.util.List;

public interface CaseService {
    Case addCase(Case c);

    Case updateCase(Case c);

    List<Case> getCases();

    void delCase(Integer id);

    Case getCase(Integer id);

    List<Case> getCase(Integer cerId, Integer proId);
}

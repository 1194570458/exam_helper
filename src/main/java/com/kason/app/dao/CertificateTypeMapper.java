package com.kason.app.dao;

import com.kason.app.entity.CertificateType;

import java.util.List;

public interface CertificateTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CertificateType record);

    int insertSelective(CertificateType record);

    CertificateType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CertificateType record);

    int updateByPrimaryKey(CertificateType record);

    List<CertificateType> selectAll();

    CertificateType selectByName(String name);
}
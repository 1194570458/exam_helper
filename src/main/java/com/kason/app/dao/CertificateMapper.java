package com.kason.app.dao;

import com.kason.app.entity.Certificate;

public interface CertificateMapper {
    int deleteByPrimaryKey(Integer cerId);

    int insert(Certificate record);

    int insertSelective(Certificate record);

    Certificate selectByPrimaryKey(Integer cerId);

    int updateByPrimaryKeySelective(Certificate record);

    int updateByPrimaryKey(Certificate record);
}
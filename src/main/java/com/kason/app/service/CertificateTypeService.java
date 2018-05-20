package com.kason.app.service;

import com.kason.app.entity.CertificateType;
import com.kason.app.entity.ExamType;

import java.util.List;

public interface CertificateTypeService {

    List<CertificateType> getAllCertificateType();

    void addCertificateType(CertificateType certificateType);

    void deleteCertificateType(Integer id);

    CertificateType updateCertificateType(CertificateType certificateType);
}

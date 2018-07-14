package com.kason.app.service.impl;

import com.kason.app.dao.CertificateMapper;
import com.kason.app.entity.Certificate;
import com.kason.app.service.CertificateService;
import org.springframework.stereotype.Service;

@Service
public class CertificateServiceImpl implements CertificateService {

    private CertificateMapper certificateMapper;

    @Override
    public Certificate addCertificate(Certificate certificate) {
        certificateMapper.insertSelective(certificate);
        return certificate;
    }

    @Override
    public Certificate updateCertificate(Certificate certificate) {
        return null;
    }
}

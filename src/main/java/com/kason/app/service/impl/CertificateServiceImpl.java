package com.kason.app.service.impl;

import com.kason.app.dao.CertificateMapper;
import com.kason.app.entity.Certificate;
import com.kason.app.enums.ResultEnum;
import com.kason.app.exception.AppException;
import com.kason.app.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificateServiceImpl implements CertificateService {

    @Autowired
    private CertificateMapper certificateMapper;

    @Override
    public Certificate addCertificate(Certificate certificate) {
        certificateMapper.insertSelective(certificate);
        return certificate;
    }

    @Override
    public Certificate updateCertificate(Certificate certificate) {
        if (getCertificate(certificate.getCerId())==null) {
            throw new AppException(ResultEnum.CERTIFICATE_NOT_EXIST);
        }
        certificateMapper.updateByPrimaryKeySelective(certificate);
        return certificateMapper.selectByPrimaryKey(certificate.getCerId());
    }

    @Override
    public Certificate getCertificate(Integer id) {
        return certificateMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Certificate> getCertificates() {
        return certificateMapper.selectAll();
    }

    @Override
    public void delCertificate(Integer id) {
        if (getCertificate(id)==null) {
            throw new AppException(ResultEnum.CERTIFICATE_NOT_EXIST);
        }
        try {
            certificateMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            throw new AppException(ResultEnum.CERTIFICATE_USED);
        }
    }
}

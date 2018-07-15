package com.kason.app.service;

import com.kason.app.entity.Certificate;

import java.util.List;

public interface CertificateService {


    Certificate addCertificate(Certificate certificate);

    Certificate updateCertificate(Certificate certificate);

    Certificate getCertificate(Integer id);

    List<Certificate> getCertificates();

    void delCertificate(Integer id);
}

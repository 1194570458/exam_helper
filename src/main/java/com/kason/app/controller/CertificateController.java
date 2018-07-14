package com.kason.app.controller;

import com.kason.app.entity.Certificate;
import com.kason.app.entity.Result;
import com.kason.app.service.CertificateService;
import com.kason.app.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

    @PostMapping("certificate")
    public Result<Certificate> certificate(@RequestBody Certificate certificate){
        Certificate c =certificateService.addCertificate(certificate);
        return ResultUtil.success(c);
    }




}

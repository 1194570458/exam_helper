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

    /**
     * 添加或者更新证书
     * @param certificate
     * @return
     */
    @PostMapping("certificate")
    public Result<Certificate> certificate(@RequestBody Certificate certificate){
        Certificate c=null;
        if(certificate.getCerId()==null){
             c =certificateService.addCertificate(certificate);
        }
        if(certificate.getCerId()>0){
            c  =certificateService.updateCertificate(certificate);
        }
        return ResultUtil.success(c);
    }




}

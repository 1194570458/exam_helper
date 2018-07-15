package com.kason.app.controller;

import com.kason.app.entity.Certificate;
import com.kason.app.entity.Result;
import com.kason.app.service.CertificateService;
import com.kason.app.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

    /**
     * 添加或者更新证书
     *
     * @param certificate
     * @return
     */
    @PostMapping("/certificate")
    public Result<Certificate> certificate(@RequestBody Certificate certificate) {
        Certificate c = null;
        if (certificate.getCerId() == null) {
            c = certificateService.addCertificate(certificate);
        } else if (certificate.getCerId() > 0) {
            c = certificateService.updateCertificate(certificate);
        }
        return ResultUtil.success(c);
    }


    /**
     * 通过证书id获取证书信息
     *
     * @param id
     * @return
     */
    @GetMapping("/certificate/{id}")
    public Result<Certificate> getCertificate(@PathVariable("id") Integer id) {
        Certificate certificate = certificateService.getCertificate(id);
        return ResultUtil.success(certificate);
    }

    /**
     * 获取所有证书信息
     *
     * @return
     */
    @GetMapping("/certificates")
    public Result<Certificate> getCertificates() {
        List<Certificate> certificates = certificateService.getCertificates();
        return ResultUtil.success(certificates);
    }

    /**
     * 根据证书id删除证书
     *
     * @param id
     * @return
     */
    @PostMapping("/certificate/{id}")
    public Result delCertificate(@PathVariable("id") Integer id) {
        certificateService.delCertificate(id);
        return ResultUtil.success();
    }


}

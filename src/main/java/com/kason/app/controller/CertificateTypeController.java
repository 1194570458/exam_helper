package com.kason.app.controller;


import com.kason.app.entity.CertificateType;
import com.kason.app.entity.Result;
import com.kason.app.enums.ResultEnum;
import com.kason.app.exception.AppException;
import com.kason.app.service.CertificateTypeService;
import com.kason.app.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController

@RequestMapping(value = "/certificate")
public class CertificateTypeController {

    @Autowired
    private CertificateTypeService certificateTypeService;

    @GetMapping(value = "/getall")
    public Result<CertificateType> getAllCertificateType() {
        List<CertificateType> allCertificateType = certificateTypeService.getAllCertificateType();
        if (allCertificateType == null || allCertificateType.size() == 0) {
            throw new AppException(ResultEnum.CERTIFICATE_NULL);
        }
        return ResultUtil.success(allCertificateType);
    }

    @PostMapping(value = "/add")
    public Result<CertificateType> addOneCertificateType(@RequestBody CertificateType certificateType) {
        if (certificateType.getCertificateName() == null || "".equals(certificateType.getCertificateName().trim())) {
            throw new AppException(ResultEnum.CERTIFICATE_NAME_NULL);
        }
        certificateTypeService.addCertificateType(certificateType);
        return ResultUtil.success();
    }

    @PostMapping(value = "/update")
    public Result<CertificateType> updateOneCertificateTyoe(@RequestBody CertificateType certificateType) {
        if (certificateType.getId() == null || certificateType.getId() == 0) {
            throw new AppException(ResultEnum.CERTIFICATE_ID_NULL);
        }
        if (certificateType.getCertificateName() == null || "".equals(certificateType.getCertificateName().trim())) {
            throw new AppException(ResultEnum.CERTIFICATE_NAME_NULL);
        }
        certificateType = certificateTypeService.updateCertificateType(certificateType);
        return ResultUtil.success(certificateType);
    }

    @GetMapping(value = "/delete/{id}")
    public Result<CertificateType> deleteOneCertificateType(@PathVariable(value = "id") Integer id) {
        certificateTypeService.deleteCertificateType(id);
        return ResultUtil.success();
    }


}

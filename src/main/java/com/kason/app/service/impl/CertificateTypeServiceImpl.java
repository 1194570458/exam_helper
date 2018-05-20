package com.kason.app.service.impl;

import com.kason.app.dao.CertificateTypeMapper;
import com.kason.app.dao.ExamTypeMapper;
import com.kason.app.dao.ManagerMapper;
import com.kason.app.entity.CertificateType;
import com.kason.app.entity.ExamType;
import com.kason.app.entity.Manager;
import com.kason.app.enums.ResultEnum;
import com.kason.app.exception.AppException;
import com.kason.app.service.CertificateTypeService;
import com.kason.app.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.annotation.ElementType;
import java.util.List;


@Service
public class CertificateTypeServiceImpl implements CertificateTypeService {

    @Autowired
    private CertificateTypeMapper certificateTypeMapper;

    @Autowired
    private ExamTypeMapper examTypeMapper;

    /**
     * 获取所有证书信息
     *
     * @return 成功返回证书的List，失败返回空
     */
    @Override
    public List<CertificateType> getAllCertificateType() {
        return certificateTypeMapper.selectAll();
    }

    /**
     * 添加一个证书
     *
     * @param certificateType
     */
    @Override
    public void addCertificateType(CertificateType certificateType) {
        if (certificateTypeMapper.selectByName(certificateType.getCertificateName()) == null) {
            certificateTypeMapper.insertSelective(certificateType);
        } else {
            throw new AppException(ResultEnum.CERTIFICATE_EXIST);
        }
    }

    /**
     * 根据证书ID删除一个证书
     *
     * @param id
     */
    @Override
    public void deleteCertificateType(Integer id) {
        if (certificateTypeMapper.selectByPrimaryKey(id) == null) {
            throw new AppException(ResultEnum.CERTIFICATE_NULL);
        }
        if(examTypeMapper.selectByCertificateTypeId(id)!=null)
            throw new AppException(ResultEnum.CERTIFICATE_ISUSEING);
        certificateTypeMapper.deleteByPrimaryKey(id);
    }

    /**
     * 更新证书信息
     *
     * @param certificateType
     * @return
     */
    @Override
    public CertificateType updateCertificateType(CertificateType certificateType) {
        if (certificateTypeMapper.selectByPrimaryKey(certificateType.getId()) == null) {
            throw new AppException(ResultEnum.CERTIFICATE_NULL);
        }
        if (certificateTypeMapper.selectByName(certificateType.getCertificateName()) != null) {
            //判断ID是否相同，若相同则是同一个证书，直接返回
            if (certificateTypeMapper.selectByName(certificateType.getCertificateName()).getId() == certificateType.getId()) {
                return certificateType;
            } else
                throw new AppException(ResultEnum.CERTIFICATE_EXIST);
        }
        certificateTypeMapper.updateByPrimaryKeySelective(certificateType);
        certificateType = certificateTypeMapper.selectByPrimaryKey(certificateType.getId());
        return certificateType;
    }
}

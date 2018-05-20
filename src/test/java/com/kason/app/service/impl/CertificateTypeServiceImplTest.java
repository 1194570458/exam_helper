package com.kason.app.service.impl;

import com.kason.app.entity.CertificateType;
import com.kason.app.service.CertificateTypeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;


@SpringBootTest
@RunWith(SpringRunner.class)
public class CertificateTypeServiceImplTest {

    @Autowired
    private CertificateTypeService certificateTypeService;

    @Test
    public void getAllExamType() {
    }
}
package com.kason.app.controller;

import com.kason.app.entity.Manager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ManagerControllerTest {


    @Autowired
    private ManagerController managerController;

    @Test
    public void managerLogin() {
        Manager manager =new Manager();
        manager.setUsername("admin");
    }
}
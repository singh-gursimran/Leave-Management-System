package com.leavemanagement.system.utilties;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserValidateTest {

    UserValidate userValidate;

    @BeforeEach
    public void init(){
        userValidate =new UserValidate();
    }

    @Test()
    public void authenticateEmailTest(){
        userValidate.validateEmail("hell@yahoo.com");
    }

    @Test
    public void authenticateNameTest(){
        userValidate.validateName("Gursimran Singh");
    }

}
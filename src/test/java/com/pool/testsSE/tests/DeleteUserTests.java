package com.pool.testsSE.tests;

import com.pool.pagesSE.HomePage;
import com.pool.pagesSE.LoginPage;
import com.pool.pagesSE.MyProfilePage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteUserTests extends TestBaseSE{

    @BeforeMethod
    public void precondition(){
        new HomePage(driver).selectEnterBtn();
        new LoginPage(driver).loginData(VALID_MAIL, VALID_PASSWORD);
        new LoginPage(driver).myProfilePage();
    }

    @Test
    public void adminDeleted(){
        new MyProfilePage(driver).deleteUser("marta1@gm.com");
    }


}
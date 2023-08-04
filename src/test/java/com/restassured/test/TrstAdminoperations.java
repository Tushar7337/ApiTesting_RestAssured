package com.restassured.test;

import com.restassured.Pages.AdminCreate;
import com.restassured.Pages.AdminLogin;
import org.testng.annotations.Test;

public class TrstAdminoperations extends AdminLogin {
    @Test
    public void trstAdminOperations() {
        AdminLogin adminLogin = new AdminLogin();
        adminLogin.adminLogin();
        AdminCreate adminCreate = new AdminCreate();
        adminCreate.adminCreate();

    }
}

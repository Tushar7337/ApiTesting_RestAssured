package com.restassured.test;

import com.restassured.Pages.ApiKeyAuth;
import org.testng.annotations.Test;

public class ApiKeyAuthResponse {

    @Test
    public void apiKeyAuth(){

        ApiKeyAuth apiKeyAuth = new ApiKeyAuth();
        apiKeyAuth.apiKeyAuth();
    }

}

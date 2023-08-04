package com.restassured.test;

import com.restassured.Pages.GetApi;
import org.testng.annotations.Test;

public class GetResponse {
    @Test
    public void getResponse() {

        GetApi getApi = new GetApi();
        getApi.getApi();
    }
}

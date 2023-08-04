package com.restassured.test;

import com.restassured.Pages.PutAPI;
import org.testng.annotations.Test;

public class PutResponse {
    @Test
    public void putApi(){

        PutAPI putAPI = new PutAPI();

        putAPI.putApi();

    }

}



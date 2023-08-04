package com.restassured.test;

import com.restassured.Pages.CrScoreApi;
import org.testng.annotations.Test;

public class CrScoreResponse {

    @Test
    public void crScoreResponse(){

        CrScoreApi crscoreResponse = new CrScoreApi();
        crscoreResponse.crScoreApi();

    }

}

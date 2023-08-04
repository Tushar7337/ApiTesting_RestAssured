package com.restassured.Pages;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class ApiKeyAuth {

    public void apiKeyAuth(){

        String url = "https://api.nasa.gov/planetary/apod";

        String apiKey = "a73d0NvMBMaia5TKpEVqmaxTEBPFOKVDdxh6aysk";

        Response response = RestAssured.given()
                .queryParam("api_key",apiKey)
                .get(url);
        response.then().statusCode(200);

        String responseBody = response.getBody().asString();

        System.out.println(responseBody);

        int statusCode = response.getStatusCode();
        System.out.println(statusCode);

        String value = response.jsonPath().getString("date");

        System.out.println("Date of APOD" + value);
    }
}

package com.restassured.Pages;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;
import netscape.javascript.JSException;
import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AdminLogin {
    public String authToken;
    @BeforeClass
    public void adminLogin(){

        baseURI = "https://qa.api.trsthealth.com";

        JSONObject request = new JSONObject();

        request.put("user","super_admin");
        request.put("password","Super1@trst");

       Response response = given()
                .contentType("application/json")
                .body(request.toJSONString())
                .when()
                .post("/api/v1/users/login/admins");

       response.then().statusCode(200)
                .log().all();
       authToken = response.jsonPath().getString("data.access_token");
        System.out.println("Generated Access Token " + authToken);

    }

}

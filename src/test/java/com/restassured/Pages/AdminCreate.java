package com.restassured.Pages;

import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class AdminCreate extends AdminLogin {

    public String adminId;
    public void adminCreate(){

        System.out.println(authToken);
        baseURI = "https://qa.api.trsthealth.com";

        JSONObject request = new JSONObject();

        request.put("firstName","Raw");
        request.put("lastName","TRST");
        request.put("countryCode","+91");
        request.put("phoneNumber","1202155544");
        request.put("email","raw3337737@gmail.com");
        request.put("dob","1998/03/08");
        request.put("timeZone","UTC");

        Response response = given()
                .contentType("application/json")
                .header("Authorization","Bearer" + authToken)
                .body(request.toJSONString())
                .when()
                .post("/api/v1/users");

        response.then().statusCode(201)
                .log().all();

        adminId = response.jsonPath().getString("data.id");
        System.out.println(adminId);

    }

}

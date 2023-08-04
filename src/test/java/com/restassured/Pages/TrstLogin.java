package com.restassured.Pages;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.codehaus.groovy.transform.SourceURIASTTransformation;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;


import static io.restassured.RestAssured.*;


public class TrstLogin {


    public static String accessToken;
   public String userId;
    public String subscriptionId;

@BeforeClass
    public  void trstLogin() {


        baseURI = "https://qa.api.trsthealth.com";

        JSONObject request = new JSONObject();

        request.put("user", "sweden@gmail.com");
        request.put("password", "Pass@1234");

        System.out.println(request.toJSONString());


        Response response = given()
                .contentType("application/json")
                .body(request.toJSONString())
                .when()
                .post("/api/v1/users/login/patients");

        response.then().statusCode(200)
                .log().all()
                .body("data.firstName",equalTo("Stockholm"))
                .body("data.lastName",equalTo("Sweden"));


//        String responseBody = response.getBody().asString();
//
//       System.out.println(responseBody);

        int statusCode = response.getStatusCode();
        System.out.println(statusCode);

        accessToken = response.jsonPath().getString("data.access_token");
        System.out.println("Generated Bearer Token - " + accessToken);

        userId = response.jsonPath().getString("data.id");
        System.out.println("Logged in User Id - " + userId);

    }
/*
    public void userCareProgramDetails() {

        baseURI = "https://qa.api.trsthealth.com";

        //String access = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJjMzEwZjJkNi02ODE0LTQzZjQtOWE2NC03YmRjYTUzZWI3ODMiLCJzdWIiOiJUUlNUX2FmMDAwNTY3LWExYmEtNGM3OS04Y2NkLTA2OGVlYmFmNmE1NSIsInJvbGVzIjoiUk9MRV9BTlNXRVJfUVVFU1RJT05fUkVBRCxST0xFX0NBUkVfUFJPR1JBTV9SRUFEX1NFTEYsUk9MRV9ERVZJQ0VfUkVBRCxST0xFX0VEVUNBVElPTl9SRUFELFJPTEVfRURVQ0FUSU9OX1JFQURfU0VMRixST0xFX09SREVSX0NSRUFURV9TRUxGLFJPTEVfUEFUSUVOVF9ERUxFVEVfU0VMRixST0xFX1BBVElFTlRfUkVBRF9TRUxGLFJPTEVfUEFUSUVOVF9VUERBVEVfU0VMRixST0xFX1NVQlNDUklQVElPTl9VUERBVEVfU0VMRixST0xFX1RSU1RfREVGQVVMVCxST0xFX1dFRUtMWV9QTEFOX1JFQUQiLCJ1c2VydHlwZSI6IlBBVElFTlQiLCJpYXQiOjE2ODg2NTMyODcsImV4cCI6MTY4ODY1NTA4NywiY2FyZVByb2dyYW1JZCI6ImM1NzcxMDdiLTBjYjgtNDg5Mi1hMjM3LWQ5ZWFjYmIxZmVmOSIsImNhcmVQcm9ncmFtSXNQdXJjaGFzZWQiOnRydWUsImNhcmVQcm9ncmFtU3RhcnREYXRlIjoiMjAyMy0wNi0yNiIsImNhcmVQcm9ncmFtRW5kRGF0ZSI6IjIwMjMtMDgtMTUifQ.uuEm9U35ePr3BOaHRfMcevy2Ts5RYfsrlaNbbtI97vM";

        System.out.println(accessToken);

        Response response = RestAssured.given()
                .header("Authorization", "Bearer" + accessToken)
                .contentType("application/json")
                .get("/api/v1/subscriptions/care-programs/patients");

        response.then().statusCode(200);


        String responseBody = response.getBody().asString();
        System.out.println(responseBody);

        subscriptionId = response.jsonPath().getString("data[0].subscriptionId");
        System.out.println("User Subscription ID - " + subscriptionId);
    }


    public void beginSubscription(){

        baseURI = "https://qa.api.trsthealth.com";

        Response response = given()
                .headers("Authorization","Bearer" + accessToken)
                .contentType("application/json")
                .patch("/api/v1/subscriptions/"+subscriptionId);
        response.then().statusCode(200);

    }*/
}
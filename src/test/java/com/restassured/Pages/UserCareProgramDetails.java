package com.restassured.Pages;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class UserCareProgramDetails extends TrstLogin {

    public String subscriptionId;
    @BeforeMethod
    public void userCareProgramDetails(){

        baseURI = "http://localhost:3000";

        System.out.println(accessToken);


        Response response = RestAssured.given()
                .header("Authorization","Bearer" + accessToken)
                .contentType("application/json")
                .get("/api/v1/subscriptions/care-programs/patients");
                response.then().statusCode(200)
                        .log().all();


//        String responseBody = response.getBody().asString();
//
//        System.out.println(responseBody);

        subscriptionId = response.jsonPath().getString("data[0].subscriptionId");
        System.out.println(subscriptionId);


    }

}

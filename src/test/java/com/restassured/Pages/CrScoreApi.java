package com.restassured.Pages;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class CrScoreApi extends TrstLogin {

    public void crScoreApi(){

        baseURI = "http://localhost:3000";

        System.out.println(accessToken);

        Response response = RestAssured.given()
                .headers("Authorization","Bearer" + accessToken)
                .contentType("application/json")
                .get("/api/v1/subscriptions/habits/cr-score/patients");
        response.then().statusCode(200)
                .log().all();

    }

}

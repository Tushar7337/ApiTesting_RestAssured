package com.restassured.Pages;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class DeleteApi {

    public void deleteApi(){

       // Response response = get("\"https://reqres.in/\";");

        baseURI = "https://reqres.in/";

        given()
                .delete("/api/users/2")
                .then()
                .statusCode(204)
                .log().all();

    }

}

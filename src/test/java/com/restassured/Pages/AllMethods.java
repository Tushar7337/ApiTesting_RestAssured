package com.restassured.Pages;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
public class AllMethods {
@Test
    public void getApi(){

        baseURI = "http://localhost:3000";

        given()
                .get("/users")
                .then().statusCode(200)
                .log().all();
    }
@Test
    public void postApi(){

    baseURI = "http://localhost:3000";

        JSONObject request = new JSONObject();

        request.put("Name","Nira");
        request.put("role","Health Care Expert");
        request.put("AKA","");
        request.put("subjectId",1);
        request.put("id",1);

    given()
            .contentType(ContentType.JSON).accept(ContentType.JSON)
            .body(request.toJSONString())
            .when()
            .post("/users")
            .then().statusCode(201)
            .log().all();
    }
@Test
    public void patchApi(){

    baseURI = "http://localhost:3000";

        JSONObject request = new JSONObject();

        request.put("Name","Niranjani");

        given()
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .patch("/users/2")
                .then().statusCode(200)
                .log().all();

    }

}
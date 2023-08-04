package com.restassured.Pages;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.get;

public class PostApi {
    public void postApi() {
        RestAssured.baseURI = "https://reqres.in";


        String requestBody = "{\"name\": \"Chintoo\",\"job\": \"Plumber\"}";

        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("/api/users");

        int statusCode = response.getStatusCode();
        String responseBody = response.getBody().asString();

        System.out.println("Response Body: " + responseBody);
        System.out.println("Status Code: " + statusCode);

        JsonPath jsonPath = response.jsonPath();
        String name = jsonPath.getString("name");
        String job = jsonPath.getString("job");
        String id = jsonPath.getString("id");

        Assert.assertEquals(statusCode, 201);
        Assert.assertEquals(name, "Chintoo");
        Assert.assertEquals(job, "Plumber");
        Assert.assertNotNull(id);

    }
}

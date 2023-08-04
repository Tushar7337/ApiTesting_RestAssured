package com.restassured.Pages;

import static io.restassured.RestAssured.*;

import io.restassured.path.json.JsonPath;
import org.json.simple.JSONObject;
import org.testng.Assert;


import java.util.HashMap;
import java.util.Map;

public class PutAPI {

    public void putApi(){

        baseURI = "https://reqres.in/";

        Map<String,Object> map = new HashMap<String,Object>();

        JSONObject request = new JSONObject();

        request.put("name","Pintoo");
        request.put("job","Electrician");

        System.out.println(request.toJSONString());

                given()
                .body(request.toJSONString())
                .when()
                .put("/api/users/2")
                .then()
                .statusCode(200);
                //.body("name","Pintoo");

        String responseBody = request.toJSONString();
        JsonPath jsonPath = new JsonPath(responseBody);

        String name = jsonPath.getString("name");
        String job = jsonPath.getString("job");

        Assert.assertEquals(name,"Pintoo");
        Assert.assertEquals(job, "Electrician");

    }
}

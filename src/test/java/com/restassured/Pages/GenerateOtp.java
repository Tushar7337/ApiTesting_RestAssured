package com.restassured.Pages;

import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;

import static io.restassured.RestAssured.*;

public class GenerateOtp {

    String otpId;
@Test
    public void generateOtp(){

        baseURI = "https://qa.api.trsthealth.com";

        JSONObject request = new JSONObject();

        request.put("countryCode","+1");
        request.put("phoneNumber","5011478955");

        System.out.println(request.toJSONString());

        Response response =given()
                .contentType("application/json")
                .body(request.toJSONString())
                .when()
                .post("/api/v1/users/patients/otp");

                response.then().statusCode(200)
                .log().all()
                        .body("message",equalTo("OTP sent successfully."));

                otpId  = response.jsonPath().getString("data.otpId");
                System.out.println("Generated OTPID" + otpId);




    }

}

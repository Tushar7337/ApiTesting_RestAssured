package com.restassured.Pages;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.util.Date;
import java.util.HashMap;

import static io.restassured.RestAssured.*;
import com.google.gson.Gson;

@Test
public class AdminCreate extends AdminLogin {

    public String adminId;

    public static long getUniqueNumber(){return new Date().getTime();
    }

    public void adminCreate(){

        System.out.println(authToken);
        baseURI = "https://qa.api.trsthealth.com";

        String uniqueStr = "" + getUniqueNumber();
        String phoneNumber = uniqueStr.substring(uniqueStr.length()-10);
        String email ="raw" + uniqueStr.substring(uniqueStr.length()-7) + "@gmail.com";

        System.out.println("Generated Phone Number" + phoneNumber);
        System.out.println("Generated EmalId" + email);

        JSONObject request = new JSONObject();

        request.put("firstName","Raw");
        request.put("lastName","TRST");
        request.put("countryCode","+91");
        request.put("phoneNumber",phoneNumber);
        request.put("email",email);
        request.put("dob","1998/03/08");
        request.put("timeZone","UTC");

        Response response = given()
                .contentType("application/json")
                .header("Authorization","Bearer" + authToken)
                .body(request.toString())
                .when()
                .post("/api/v1/users");

        response.then().statusCode(201)
                .log().all();

        adminId = response.jsonPath().getString("data.id");
        System.out.println(adminId);

    }

    /*
    //Using External JSON
    public void usingJsonFile() throws FileNotFoundException {

        File file = new File(".\\Request.json");      //Opening the Json File
        FileReader fileReader = new FileReader(file);          //Reading the file
        JSONTokener jsonTokener = new JSONTokener(fileReader); // Reading Json
        JSONObject request = new JSONObject(jsonTokener);      //Using org.JSON.JSONObject Lib

        System.out.println("Generated Request Body through external CSV " + request);

        Response response = given().contentType("application/json")
                .header("Authorization","Bearer" + authToken)
                .body(request.toString())
                .when()
                .post("/api/v1/users");
                response.then().statusCode(201)
                .log().all();


    }*/

/*
    public void pojoMethod() {

        // Using POJO class (Plain Old Java Object --> Getter and Setter)

        POJORequest request = new POJORequest();

        String uniqueStr = "" + getUniqueNumber();
        String phoneNumber = uniqueStr.substring(uniqueStr.length()-10);
        String email = "raw" + uniqueStr.substring( uniqueStr.length()-7) + "@gmail.com";

        System.out.println("Generated Phone Number " + phoneNumber);
        System.out.println("Generated Email " + email);


        request.setFirstName("Raw");
        request.setLastName("TRST");
        request.setCountryCode("+91");
        request.setPhoneNumber(phoneNumber);
        request.setEmail(email);
        request.setDob("1998/03/08");
        request.setTimeZone("UTC");

       System.out.println("POJO Request Body" + request);

        Response response = given()
                .contentType("application/json")
                .header("Authorization","Bearer" + authToken)
                .body(request)
                .when()
                .post("/api/v1/users");
        response.then()
                .statusCode(201)
                .log().all();

    }*/
    /*
    public void hashMap(){
         // 1. Using HashMap

        String uniqueStr = "" + getUniqueNumber();
        String phoneNumber = uniqueStr.substring(uniqueStr.length()-10);
        String email = "raw" + uniqueStr.substring(uniqueStr.length()-7) + "@gmail.com";

        System.out.println("Generted Phone Number " + phoneNumber);
        System.out.println("Generated Email " + email);

        HashMap request = new HashMap();

        request.put("firstName","Raw");
        request.put("lastName","TRST");
        request.put("countryCode","+91");
        request.put("phoneNumber",phoneNumber);
        request.put("email",email);
        request.put("dob","1998/03/08");
        request.put("timeZone","UTC");

        String requestToString = new Gson().toJson(request);   // External Dependency to convert Hashmap Keys into String

        System.out.println("HashMap Request Body" + requestToString);

        Response response = given().contentType("application/json")
                .header("Authorization","Bearer " + authToken)
                .body(request)
                .when()
                .post("/api/v1/users");
                response.then()
                .statusCode(201)
                       // .body("firstName",Matchers.equalTo("Raw"))   // Assertion using Hamcrest Matchers
                .log().all();

    }
*/
}

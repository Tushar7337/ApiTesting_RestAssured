package com.restassured.test;

import com.restassured.Pages.GenerateOtp;
import org.testng.annotations.Test;

public class GenerateOtpResponse {
@Test
    public void generateOtpResponse(){

        GenerateOtp generateOtpResponse = new GenerateOtp();
        generateOtpResponse.generateOtp();

    }

}

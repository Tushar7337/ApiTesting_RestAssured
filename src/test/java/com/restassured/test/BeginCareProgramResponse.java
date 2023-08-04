package com.restassured.test;

import com.restassured.Pages.BeginCareProgram;
import com.restassured.Pages.TrstLogin;
import org.testng.annotations.Test;

@Test

public class BeginCareProgramResponse extends TrstLogin {

    public void beginCareProgramResponse(){

        BeginCareProgram beginCareProgram = new BeginCareProgram();
        beginCareProgram.userCareProgramDetails();
        beginCareProgram.beginCareProgram();


    }

}

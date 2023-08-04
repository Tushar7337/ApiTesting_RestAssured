package com.restassured.test;

import com.restassured.Pages.BeginCareProgram;
import com.restassured.Pages.TrstLogin;
import com.restassured.Pages.UserCareProgramDetails;
import org.testng.annotations.Test;

public class UserCareProgramDetailsResponse extends TrstLogin {

    @Test
    public void userCareProgramDetails(){

       UserCareProgramDetails userCareProgramDetails = new UserCareProgramDetails();
       userCareProgramDetails.userCareProgramDetails();
        BeginCareProgram beginCareProgram = new BeginCareProgram();
        beginCareProgram.beginCareProgram();

    }

}

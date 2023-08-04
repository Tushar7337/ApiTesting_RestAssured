package com.restassured.test;

import com.restassured.Pages.TrstLogin;
import org.testng.annotations.Test;

public class TrstLoginresponse {

    @Test
    public void trstLoginresponse(){

        TrstLogin trstLoginresponse = new TrstLogin();
        trstLoginresponse.trstLogin();
      // trstLoginresponse.userCareProgramDetails();
       // trstLoginresponse.beginSubscription();

    }



}

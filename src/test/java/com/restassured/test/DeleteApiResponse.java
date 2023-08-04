package com.restassured.test;

import com.restassured.Pages.DeleteApi;
import org.testng.annotations.Test;

public class DeleteApiResponse {
@Test
    public void deleteApi(){

        DeleteApi deleteApi = new DeleteApi();
        deleteApi.deleteApi();

    }

}

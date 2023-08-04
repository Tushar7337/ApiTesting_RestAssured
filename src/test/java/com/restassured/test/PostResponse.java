package com.restassured.test;

import com.restassured.Pages.PostApi;
import org.testng.annotations.Test;

@Test
public class PostResponse {

    public void postApi(){

        PostApi postApi = new PostApi();

        postApi.postApi();

    }
}

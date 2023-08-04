package com.restassured.Pages;
import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
public class GetApi {
        public void getApi() {
            Response response = get("https://bookstore.toolsqa.com/BookStore/v1/Books");

            String responseBody = response.getBody().asString();
            JsonPath jsonPath = new JsonPath(responseBody);

            int statusCode = response.statusCode();
            String title = jsonPath.getString("books[3].title");
            String subTitle = jsonPath.getString("books[3].subTitle");
            String author = jsonPath.getString("books[3].author");
            String publish_date = jsonPath.getString("books[3].publish_date");
            String publisher = jsonPath.getString("books[3].publisher");
            int pages = jsonPath.getInt("books[3].pages");
            String website = jsonPath.getString("books[3].website");

            System.out.println("Status Code = " + response.statusCode());
            System.out.println("Response Body = " + response.getBody().asString());

            Assert.assertEquals(statusCode, 200);
            Assert.assertEquals(title, "Speaking JavaScript");
            Assert.assertEquals(subTitle, "An In-Depth Guide for Programmers");
            Assert.assertEquals(author, "Axel Rauschmayer");
            Assert.assertEquals(publish_date, "2014-02-01T00:00:00.000Z");
            Assert.assertEquals(publisher, "O'Reilly Media");
            Assert.assertEquals(pages, 460);
            Assert.assertEquals(website, "http://speakingjs.com/");

        }
}


package qa.demo.tests;

import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import qa.demo.api.LoginApi;

public class TestBase {

    LoginApi authorizationApi = new LoginApi();

    @BeforeAll
    static void setUp() {
        Configuration.baseUrl = "https://demoqa.com";
        RestAssured.baseURI = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }
}

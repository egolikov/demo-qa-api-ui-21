package qa.demo.api;

import io.qameta.allure.Step;
import qa.demo.models.LoginBodyModel;
import qa.demo.models.LoginResponseModel;

import static io.restassured.RestAssured.given;
import static qa.demo.specs.LoginSpec.successLoginRequestSpec;
import static qa.demo.specs.LoginSpec.successLoginResponseSpec;

public class LoginApi {

    @Step("Успешная авторизация")
    public static LoginResponseModel successLogin(String userName, String password) {
        LoginBodyModel authorizationData = new LoginBodyModel();
        authorizationData.setUserName(userName);
        authorizationData.setPassword(password);

        return given(successLoginRequestSpec)
                .body(authorizationData)
                .when()
                .post("/Account/v1/Login")
                .then()
                .spec(successLoginResponseSpec)
                .extract().as(LoginResponseModel.class);
    }
}

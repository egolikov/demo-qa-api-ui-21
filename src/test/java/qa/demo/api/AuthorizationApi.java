package qa.demo.api;

import io.qameta.allure.Step;
import qa.demo.models.CredentialsModel;
import qa.demo.models.LoginResponseModel;

import static io.restassured.RestAssured.given;
import static qa.demo.specs.LoginSpec.successLoginRequestSpec;
import static qa.demo.specs.LoginSpec.successLoginResponseSpec;

public class AuthorizationApi {

    @Step("Запрос на авторизацию")
    public LoginResponseModel login(CredentialsModel credentials) {
        return given(successLoginRequestSpec)
                .body(credentials)
                .when()
                .post("/Account/v1/Login")
                .then()
                .spec(successLoginResponseSpec)
                .extract().as(LoginResponseModel.class);
    }
}

package qa.demo.helpers;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.Cookie;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class LoginExtension implements BeforeEachCallback {

    private final String userId;
    private final String token;
    private final String expires;

    public LoginExtension(String userId, String token, String expires) {
        this.userId = userId;
        this.token = token;
        this.expires = expires;
    }

    public LoginExtension() {
        this.userId = "defaultUserId"; // Установите значение по умолчанию, если нужно
        this.token = "defaultToken"; // Установите значение по умолчанию, если нужно
        this.expires = "defaultExpires"; // Установите значение по умолчанию, если нужно
    }

    @Override
    public void beforeEach(ExtensionContext context) {
        open("/favicon.ico");
        getWebDriver().manage().addCookie(new Cookie("userID", userId));
        getWebDriver().manage().addCookie(new Cookie("token", token));
        getWebDriver().manage().addCookie(new Cookie("expires", expires));
    }
}

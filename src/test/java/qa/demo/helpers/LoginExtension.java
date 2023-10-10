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

    public LoginExtension() {
        this.userId = "";
        this.token = "";
        this.expires = "";
    }

    @Override
    public void beforeEach(ExtensionContext context) {
        open("/favicon.ico");
        getWebDriver().manage().addCookie(new Cookie("userID", userId));
        getWebDriver().manage().addCookie(new Cookie("token", token));
        getWebDriver().manage().addCookie(new Cookie("expires", expires));
    }
}

package qa.demo.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.*;

public class UserProfilePage {

    @Step("Проверка отсутствия в списке профиля удаленной книги")
    public static void checkDisappearBook(String bookId) {
        open("/profile");
        $("[id='" + bookId + "']").shouldBe(disappear);
    }
}

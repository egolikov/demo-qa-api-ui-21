package qa.demo.api;

import io.qameta.allure.Step;
import qa.demo.models.AddBooksListModel;
import qa.demo.models.AddBooksResponseModel;
import qa.demo.models.DeleteBookModel;
import qa.demo.models.LoginResponseModel;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static qa.demo.specs.BookSpec.*;

public class BooksApi {

    @Step("Запрос на удаление всех книг")
    public void deleteAllBooks(LoginResponseModel loginResponse) {
        given(bookRequestSpec)
                .header("Authorization", "Bearer " + loginResponse.getToken())
                .queryParam("UserId", loginResponse.getUserId())
                .when()
                .delete("/BookStore/v1/Books")
                .then()
                .spec(successDeleteBookResponseSpec);
    }

    @Step("Запрос на добавление книги")
    public void addBook(LoginResponseModel loginResponse, AddBooksListModel booksList) {
        given(bookRequestSpec)
                .header("Authorization", "Bearer " + loginResponse.getToken())
                .body(booksList)
                .when()
                .post("/BookStore/v1/Books")
                .then()
                .spec(successAddBookResponseSpec)
                .extract().as(AddBooksResponseModel.class);
    }

    @Step("Запрос на удаление одной книги")
    public void deleteOneBook(LoginResponseModel loginResponse, DeleteBookModel deleteBookModel) {
        given(bookRequestSpec)
                .header("Authorization", "Bearer " + loginResponse.getToken())
                .queryParam("UserId", loginResponse.getUserId())
                .body(deleteBookModel)
                .when()
                .delete("/BookStore/v1/Book")
                .then()
                .spec(successDeleteBookResponseSpec);
    }
}

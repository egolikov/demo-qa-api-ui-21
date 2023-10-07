package qa.demo.api;

import io.qameta.allure.Step;
import qa.demo.models.*;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
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

    @Step("Создание объекта IsbnModel")
    public IsbnModel createIsbnModel(String isbn) {
        IsbnModel isbnModel = new IsbnModel();
        isbnModel.setIsbn(isbn);
        return isbnModel;
    }

    @Step("Создание объекта AddBooksListModel")
    public AddBooksListModel createAddBooksListModel(LoginResponseModel loginResponse, IsbnModel isbnModel) {
        AddBooksListModel booksList = new AddBooksListModel();
        booksList.setUserId(loginResponse.getUserId());
        List<IsbnModel> isbnList = new ArrayList<>();
        isbnList.add(isbnModel);
        booksList.setCollectionOfIsbns(isbnList);
        return booksList;
    }

    @Step("Создание объекта DeleteBookModel")
    public DeleteBookModel createDeleteBookModel(LoginResponseModel loginResponse, IsbnModel isbnModel) {
        DeleteBookModel deleteBookModel = new DeleteBookModel();
        deleteBookModel.setUserId(loginResponse.getUserId());
        deleteBookModel.setIsbn(isbnModel.getIsbn());
        return deleteBookModel;
    }
}

package qa.demo.tests;

import org.junit.jupiter.api.DisplayName;
import qa.demo.helpers.WithLogin;
import qa.demo.models.AddBooksListModel;
import qa.demo.models.DeleteBookModel;
import qa.demo.models.IsbnModel;
import qa.demo.models.LoginResponseModel;
import org.junit.jupiter.api.Test;
import qa.demo.pages.UserProfilePage;

import static qa.demo.tests.TestData.*;

public class DeleteBookFromProfileTest extends TestBase {

    @WithLogin
    @Test
    @DisplayName("Удаление добавленной книги из профиля")
    void deleteBookFromProfileTest() {

        LoginResponseModel loginResponse = authorizationApi.login(credentials);

        IsbnModel isbnModel = booksApi.createIsbnModel(getISBN());
        AddBooksListModel booksList = booksApi.createAddBooksListModel(loginResponse, isbnModel);
        DeleteBookModel deleteBookModel = booksApi.createDeleteBookModel(loginResponse, isbnModel);

        booksApi.deleteAllBooks(loginResponse);
        booksApi.addBook(loginResponse, booksList);
        booksApi.deleteOneBook(loginResponse, deleteBookModel);

        UserProfilePage.checkDisappearBook("see-book-Understanding ECMAScript 6");
    }
}

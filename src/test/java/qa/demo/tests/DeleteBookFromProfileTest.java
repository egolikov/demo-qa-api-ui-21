package qa.demo.tests;

import org.junit.jupiter.api.DisplayName;
import qa.demo.models.AddBooksListModel;
import qa.demo.models.DeleteBookModel;
import qa.demo.models.IsbnModel;
import qa.demo.models.LoginResponseModel;
import org.junit.jupiter.api.Test;
import qa.demo.pages.UserProfilePage;

import java.util.ArrayList;
import java.util.List;

import static qa.demo.tests.TestData.credentials;

public class DeleteBookFromProfileTest extends TestBase {

    @Test
    @DisplayName("Удаление добавленной книги из профиля")
    void deleteBookFromProfileTest() {

        LoginResponseModel loginResponse = authorizationApi.login(credentials);

        IsbnModel isbnModel = new IsbnModel();
        isbnModel.setIsbn("9781593277574");
        List<IsbnModel> isbnList = new ArrayList<>();
        isbnList.add(isbnModel);

        AddBooksListModel booksList = new AddBooksListModel();
        booksList.setUserId(loginResponse.getUserId());
        booksList.setCollectionOfIsbns(isbnList);

        DeleteBookModel deleteBookModel = new DeleteBookModel();
        deleteBookModel.setIsbn("9781593277574");
        deleteBookModel.setUserId(loginResponse.getUserId());

        booksApi.deleteAllBooks(loginResponse);
        booksApi.addBook(loginResponse, booksList);
        booksApi.deleteOneBook(loginResponse, deleteBookModel);

        UserProfilePage.openUserProfileWithCookies(loginResponse.getUserId(), loginResponse.getToken(), loginResponse.getExpires());
        UserProfilePage.checkDisappearBook("see-book-Understanding ECMAScript 6");
    }
}

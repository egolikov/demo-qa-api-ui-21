package qa.demo.models;

import lombok.Data;

import java.util.List;

@Data
public class AddBooksResponseModel {
    private List<AddBookModel> books;

    @Data
    public static class AddBookModel {
        private String isbn;

    }
}

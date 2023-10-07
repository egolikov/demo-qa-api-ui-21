package qa.demo.tests;

import qa.demo.models.CredentialsModel;

public class TestData {

    private static final String LOGIN = "egolikov";
    private static final String PASSWORD = "Egolikov*0009";
    private static final String ISBN = "9781593277574";

    public static CredentialsModel credentials = new CredentialsModel(LOGIN, PASSWORD);

    public static String getISBN() {
        return ISBN;
    }
}
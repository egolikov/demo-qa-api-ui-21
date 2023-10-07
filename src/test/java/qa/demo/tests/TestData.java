package qa.demo.tests;

import qa.demo.models.CredentialsModel;

public class TestData {

    private static final String login = "egolikov";
    private static final String password = "Egolikov*0009";

    public static CredentialsModel credentials = new CredentialsModel(login, password);
}
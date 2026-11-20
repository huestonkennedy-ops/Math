package application;

import javafx.application.Application;
import javafx.stage.Stage;
import logic.Users;
import subject.Subject;
import ui.LoginScreen;

public class App extends Application {
    public void start(Stage window) {
        LoginScreen login = new LoginScreen(new Users(), window);
        login.getLogin();
        window.show();
    }
    public static void main(String[] args) {
        launch();       
}
}   
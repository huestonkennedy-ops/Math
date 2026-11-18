package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import logic.Users;
import subject.Questions;
import ui.LoginScreen;

public class App extends Application {
    public void start(Stage window) {
        Questions questions = new Questions(new Scene(new HBox()), window);
        questions.startRandom();
        window.show();

    }
    public static void main(String[] args) {
        launch();       
}
}   
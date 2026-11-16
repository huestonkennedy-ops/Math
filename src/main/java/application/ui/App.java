package application.ui;

import application.logic.QuestionClass;
import application.logic.Questions;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage window) {
       QuestionClass questions = new QuestionClass();
       Scene scene = new Scene(questions.getHorizontal());
       window.setScene(scene);
       window.show();
    }
    

    public static void main(String[] args) {
        launch();
    }
}
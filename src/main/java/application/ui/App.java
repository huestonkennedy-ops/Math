package application.ui;

import application.logic.Questions;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage window) {
       Questions questions = new Questions();
       questions.addQuestion("What is 3 x 2", 6);
       questions.addQuestion("What is 5!", 120);
       questions.addQuestion("What is 7 x 4", 28);
       Scene scene = new Scene(questions.randomQuestions());
       window.setScene(scene);
       window.show();
    }
    

    public static void main(String[] args) {
        launch();
    }
}
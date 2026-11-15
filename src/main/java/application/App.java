package application;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import application.logic.Questions;

public class App extends Application {

    @Override
    public void start(Stage window) {
       Questions questions = new Questions();
       questions.addQuestion("What is 3 x 2", 6);
       questions.addQuestion("What is 5*2.5", 12.5);
       Scene scene = new Scene(questions.randomSimple());
       window.setScene(scene);
       window.show();
    }
    

    public static void main(String[] args) {
        launch();
    }
}
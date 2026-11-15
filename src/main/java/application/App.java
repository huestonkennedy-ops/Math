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

public class App extends Application {

    @Override
    public void start(Stage window) {
       VBox Questions = new VBox();
       Label[] reminder = {new Label("What is 3 x 2 : "), new Label("What is 4! : "), new Label("What is 5^2 :")};
       HBox[] layouts = {new HBox(), new HBox(), new HBox()};
       TextField[] questions = {new TextField(), new TextField(), new TextField()}; 
       Button[] submit = {new Button("Press to submit"), new Button("Press to submit"), new Button("Press to submit")};
        int[] answer = {6, 24, 5*5};
        Label[] correct = {new Label(), new Label(), new Label()};
        for(int i = 0; i<reminder.length; i++) {
        setButton(i, submit, questions, layouts, answer, correct, Questions, reminder);
        }
        Scene scene = new Scene(Questions);
        window.setScene(scene);
        window.show();


    }
    public static void setButton(int i, Button[] submit, TextField[] questions, HBox[] layouts, int[] answer, Label[] correct, VBox Questions, Label[] reminder) {
        submit[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override 
                public void handle(ActionEvent event) {
                    try {
                        int response = Integer.valueOf(questions[i].getText());
                        if(response == answer[i]) {
                            correct[i].setText("Correct!");
                        } else {
                            correct[i].setText("Wrong");
                        }
                    } catch(Exception e) {
                        correct[i].setText("Invalid formatting");
                    }
                }
            });
            layouts[i].getChildren().addAll(reminder[i], questions[i], submit[i], correct[i]);
            layouts[i].setSpacing(20);
            Questions.getChildren().add(layouts[i]);
    }

    public static void main(String[] args) {
        launch();
    }
}
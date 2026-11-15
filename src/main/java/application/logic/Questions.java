package application.logic;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class Questions {
    private ArrayList<HBox> questions = new ArrayList<>();
    public Questions() {

    }
    public HBox addQuestion(String question, double answer) {
        HBox layout = new HBox();
        Button submit = new Button("Submit your Answer");
        Label reminder = new Label(question);
        TextField getAnswer = new TextField();
        Label correct = new Label();
        this.setButton(answer, layout, submit, reminder, getAnswer, correct);
        questions.add(layout);
        return layout;
    }
    public void setButton(double answer, HBox layout, Button submit, Label reminder, TextField getAnswer, Label Correct) {
       submit.setOnAction(new EventHandler<ActionEvent>() {
        @Override 
        public void handle(ActionEvent event) {
             try {
            double response = Double.valueOf(getAnswer.getText());
            if(response == answer) {
                Correct.setText("Correct!");
            } else {
                Correct.setText("Wrong!");
            }
        } catch(Exception e) {
            Correct.setText("Invalid format");
        }
        }
       });
        layout.getChildren().addAll(reminder, getAnswer, submit, Correct);
    }
    public VBox getQuestions() {
        VBox temp = new VBox();
        for(HBox i: questions) {
            temp.getChildren().add(i);
        }
        return temp;
    }
}

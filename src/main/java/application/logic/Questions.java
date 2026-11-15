package application.logic;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Questions {
    private ArrayList<String> questions = new ArrayList<>();
    private ArrayList<Double> answers = new ArrayList<>();
    public void addQuestion(String question, double answer) {
        questions.add(question);
        answers.add(answer);
    }
    public VBox getQuestions() {
        VBox toGive = new VBox();
        for(int i = 0; i<questions.size(); i++) {
            toGive.getChildren().add(asQuestion(questions.get(i), answers.get(i)));
        }
        return toGive;
    }
    public HBox asQuestion(String question, double answer) {
        HBox toGive = new HBox();
        Button checkAnswer = new Button("Submit Answer");
        Label toAsk = new Label(question);
        Label correct = new Label();
        TextField input = new TextField();
        toGive.setSpacing(20);
        checkAnswer.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent event) {
                try {
                    double response = Double.valueOf(input.getText());
                    if(response == answer) {
                        correct.setText("Correct!");
                    } else {
                        correct.setText("Wrong!");
                    }
                } catch(Exception e) {
                    correct.setText("Invalid format");
                }
            }
        });
        toGive.getChildren().addAll(toAsk, input, checkAnswer, correct);
        return toGive;
    }
    public HBox randomQuestions() {
        HBox toGive = new HBox();
        Random random = new Random();
        int randIndex = random.nextInt(questions.size());
        Label reminder = new Label(questions.get(randIndex));
        Label answer = new Label("" + answers.get(randIndex));
        Label correct = new Label();
        Button checkAnswer = new Button("Submit answer");
        Button newQuestion = new Button("New Question");
        TextField input = new TextField("");
        checkAnswer.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent event) {
                try {
                    double response = Double.valueOf(input.getText());
                    if(response == Double.valueOf(answer.getText())) {
                        correct.setText("Correct!");
                        input.setText("");
                    } else {
                        correct.setText("Wrong!");
                        input.setText("");
                    }
                } catch(Exception e) {
                    correct.setText("Invalid format");
                    input.setText("");
                }
            }
        });
        newQuestion.setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent event) {
                int rand = random.nextInt(questions.size());
                reminder.setText(questions.get(rand));
                answer.setText("" + answers.get(rand));
                correct.setText("");
                input.setText("");
            }
        });
        toGive.getChildren().addAll(reminder, input, checkAnswer, correct, newQuestion);
        toGive.setSpacing(20);
        return toGive;
    }
}
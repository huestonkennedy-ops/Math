package application.logic;

import java.util.ArrayList;

import application.domain.Topic;
import application.domain.Tuple;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class QuestionClass {
    ArrayList<Tuple<Button,Topic>> buttons = new ArrayList<>();
    private HBox inARow = new HBox(); 
    Button button = new Button("Back");
    public QuestionClass() {
        buttons.add(new Tuple<Button,Topic>(new Button("Arithmetic"), Topic.ARITHMETIC));
        buttons.add(new Tuple<Button,Topic>(new Button("Algebra"), Topic.ALGEBRA));
        buttons.add(new Tuple<Button,Topic>(new Button("Trigonometry"), Topic.TRIGONOMETRY));
        buttons.add(new Tuple<Button,Topic>(new Button("Calculus"), Topic.CALCULUS));
        setButtons();
    }
    public void setButton(int index) {
        if(buttons.isEmpty() || index<0 || index>=buttons.size()) {
            return;
        }
        buttons.get(index).getFirst().setOnAction(new EventHandler<ActionEvent>() {
            @Override 
            public void handle(ActionEvent event) {
                inARow.getChildren().clear();
                inARow.getChildren().setAll((buttons.get(index).getSecond().getQuestions().randomQuestions()));
                inARow.getChildren().add(button);
            }
        });
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent event) {
                setButtons();
            }
        });
    }
    public HBox getHorizontal() {
        return inARow;
    }
    public void setButtons() {
        inARow.getChildren().clear();
        for(int i = 0; i<buttons.size(); i++) {
            setButton(i);
            inARow.getChildren().add(buttons.get(i).getFirst());
        }
    }
}
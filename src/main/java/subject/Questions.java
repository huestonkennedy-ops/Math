package subject;

import java.util.ArrayList;
import java.util.Random;

import util.Tuple;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Questions {
    private ArrayList<Tuple<String, String>> questions = new ArrayList<>();
    private Scene back;
    private Stage window;
    private Label question;
    private TextField answer;
    private Button submit;
    private Label correct;
    private Random random = new Random();
    private int index;
    private Button nextQuestion;
    private HBox layout = new HBox();
    public Questions(Scene back, Stage window) {
        this.back = back;
        this.window = window;
        initialize();
    }
    public void addQuestion(String question, String answer) {
        questions.add(new Tuple<String,String>(question + " ", answer));
    }
    public void startRandom() {
        index = random();
        if(index == -1) {
            return;
        }
        question.setText(questions.get(index).getFirst());
        window.setScene(new Scene(layout));
        System.out.println("set");
    }
    private void initialize() {
        question = new Label();
        submit = new Button("Check answer");
        answer = new TextField();
        nextQuestion = new Button("next question");
        correct = new Label();
        nextQuestion.setOnAction((event) -> {
            if(questions.isEmpty()) {
                return;
            }
            index = random();
            question.setText(questions.get(index).getFirst());
            correct.setText("");
            answer.setText("");
        });
        submit.setOnAction((event) -> {
            if(questions.isEmpty()) {
                return;
            }
            if(answer.getText().equals(questions.get(index).getSecond())) {
                correct.setText(" Correct!");
            } else {
                correct.setText(" Wrong!");
            }
        });
        layout.getChildren().addAll(question, answer, submit, nextQuestion, correct);

    }
    private int random() {
        if(questions.isEmpty()) {
            return -1;
        }
        return random.nextInt(questions.size());
    }
}


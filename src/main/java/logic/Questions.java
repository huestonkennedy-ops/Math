package logic;

import java.util.ArrayList;
import java.util.Random;

import util.Tuple;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import subject.Subject;
import user.User;

public final class Questions {
    private ArrayList<Tuple<String, String>> questions = new ArrayList<>();
    private Label question;
    private TextField answer;
    private Button submit;
    private Label correct;
    private Random random = new Random();
    private Button goBack;
    private int index;
    private Button nextQuestion;
    private HBox layout;
    private Scene back;
    private Stage window;
    private Scene group;
    private Subject subject;
    private User user;
    private Users users;

    public Questions() {
    }
    public void addQuestion(String question, String answer) {
        questions.add(new Tuple<String,String>(question + " ", answer));
        goBack = new Button();
    }
    private void startRandom(Stage window, Scene back) {
        this.back = back;
        this.window = window;
        goBack = new Button("back");
        goBack.setOnAction((event) -> {
            this.window.setScene(this.back);
        });
        index = random();
        if(index == -1) {
            return;
        }
        question.setText(questions.get(index).getFirst());
        this.group = new Scene(layout);
    }
    public void start(User user) {
        this.user = user;
        window.setScene(group);
    }
    public void initialize(Stage window, Scene group, Users users) {
        this.users = users;
        layout = new HBox();
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
                user.addCorrect(subject);
                users.writeToFile();
            } else {
                correct.setText(" Wrong!");
                user.addWrong(subject);
                users.writeToFile();
            }
        });
        startRandom(window, group);
        layout.getChildren().addAll(question, answer, submit, nextQuestion, correct, goBack);

    }
    private int random() {
        if(questions.isEmpty()) {
            return -1;
        }
        return random.nextInt(questions.size());
    }
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
}


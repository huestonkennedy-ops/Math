package logic;
import subject.subTopics.Topic;
import user.User;
import util.Tuple;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.util.ArrayList;

import subject.Subject;
public class QuestionGroup {   
    private ArrayList<Tuple<Topic, Questions>> topics;
    private ArrayList<Tuple<Topic, Button>> buttons;
    private Stage window;
    private Scene group;
    private Scene back;
    private Subject subject;
    private Button goBack = new Button();
    private User activeUser;
    private Users users;
    public QuestionGroup( Stage window, Subject subject, Scene back, Users users) {
        this.window = window;
        this.back = back;
        Topic[] topicss = subject.getTopic();
        topics = new ArrayList<>();
        buttons = new ArrayList<>();
        this.users = users;
        for(int i = 0; i<topicss.length; i++) {
            Topic current = topicss[i];
            this.topics.add(new Tuple<Topic,Questions>(current, current.getQuestions()));
            this.buttons.add(new Tuple<Topic,Button>(current, new Button(current.toString())));
        }
        initialize();
    }
    private void setButtons() {
        for(int i = 0; i<buttons.size(); i++) {
            int index = i;
            topics.get(index).getSecond().initialize(window, group, users);
            buttons.get(index).getSecond().setOnAction((event) -> {
                topics.get(index).getSecond().start(activeUser);
            });
        }
        goBack.setOnAction((event) -> {
            window.setScene(back);
        });
    }
    private void initialize() {
        HBox layout = new HBox();
        for(int i = 0; i<buttons.size(); i++){
            layout.getChildren().add(buttons.get(i).getSecond());
        }
        layout.getChildren().add(goBack);
        group = new Scene(layout);
         setButtons();
    }
    public Subject getSubject() {
        return this.subject;
    }
    public void start(User user) {
        activeUser = user;
        window.setScene(group);
    }
}

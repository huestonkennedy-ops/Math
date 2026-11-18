package ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import subject.Subject;
import user.User;

public class UserPage {
    private TopicScreen topic;
    private User user;
    private Button back = new Button("back");
    public UserPage(TopicScreen topic, User user) {
        this.topic = topic;
        this.user = user;
        setButton();
    }
    public Scene getScene() {
        VBox layout = new VBox();
        Label username = new Label(user.getName() + ":");
        layout.getChildren().add(username);
        Subject[] subjects = Subject.values();
        for(int i = 0; i<subjects.length; i++) {
            Label toAdd = new Label(user.getScore(subjects[i]));
            layout.getChildren().add(toAdd);
        }
        layout.getChildren().add(back);
        return new Scene(layout);
    }
    private void setButton() {
        back.setOnAction((event) -> {
            topic.login(user);
        });
    }
}

package ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import subject.Subject;
import user.User;
import javafx.stage.Stage;
import logic.QuestionGroup;
import logic.Users;

public class TopicScreen {
    private Scene login = new Scene(new HBox());
    private Button[] buttons;
    private Subject[] subjects = Subject.values();
    private QuestionGroup[] groups;
    private Button userInfo;
    private Button backToLogin;
    private User user;
    private Stage window;
    private UserPage page;
    private HBox layout = new HBox();
    private Scene scene;
    private Users users;
    public TopicScreen(Stage window, Users users) {
        this.users = users;
        buttons = new Button[subjects.length];
        groups = new QuestionGroup[subjects.length];
        for(int i = 0; i<subjects.length; i++) {
            buttons[i] = new Button(subjects[i].toString());
        }
        backToLogin = new Button("logout");
        userInfo = new Button("See user stats");
        this.window = window;
        page = new UserPage(this, user);
        setButtons();
        setLayout();
        for(int i = 0; i<subjects.length; i++) {
            groups[i] =  new QuestionGroup(window, subjects[i], scene, users);
        }
    }
    private void setUser(User user) {
        this.user = user;
    }
    public void logout() {
        this.user = null;
    }
    public void login(User user) {
        setUser(user);
        window.setScene(scene);
        page = new UserPage(this, user);
    }
    private void setButtons() {
        backToLogin.setOnAction((event) -> {
            window.setScene(login);
        });
        userInfo.setOnAction((event) -> {
            window.setScene(page.getScene());
        });
        for( int i = 0; i<subjects.length; i++){
            int index = i;
            buttons[index].setOnAction((event) -> {
               groups[index].start(user);
            });
        }
    }
    public void setLogin(Scene login) {
        this.login = login;
    }
    private void setLayout() {
        layout = new HBox();
        for(int i = 0; i<buttons.length; i++) layout.getChildren().add(buttons[i]);
        layout.getChildren().add(userInfo);
        layout.getChildren().add(backToLogin);
        scene = new Scene(layout);
    }
}
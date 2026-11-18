package ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import subject.Subject;
import user.User;
import javafx.stage.Stage;

public class TopicScreen {
    private Scene login = new Scene(new HBox());
    private Button[] buttons;
    private Subject[] subjects = Subject.values();
    private Button userInfo;
    private Button backToLogin;
    private User user;
    private Stage window;
    private UserPage page;
    public TopicScreen(Stage window) {
        buttons = new Button[subjects.length];
        for(int i = 0; i<subjects.length; i++) {
            buttons[i] = new Button(subjects[i].toString());
        }
        backToLogin = new Button("logout");
        userInfo = new Button("See user stats");
        this.window = window;
        page = new UserPage(this, user);
        setButtons();
    }
    private void setUser(User user) {
        this.user = user;
    }
    public void logout() {
        this.user = null;
    }
    public void login(User user) {
        setUser(user);
        HBox layout = new HBox();
        for(int i = 0; i<buttons.length; i++) layout.getChildren().add(buttons[i]);
        layout.getChildren().add(userInfo);
        layout.getChildren().add(backToLogin);
        window.setScene(new Scene(layout));
        page = new UserPage(this, user);
    }
    private void setButtons() {
        backToLogin.setOnAction((event) -> {
            window.setScene(login);
        });
        userInfo.setOnAction((event) -> {
            window.setScene(page.getScene());
        });
    }
    public void setLogin(Scene login) {
        this.login = login;
    }
}
package ui;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import logic.Users;

public class LoginScreen {
    private Users users;
    private Stage window;
    private TopicScreen topic;
    public LoginScreen(Users users, Stage window) {
        this.users = users;
        users.read();
        this.window = window;
        topic = new TopicScreen(window);
    }
    public void getLogin() {
        GridPane layout = new GridPane();
        //Formatting the layout
        layout.setAlignment(Pos.CENTER);
        Label instruction = new Label("Type in your username and password");
        TextField user = new TextField();
        TextField pass = new PasswordField();
        Button checkDetails = new Button("login");
        Button createUser = new Button("Create new user");
        Label error = new Label("");
        HBox loginAndCreate = new HBox();
        loginAndCreate.getChildren().addAll(checkDetails, createUser);
        layout.add(instruction, 0, 0);
        layout.add(user, 0, 1);
        layout.add(pass, 0, 2);
        layout.add(loginAndCreate, 0, 3);
        layout.add(error, 0, 4);
        //Giving function to my buttons
        checkDetails.setOnAction((event) ->{
            try {
                users.setActiveUser(user.getText(), pass.getText());
                user.setText("");
                pass.setText("");
                topic.login(users.activeUser());
            } catch(Exception e) {
                error.setText("User not found");
            }
        });
        createUser.setOnAction((event) -> {
            if(users.hasUser(user.getText())) {
                error.setText("User already exists");
            } else {
                users.createUser(user.getText(), pass.getText());
                user.setText("");
                pass.setText("");
                users.writeToFile();
                topic.login(users.activeUser());
            }
        });
        Scene scene = new Scene(layout);
        topic.setLogin(scene);
        window.setScene(scene);
    }
}

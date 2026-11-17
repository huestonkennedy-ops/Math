package user;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import subject.Subject;
import util.Tuple;

public class User {
    private String name;
    private String password;
    private ArrayList<Score> scores;
    public User(String name, String password) {
        this.name = name;
        this.password = password;
        for(Subject i: Subject.values()) {
            scores.add(new Score(i));
        }
    }
    public String sanitize(String toSanitize) {
        return toSanitize.trim().toLowerCase();
    }
}

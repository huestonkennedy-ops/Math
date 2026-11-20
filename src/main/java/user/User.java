package user;

import java.util.ArrayList;
import subject.Subject;


public class User {
    private String name;
    private String password;
    private ArrayList<Score> scores = new ArrayList<>();
    public User(String name, String password) {
        this.name = name;
        this.password = password;
        for(Subject i: Subject.values()) {
            scores.add(new Score(i));
        }
    }
    public void addCorrect(Subject subject) {
        getSubject(subject).addOne();
    }
    private Score getSubject(Subject subject) {
        for(Score i: scores) {
            if(i.getSubject().sameAs(subject)) {
                return i;
            }
        }
        System.out.println("Subject not found");
        return new Score(subject);
    }
    public void addWrong(Subject subject) {
        getSubject(subject).addWrong();
    }
    @Override public String toString() {
        StringBuilder toGive = new StringBuilder();
        toGive.append(name + "," + password + ",");
        for(Score i: scores) {
            toGive.append(i.toString() + ",");
        }
        return toGive.toString();
    }
    public boolean unlock(String user, String password) {
        if(name.equals(user) && this.password.equals(password)) {
            return true;
        }
        return false;
    }
    public void setScore(int score, int outOf, Subject subject) {
        getSubject(subject).setScore(score, outOf);
    } 
    public String getName() {
        return this.name;
    }
    public String getScore(Subject subject) {
        return getSubject(subject).getScore();
    }
    public String getPassword() {
        return this.password;
    }
}

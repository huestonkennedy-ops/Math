package user;
import subject.Subject;

public class Score {
    private Subject subject;
    private int correct;
    private int outOf;
    public Score(Subject subject) {
        this(subject, 0, 0);
    }
    public Score(Subject subject, int correct, int outOf) {
        this.subject = subject;
        this.correct = correct;
        this.outOf = outOf;
    }
    public void addOne() {
        correct += 1;
        outOf += 1;
    }
    public void addWrong() {
        outOf += 1;
    }
    public Subject getSubject() {
        return subject;
    }
    public int correct() {
        return correct;
    }
    public int outOf() {
        return outOf;
    }
}
package subject.subTopics;
import subject.Subject;
import logic.Questions;

public interface Topic {
    public String toString();
    public Subject getSubject();
    public Questions getQuestions();

}

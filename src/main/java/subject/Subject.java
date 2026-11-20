package subject;
import subject.subTopics.*;

public enum Subject {
    MATH("Math"),SCIENCE("Science"),HISTORY("History"),GEOGRAPHY("Geography"),FRENCH("French"),COMPUTERSCIENCE("Computer science");
    private String subject;
    private Subject(String subject) {
        this.subject = subject;
    }
    public String toString() {
        return subject;
    }
    public Topic[] getTopic() {
        switch(this) {
            case MATH: return Maths.values();
            case SCIENCE: return Science.values();
            case GEOGRAPHY: return Geography.values();
            case HISTORY: return History.values();
            case FRENCH: return French.values();
            case COMPUTERSCIENCE: return ComputerScience.values();
            default: return null;
        }
    }
    public boolean sameAs(Object object) {
        if(!(object instanceof Subject)) {
            return false;
        }
        Subject toCompare = (Subject) object;
        if(toCompare.toString().equals(this.toString())) {
            return true;
        }
        return false;
    }
}

package subject;

public enum Subject {
    MATH("Math"),SCIENCE("Science"),HISTORY("History"),GEOGRAPHY("Geography"),FRENCH("French"),COMPUTERSCIENCE("Computer science");
    private String subject;
    private Subject(String subject) {
        this.subject = subject;
    }
    public String toString() {
        return subject;
    }

}

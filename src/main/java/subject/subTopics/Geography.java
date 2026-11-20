package subject.subTopics;
import logic.Questions;
import subject.Subject;

public enum Geography implements Topic{
    ARITHMETIC("Canadian capitals"),ALGEBRA("Algebra"),GEOMETRY("Geometry"),TRIGONOMETRY("Trigonometry"),CALCULUS("Calculus");
    private String subject;
    private Questions questions;
    private Geography(String subject) {
        this.subject = subject;
        this.questions = new Questions();
        
    }
    @Override public String toString() {
        return this.subject;
    }
    static {
        ARITHMETIC.questions.addQuestion("What is 8x4", String.valueOf(8*4));
        ARITHMETIC.questions.addQuestion("What is 5^3", String.valueOf(125));
        ARITHMETIC.questions.addQuestion("What is 124 - 89", String.valueOf(124-89));
        ARITHMETIC.questions.addQuestion("What is 56 + 78", String.valueOf(56+78));
        ARITHMETIC.questions.addQuestion("What is 20/3? Round to two decimal places", String.valueOf(6.67));
        ALGEBRA.questions.addQuestion("3x = 2. Solve for x and round to two decimal places", String.valueOf(0.67));
         ALGEBRA.questions.addQuestion("3x + 2y = 6, 7x-2y = 7. Solve for x and round to two decimal places", String.valueOf(1.3));
         GEOMETRY.questions.addQuestion("What is the area of a rectangle with height 4 and width 2", String.valueOf(8));
         TRIGONOMETRY.questions.addQuestion("What is cos(0)", "1");
         CALCULUS.questions.addQuestion("What is the derivative of 3x^2 + 8x", "6x + 8");
    }
    @Override public Subject getSubject() {
        return Subject.GEOGRAPHY;
    }
    @Override public Questions getQuestions() {
        this.questions.setSubject(getSubject());
        return this.questions;
    }
}

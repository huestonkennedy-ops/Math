package subject.subTopics;

import logic.Questions;
import subject.Subject;

public enum French implements Topic{
    ANNOYING("ANNOYING"),ALGEBRA("Algebra"),GEOMETRY("Geometry"),TRIGONOMETRY("Trigonometry"),CALCULUS("Calculus");
    private String subject;
    private Questions questions;
    private French(String subject) {
        this.subject = subject;
        this.questions = new Questions();
        
    }
    @Override public String toString() {
        return this.subject;
    }
    static {
        ANNOYING.questions.addQuestion("What is 8x4", String.valueOf(8*4));
        ANNOYING.questions.addQuestion("What is 5^3", String.valueOf(125));
        ANNOYING.questions.addQuestion("What is 124 - 89", String.valueOf(124-89));
        ANNOYING.questions.addQuestion("What is 56 + 78", String.valueOf(56+78));
        ANNOYING.questions.addQuestion("What is 20/3? Round to two decimal places", String.valueOf(6.67));
        ALGEBRA.questions.addQuestion("3x = 2. Solve for x and round to two decimal places", String.valueOf(0.67));
         ALGEBRA.questions.addQuestion("3x + 2y = 6, 7x-2y = 7. Solve for x and round to two decimal places", String.valueOf(1.3));
         GEOMETRY.questions.addQuestion("What is the area of a rectangle with height 4 and width 2", String.valueOf(8));
         TRIGONOMETRY.questions.addQuestion("What is cos(0)", "1");
         CALCULUS.questions.addQuestion("What is the derivative of 3x^2 + 8x", "6x + 8");
    } 
    @Override public Subject getSubject() {
        return Subject.MATH;
    }
    @Override public Questions getQuestions() {
        this.questions.setSubject(getSubject());
        return this.questions;
    }
}

package application.domain;

import application.logic.Questions;

public enum Topic {
    ARITHMETIC("ari"), ALGEBRA("alg"), CALCULUS("calc"), TRIGONOMETRY("trig");
    private Questions questions = new Questions();
    private Topic(String abr) {
        if(abr.equals("ari")) {
            questions.addQuestion("What is 5 x 2?",  5*2);
            questions.addQuestion("What is 5 / 2?",  5.0/2);
            questions.addQuestion("What is 81 + 56?",  81 + 56);
            questions.addQuestion("What is 78 - 65", 78 - 65);
            questions.addQuestion("What is 6^3", 216);
            questions.addQuestion("What is 8 x 3", 24);
        } else if(abr.equals("alg")) {
            questions.addQuestion("3x = 2. Solve for x", 3.0/2);
            questions.addQuestion("3x^2 - 5x + 2 = 9. Solve for x and round to two decimal places. Give the larger answer", 2.57);
            questions.addQuestion("What is the degree of this polynomial? 3x^9 + 6x^4 - x^2 = 6x^7", 9);
            questions.addQuestion("Solve for x = 3, y = 2. 3yx^2 + 2y^2 - x", 57);
        } else if(abr.equals("calc")) {
            questions.addQuestion("What is the second derivative of 2x^2", 4);
            questions.addQuestion("What is the integral from 2 to 5 of x^2 dx?", 39);
            questions.addQuestion("What is e^(ipi)+1", 0);
            questions.addQuestion("What is the limit as x goes to 3 of (x^2-9)/(x-3)", 6);
        } else if(abr.equals("trig")) {
            questions.addQuestion("evaluate sin(30). Round to two decimal places", 0.5);
            questions.addQuestion("Evaluate cos(30). Round to two decimal places", 0.87);
            questions.addQuestion("Evaluate tan(45). Round to two decimal places", 1);
            questions.addQuestion("Evaluate cos(60). Round to two decimal places", 0.5);
        }
    }
    public Questions getQuestions() {
        if(this != this.ARITHMETIC) {
            return questions;
        }
        return new Questions();
    }

}
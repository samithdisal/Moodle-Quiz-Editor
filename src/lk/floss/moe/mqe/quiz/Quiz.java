package lk.floss.moe.mqe.quiz;

import java.util.ArrayList;

public class Quiz {
	
	ArrayList<Question> questions = new ArrayList<Question>();
	
	public ArrayList<Question> getQuestions() {
		return questions;
	}
	
	public Question addTrueFalseQuestion(String name, String text, boolean answer, String fbTrue, String fbFalse) {
		TrueFalseQuestion question = new TrueFalseQuestion(name, text, answer, fbTrue, fbFalse);
		return addTrueFalseQuestion(question);
	}
        
        public Question addTrueFalseQuestion(TrueFalseQuestion question) {
		questions.add(question);
		return question;
	}
        
        public Question addShortAnswerQuestion(ShortAnswerQuestion q) {
            questions.add(q);
            return q;
        }
}

package lk.floss.moe.mqe.quiz;

import java.util.ArrayList;

public class ShortAnswerQuestion extends Question {
	
	public class ShortAnswer {
		String answer;
		String feedback;
		int amount;
		
		public ShortAnswer() {
		}

		public ShortAnswer(String answer, String feedback, int amount) {
			super();
			this.answer = answer;
			this.feedback = feedback;
			this.amount = amount;
		}

		public String getAnswer() {
			return answer;
		}

		public void setAnswer(String answer) {
			this.answer = answer;
		}

		public String getFeedback() {
			return feedback;
		}

		public void setFeedback(String feedback) {
			this.feedback = feedback;
		}

		public int getAmount() {
			return amount;
		}

		public void setAmount(int amount) {
			this.amount = amount;
		}
		
		
		
	}

	@Override
	public QuestionType getType() {
		return QuestionType.ShortAnswer;
	}
	
	ArrayList<ShortAnswer> answers = new ArrayList<ShortAnswerQuestion.ShortAnswer>();

	public ShortAnswerQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShortAnswerQuestion(String name, String questionText) {
		super(name, questionText);
		// TODO Auto-generated constructor stub
	}
	
	public void addAnswer(ShortAnswer answer) {
		answers.add(answer);
	}
	
	public void addAnswer(String answer, String feedback, int amount) {
		addAnswer(new ShortAnswer(answer, feedback, amount));
	}

	public ArrayList<ShortAnswer> getAnswers() {
		return answers;
	}

	public void setAnswers(ArrayList<ShortAnswer> answers) {
		this.answers = answers;
	}

}

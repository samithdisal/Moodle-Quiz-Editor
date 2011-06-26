package lk.floss.moe.mqe.quiz;

public abstract class Question {
	
	public enum QuestionType {
		TrueFalse("True False"),
		ShortAnswer("Short Answer");
		private String name;
		private QuestionType(String name) {
			this.name = name;
		}
		public String getName() {
			return name;
		}
	}
	
	private String name;
	private String questionText;
	
	public abstract QuestionType getType();
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getQuestionText() {
		return questionText;
	}
	
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	
	public Question() {
	}

	public Question(String name, String questionText) {
		super();
		this.name = name;
		this.questionText = questionText;
	}
	
	
}

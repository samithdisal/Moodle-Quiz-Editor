package lk.floss.moe.mqe.quiz;

public class TrueFalseQuestion extends Question {

    @Override
    public QuestionType getType() {
        return QuestionType.TrueFalse;
    }
    private boolean correct;
    private String fbTrue;
    private String fbFalse;

    public String getFbFalse() {
        return fbFalse;
    }

    public void setFbFalse(String fbFalse) {
        this.fbFalse = fbFalse;
    }

    public String getFbTrue() {
        return fbTrue;
    }

    public void setFbTrue(String fbTrue) {
        this.fbTrue = fbTrue;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public TrueFalseQuestion(String name, String questionText, boolean answer, String fbTrue, String fbFalse) {
        super(name, questionText);
        this.correct = answer;
        this.fbTrue = fbTrue;
        this.fbFalse = fbFalse;
    }
}

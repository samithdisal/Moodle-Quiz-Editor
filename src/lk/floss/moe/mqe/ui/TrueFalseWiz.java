/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.floss.moe.mqe.ui;

/**
 *
 * @author sam
 */
public class TrueFalseWiz extends QuestionWiz {
    
    TrueFalseWizPage page;

    public TrueFalseWiz(MainFrame mf) {
        super(mf);
        setTitle("Add New True False Question");
        page = new TrueFalseWizPage();
        contentPanel.add(page);
        pack();
    }

    @Override
    protected void cancelWiz() {
        setVisible(false);
        dispose();
    }

    @Override
    protected void finishWiz() {
        
        String questionName = page.questionNameField.getText();
        String questionText = page.questionTextPane.getText();
        boolean answer = page.statementIsTrueCB.isSelected();
        String fbTrue = page.fbTrueTextPane.getText();
        String fbFalse = page.fbFalseTextPane.getContentType();
        
        mf.quiz.addTrueFalseQuestion(questionName, questionText, answer, fbTrue, fbFalse);
        mf.updateModel();
        
        setVisible(false);
        dispose();
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.floss.moe.mqe.ui;

import lk.floss.moe.mqe.quiz.ShortAnswerQuestion;

/**
 *
 * @author sam
 */

public class ShortAnswersWiz extends QuestionWiz {
    
    ShortAnswerWizPage page;

    public ShortAnswersWiz(MainFrame mf) {
        super(mf);
        page = new ShortAnswerWizPage();
        contentPanel.add(page);
        pack();
        setTitle("Add new Short Answer Question");
    }

    
    
    
    @Override
    protected void cancelWiz() {
        setVisible(false);
        dispose();
    }

    @Override
    protected void finishWiz() {
        ShortAnswerQuestion q = new ShortAnswerQuestion();
        q.setName(page.questionNameField.getText());
        q.setQuestionText(page.questionTextPane.getText());
        for(ShortAnswerPanel panel: page.answerPanels) {
            panel.addAnswerToQuestion(q);
        }
        mf.quiz.addShortAnswerQuestion(q);
        mf.updateModel();
        setVisible(false);
        dispose();
    }
    
}

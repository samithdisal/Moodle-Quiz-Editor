/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * QuestionWiz.java
 *
 * Created on Jun 23, 2011, 6:23:39 AM
 */
package lk.floss.moe.mqe.ui;

import javax.swing.JOptionPane;

/**
 *
 * @author sam
 */
public abstract class QuestionWiz extends javax.swing.JDialog {
    
    MainFrame mf;

    /** Creates new form QuestionWiz */
    public QuestionWiz(MainFrame mf) {
        super(mf, true);
        this.mf = mf;
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        controlsPanel = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        finishButton = new javax.swing.JButton();
        contentPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        controlsPanel.add(cancelButton);

        finishButton.setText("Finish");
        finishButton.setMargin(new java.awt.Insets(2, 80, 2, 80));
        finishButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishButtonActionPerformed(evt);
            }
        });
        controlsPanel.add(finishButton);

        getContentPane().add(controlsPanel, java.awt.BorderLayout.PAGE_END);

        contentPanel.setLayout(new java.awt.BorderLayout());
        getContentPane().add(contentPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        if(JOptionPane.showConfirmDialog(this, "Are you sure you want to cancel the wizard", "Cancel Wizard", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION) {
            this.cancelWiz();
        }
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void finishButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishButtonActionPerformed
        this.finishWiz();
    }//GEN-LAST:event_finishButtonActionPerformed
    protected abstract void cancelWiz();
    protected abstract void finishWiz();
    
    public void run() {
        setVisible(true);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    protected javax.swing.JButton cancelButton;
    protected javax.swing.JPanel contentPanel;
    private javax.swing.JPanel controlsPanel;
    protected javax.swing.JButton finishButton;
    // End of variables declaration//GEN-END:variables
}

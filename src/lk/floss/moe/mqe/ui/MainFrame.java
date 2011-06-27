/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MainFrame.java
 *
 * Created on Jun 22, 2011, 9:32:27 PM
 */
package lk.floss.moe.mqe.ui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.AbstractTableModel;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import lk.floss.moe.mqe.MoodleXML;
import lk.floss.moe.mqe.MoodleXMLIO;
import lk.floss.moe.mqe.quiz.Question;
import lk.floss.moe.mqe.quiz.Quiz;
import org.w3c.dom.Document;

/**
 *
 * @author sam
 */
public class MainFrame extends javax.swing.JFrame {

    Document document;
    Quiz quiz = new Quiz();
    String path;

    protected class QuizTableModel extends AbstractTableModel {

        @Override
        public String getColumnName(int column) {
            switch(column) {
                case 0: return "Question Name";
                case 1: return "Question Type";
                case 2: return "Edit";
                case 3: return "Delete";
                default: return super.getColumnName(column);
            }
        }
        
        

        @Override
        public int getRowCount() {
            return quiz.getQuestions().size();
        }

        @Override
        public int getColumnCount() {
            return 4;
        }

        @Override
        public Object getValueAt(int i, int f) {
            final Question question = quiz.getQuestions().get(i);
            Object res = null;
            switch (f) {
                case 0:
                    res = question.getName();
                    break;
                case 1:
                    res = question.getType().getName();
                    break;
                case 2:
                    res = "Edit";
                    break;
                case 3:
                    res = "Delete";
                    break;
                default:
                    res = "Unknown";
            }
            return res;
        }
    }
    
    QuizTableModel quizTableModel = new QuizTableModel();

    public void editQuestion(Question question) {
    }

    public void deleteQuestion(Question question) {
    }

    public final void updateModel() {
        try {
            document = MoodleXML.generateXML(quiz);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        questionsTable.updateUI();



    }

    /** Creates new form MainFrame */
    public MainFrame() {
        initComponents();
        updateModel();
    }

    public void run() {
        setVisible(true);
    }

    public void save() {
        if (path == null) {
            saveAs();
        }
        updateModel();
        try {
            MoodleXMLIO.saveToFile(path, document);
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveAs() {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Moodle XML", "xml");
        chooser.setFileFilter(filter);
        int res = chooser.showSaveDialog(this);
        if (res == JFileChooser.APPROVE_OPTION) {
            this.path = chooser.getSelectedFile().getAbsolutePath();
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainToolBar = new javax.swing.JToolBar();
        trueFalseButton = new javax.swing.JButton();
        shortAnswerButton = new javax.swing.JButton();
        tabbedPane = new javax.swing.JTabbedPane();
        questionsTab = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        questionsTable = new javax.swing.JTable();
        previewTab = new javax.swing.JPanel();
        mainMenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newQuizMI = new javax.swing.JMenuItem();
        openQuizMI = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        saveMI = new javax.swing.JMenuItem();
        saveAsMI = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        exitMI = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        heloMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Moodle Quiz Editor");

        mainToolBar.setRollover(true);
        mainToolBar.setToolTipText("Toolbox");

        trueFalseButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/floss/moe/mqe/resource/image/pix/i/questions.gif"))); // NOI18N
        trueFalseButton.setText("True False");
        trueFalseButton.setFocusable(false);
        trueFalseButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        trueFalseButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        trueFalseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trueFalseButtonActionPerformed(evt);
            }
        });
        mainToolBar.add(trueFalseButton);

        shortAnswerButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/floss/moe/mqe/resource/image/pix/i/questions.gif"))); // NOI18N
        shortAnswerButton.setText("Short Answer");
        shortAnswerButton.setFocusable(false);
        shortAnswerButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        shortAnswerButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        shortAnswerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                shortAnswerButtonActionPerformed(evt);
            }
        });
        mainToolBar.add(shortAnswerButton);

        getContentPane().add(mainToolBar, java.awt.BorderLayout.PAGE_START);

        tabbedPane.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);

        questionsTab.setLayout(new java.awt.BorderLayout());

        questionsTable.setModel(quizTableModel);
        questionsTable.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(questionsTable);
        questionsTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        questionsTab.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        tabbedPane.addTab("Questions", questionsTab);

        javax.swing.GroupLayout previewTabLayout = new javax.swing.GroupLayout(previewTab);
        previewTab.setLayout(previewTabLayout);
        previewTabLayout.setHorizontalGroup(
            previewTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 546, Short.MAX_VALUE)
        );
        previewTabLayout.setVerticalGroup(
            previewTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );

        tabbedPane.addTab("Preview", previewTab);

        getContentPane().add(tabbedPane, java.awt.BorderLayout.CENTER);
        tabbedPane.getAccessibleContext().setAccessibleName("QuestionsTab");

        fileMenu.setText("File");

        newQuizMI.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        newQuizMI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/floss/moe/mqe/resource/image/pix/adv.gif"))); // NOI18N
        newQuizMI.setText("New Quiz");
        fileMenu.add(newQuizMI);

        openQuizMI.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openQuizMI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/floss/moe/mqe/resource/image/pix/i/open.gif"))); // NOI18N
        openQuizMI.setText("Open Quiz");
        fileMenu.add(openQuizMI);
        fileMenu.add(jSeparator1);

        saveMI.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveMI.setText("Save");
        saveMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveMIActionPerformed(evt);
            }
        });
        fileMenu.add(saveMI);

        saveAsMI.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        saveAsMI.setText("Save As...");
        fileMenu.add(saveAsMI);
        fileMenu.add(jSeparator2);

        exitMI.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        exitMI.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lk/floss/moe/mqe/resource/image/pix/t/delete.gif"))); // NOI18N
        exitMI.setText("Exit");
        fileMenu.add(exitMI);

        mainMenuBar.add(fileMenu);

        editMenu.setText("Edit");
        mainMenuBar.add(editMenu);

        heloMenu.setText("Help");
        mainMenuBar.add(heloMenu);

        setJMenuBar(mainMenuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void trueFalseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trueFalseButtonActionPerformed
        TrueFalseWiz wiz = new TrueFalseWiz(this);
        wiz.run();
    }//GEN-LAST:event_trueFalseButtonActionPerformed

    private void saveMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveMIActionPerformed
        save();
    }//GEN-LAST:event_saveMIActionPerformed

    private void shortAnswerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_shortAnswerButtonActionPerformed
        ShortAnswersWiz wiz = new ShortAnswersWiz(this);
        wiz.run();
    }//GEN-LAST:event_shortAnswerButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMI;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu heloMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenuBar mainMenuBar;
    private javax.swing.JToolBar mainToolBar;
    private javax.swing.JMenuItem newQuizMI;
    private javax.swing.JMenuItem openQuizMI;
    private javax.swing.JPanel previewTab;
    private javax.swing.JPanel questionsTab;
    private javax.swing.JTable questionsTable;
    private javax.swing.JMenuItem saveAsMI;
    private javax.swing.JMenuItem saveMI;
    private javax.swing.JButton shortAnswerButton;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JButton trueFalseButton;
    // End of variables declaration//GEN-END:variables
}

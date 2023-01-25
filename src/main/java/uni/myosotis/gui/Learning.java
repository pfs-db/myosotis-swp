package uni.myosotis.gui;

import uni.myosotis.controller.Controller;
import uni.myosotis.objects.LearnSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Learning extends JFrame{

    private final Controller controller;
    private final LearnSystem learnsystem;
    private JPanel contentPane;
    private JProgressBar learnProgressBar;
    private JLabel questionLabel;
    private JButton answerButton;
    private JButton wrongAnswerButton;
    private JButton rightAnswerButton;
    private JLabel answerLabel;

    /**
     * Creates a new Learning-Window.
     *
     * @param controller The controller.
     * @param learnsystem The learnsystem.
     */
    public Learning(Controller controller, LearnSystem learnsystem) {
        this.learnsystem = learnsystem;
        this.controller = controller;
        this.learnProgressBar.setMinimum(0);

        setContentPane(contentPane);
        setTitle("Karteikarten");
        pack();
        setMinimumSize(getSize());
        setSize(800, 600);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });
        this.answerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        this.rightAnswerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        this.wrongAnswerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
    private void onCancel() {
        //controller.updateLearnsystem(learnsystem);
        dispose();
    }
}

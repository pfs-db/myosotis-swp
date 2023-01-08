package uni.myosotis.gui;

import uni.myosotis.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainMenu extends JDialog {
    private JPanel contentPane;

    private final transient Controller controller;

    public MainMenu(final Controller controller) {
        this.controller = controller;
        setContentPane(contentPane);
        setModal(true);
        setTitle("Myosotis");
        createMenu();
        setMinimumSize(new Dimension(800, 600));

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });
    }

    /**
     * Creates the Menu of the MainMenu-Window.
     */
    private void createMenu() {
        final JMenuBar menuBar = new JMenuBar();
        final JMenu indexcardMenu = new JMenu("Karteikarte");
        final JMenuItem createIndexcard = new JMenuItem("Erstellen");
        createIndexcard.addActionListener(e -> controller.createIndexcard());
        final JMenuItem editIndexcard = new JMenuItem("Bearbeiten");
        editIndexcard.addActionListener(e -> controller.editIndexcard());
        final JMenuItem deleteIndexcard = new JMenuItem("Entfernen");
        deleteIndexcard.addActionListener(e -> controller.deleteIndexcard());
        indexcardMenu.add(createIndexcard);
        indexcardMenu.addSeparator();
        indexcardMenu.add(editIndexcard);
        indexcardMenu.addSeparator();
        indexcardMenu.add(deleteIndexcard);
        menuBar.add(indexcardMenu);

        setJMenuBar(menuBar);
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    /**
     * Displays the Dialog to create a new Indexcard and delegate this exercise to the controller.
     */
    public void displayCreateIndexcard() {
        final CreateIndexcard createIndexcard = new CreateIndexcard(controller);
        createIndexcard.pack();
        createIndexcard.setMinimumSize(createIndexcard.getSize());
        createIndexcard.setLocationRelativeTo(this);
        createIndexcard.setVisible(true);
    }
    public void displayEditIndexcard() {
        final EditIndexcard editIndexcard = new EditIndexcard(controller);
        editIndexcard.pack();
        editIndexcard.setMinimumSize(editIndexcard.getSize());
        editIndexcard.setLocationRelativeTo(this);
        editIndexcard.setVisible(true);
    }

    public void displayDeleteIndexcard() {
        /*
        final DeleteIndexcard deleteIndexcard = new DeleteIndexcard(controller);
        deleteIndexcard.pack();
        deleteIndexcard.setMinimumSize(deleteIndexcard.getSize());
        deleteIndexcard.setLocationRelativeTo(this);
        deleteIndexcard.setVisible(true);
        */
    }
}

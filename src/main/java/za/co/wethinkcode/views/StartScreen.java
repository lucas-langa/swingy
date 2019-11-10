package za.co.wethinkcode.views;

import javax.swing.*;
import java.awt.event.*;

public class StartScreen extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton createHero;
    private JButton selectExistingHero;
    private JButton buttonCancel;

    public StartScreen() {
        setContentPane(contentPane);
        setModal(true);
//        getRootPane().setDefaultButton(buttonOK);

        createHero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createHero();
            }
        });

        selectExistingHero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectExistingHero();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//        addWindowListener(new WindowAdapter() {
//            public void windowClosing(WindowEvent e) {
//                selectExistingHero();
//            }
//        });/

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                selectExistingHero();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void createHero() {
        // add your code here
        JOptionPane.showMessageDialog(contentPane,"you clicked something");
        dispose();
    }

    private void selectExistingHero() {
        // add your code here if necessary
        JOptionPane.showMessageDialog(contentPane,"have a nice day");
        dispose();
    }

    public static void main(String[] args) {
        StartScreen dialog = new StartScreen();
        dialog.pack();
        dialog.setSize(400,300);
        dialog.setVisible(true);
        System.exit(0);
    }
}

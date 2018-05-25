import javax.swing.*;
import java.awt.*;


public class bestGUI extends JFrame{
    private JTextArea Logs;
    private JTextArea characterInfo;
    private JTextField rules;
    private JPanel mainPanel;
    private JButton eatButton;
    private JButton mathButton;
    private JButton sleepButton;
    private JTextField Time;

    bestGUI() {
        super("bestGUI ever 10/10");
        setSize(640, 480);
        setResizable(false);
        setContentPane(mainPanel);
        setVisible(true);
        characterInfo.setEditable(false);
        characterInfo.setLineWrap(true);
        characterInfo.setFont(new Font("ComicSans", Font.BOLD ,15));
        rules.setEditable(false);
        Logs.setLineWrap(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    void updateCharacter(String s) {
        characterInfo.setText(s);
    }
    void newAction(String s) {
        Logs.setText(s);
    }
    void updateTime(String s) {
        Time.setText(s);
    }
}

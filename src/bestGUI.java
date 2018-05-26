import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class bestGUI extends JFrame {
    private JTextArea Logs;
    private JTextArea characterInfo;
    private JTextArea rules;
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
        characterInfo.setFont(new Font("ComicSans", Font.BOLD, 15));
        rules.setEditable(false);
        Logs.setLineWrap(true);
        rules.setLineWrap(true);
        rules.setText("Now the game begins" + "\n" +
                "Since this moment you are a student of NSU, congratulations(?)" + "\n" +
                "Studying here could be really fun, but there is no fun, if there is no rules" + "\n" +
                "1. Everyday you wake up at 7:00, so please take your time to rest" + "\n" +
                "2. Semester lasts for 120 days, spend them wisely" + "\n" +
                "3. To eat something and restore your health click -eat" + "\n" +
                "4. To end the day and get some rest click -sleep" + "\n" +
                "5. If it is the studying time (8:00-16:00 and 20:00-24:00) -math to study Math");
        buttonListener ultimateListener = new buttonListener();
        eatButton.addActionListener(ultimateListener);
        sleepButton.addActionListener(ultimateListener);
        mathButton.addActionListener(ultimateListener);

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


    class buttonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == eatButton) {
                Main.timer.updateTime(1);
                Main.player.Heal(20);
            }

            if (e.getSource() == mathButton) {
                Main.player.StudyMath(Main.timer);
            }

            if (e.getSource() == sleepButton) {
                Main.timer.endDay(Main.player);
            }
        }
    }
}

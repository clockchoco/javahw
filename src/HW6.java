import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HW6 {
    private static final String[] CARD_NAMES = {"스페이드", "다이아몬드", "클로버", "하트"};
    private static final int NUM_CARDS = 4;
    private static final int PANEL_WIDTH = 300;
    private static final int PANEL_HEIGHT = 100;

    private JLabel[] labels;
    private JPanel panel;

    public HW6() {
        JFrame frame = new JFrame("Card Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(PANEL_WIDTH, PANEL_HEIGHT);

        labels = new JLabel[NUM_CARDS];
        panel = new JPanel();

        for (int i = 0; i < NUM_CARDS; i++) {
            labels[i] = new JLabel();
            panel.add(labels[i]);
        }

        frame.add(panel);
        frame.setVisible(true);

        startGame();
    }

    private void startGame() {
        Timer timer = new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateLabels();
            }
        });
        timer.start();
    }

    private void updateLabels() {
        int randomIndex = (int) (Math.random() * NUM_CARDS);
        for (int i = 0; i < NUM_CARDS; i++) {
            labels[i].setText(CARD_NAMES[randomIndex]);
        }

        boolean allSame = true;
        for (int i = 1; i < NUM_CARDS; i++) {
            if (!labels[i].getText().equals(labels[0].getText())) {
                allSame = false;
                break;
            }
        }

        if (allSame) {
            JOptionPane.showMessageDialog(panel, "축하합니다!!");
        } else {
            JOptionPane.showMessageDialog(panel, "아쉽군요.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HW6());
    }
}

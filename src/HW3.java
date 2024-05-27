import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.*;


public class HW3 extends JFrame {
    public HW3() {
        setTitle("Money Changer with CheckBox");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new MyPanel());
        setSize(300, 300);
        setVisible(true);
    }
    public static void main(String[] args) {
        new HW3();
    }
}
class MyPanel extends JPanel {
    private int[] unit = {50000, 10000, 1000, 500, 100, 50, 10};
    private String[] text = {"오만원", "만원", "천원", "500원", "100원", "50원", "10원", "1원"};
    private JTextField source;
    private JTextField[] textField = new JTextField[8];
    private JCheckBox[] checkBox = new JCheckBox[7];
    private final int LastTextFieldIdx = 7;

    public MyPanel() {
        setBackground(Color.PINK);
        setLayout(null);
        JLabel la = new JLabel("금액");
        la.setHorizontalAlignment(JLabel.RIGHT);
        la.setSize(50, 20);
        la.setLocation(20, 20);
        add(la);
        source = new JTextField(30);
        source.setSize(100, 20);
        source.setLocation(100, 20);
        add(source);
        JButton calcBtn = new JButton("계산");
        calcBtn.setSize(70, 20);
        calcBtn.setLocation(210, 20);
        add(calcBtn);
        for (int i = 0; i < text.length; i++) {
            la = new JLabel(text[i]);
            la.setHorizontalAlignment(JLabel.RIGHT);
            la.setSize(50, 20);
            la.setLocation(50, 50 + i * 20);
            add(la);
            textField[i] = new JTextField(30);
            textField[i].setSize(70, 20);
            textField[i].setLocation(120, 50 + i * 20);
            add(textField[i]);
        }
        for (int i = 0; i < checkBox.length; i++) {
            checkBox[i] = new JCheckBox("", true);
            checkBox[i].setOpaque(false);
            checkBox[i].setHorizontalAlignment(JLabel.CENTER);
            checkBox[i].setSize(30, 20);
            checkBox[i].setLocation(200, 50 + i * 20);
            add(checkBox[i]);
        }
        calcBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String strMoney = source.getText();
                if (strMoney.length() == 0) return;
                int money = Integer.parseInt(strMoney);
                int res;
                for (int i = 0; i < unit.length; i++) {
                    if (!checkBox[i].isSelected()) {
                        textField[i].setText("0");
                        continue;
                    }
                    res = money / unit[i];
                    textField[i].setText(Integer.toString(res));
                    if (res > 0) {
                        money = money % unit[i];
                    }
                }
                textField[LastTextFieldIdx].setText(Integer.toString(money));

            }
        });
    }
}



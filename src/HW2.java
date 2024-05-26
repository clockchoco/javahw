import javax.swing.*;
import java.awt.*;
//import java.awt.event.*;

public class HW2 extends JFrame {
    private JButton countBtn = new JButton("test button");
    private JLabel countLabel = new JLabel("0");
    private int counter = 0;
    public HW2() {
        setTitle("CheckBox");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());
        JCheckBox deactiveBtn = new JCheckBox("버튼 비활성화");
        JCheckBox hideBtn = new JCheckBox("버튼 감추기");
        c.add(deactiveBtn);
        c.add(hideBtn);
        c.add(countBtn);
        c.add(countLabel);
        deactiveBtn.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED)
                    countBtn.setEnabled(false);
                else
                    countBtn.setEnabled(true);
            }
        });
        hideBtn.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    if (e.getStateChange() == ItemEvent.SELECTED)
                        countBtn.setVisible(false);
                    else
                        countBtn.setVisible(true);
                }
            }
        });

    }
    public static void main(String[] args) {
        new HW2();
    }
}

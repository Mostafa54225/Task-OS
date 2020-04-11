import javax.swing.*;
import java.awt.*;

public class ListDir {
    private JPanel panel;
    ListDir(){
        JButton button1 = new JButton("List 1");
        JButton button2 = new JButton("List 2");
        panel = new JPanel(new GridLayout(7,2));
        JButton btn1 = new JButton("1");
        JButton btn2 = new JButton("2");
        JButton btn3 = new JButton("3");
        JButton btn4 = new JButton("4");
        JButton btn5 = new JButton("5");
        JButton btn6 = new JButton("6");
        JButton btn7 = new JButton("7");
        JButton btn8 = new JButton("7");
        JButton btn9 = new JButton("7");
        JButton btn10 = new JButton("7");
        JButton btn11 = new JButton("7");
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btn4);
        panel.add(btn5);
        panel.add(btn6);
        panel.add(btn7);
        panel.add(btn8);
        panel.add(btn9);
        panel.add(btn10);
        panel.add(btn11);
    }
    public JPanel method(){
        return panel;
    }
}

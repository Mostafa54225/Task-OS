import javax.swing.*;

public class ChangeMod {
    private JPanel panel;
    ChangeMod(){
        JButton button1 = new JButton("Change 1");
        JButton button2 = new JButton("Change 2");
        panel = new JPanel();
        panel.add(button1);
        panel.add(button2);
    }
    public JPanel method(){
        return panel;
    }
}

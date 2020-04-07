import javax.swing.*;

public class MakeDir {
    private JPanel panel;
    MakeDir(){
        JButton button1 = new JButton("Make 1");
        JButton button2 = new JButton("Make 2");
        panel = new JPanel();
        panel.add(button1);
        panel.add(button2);
    }
    public JPanel method(){
        return panel;
    }
}

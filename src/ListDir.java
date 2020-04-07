import javax.swing.*;

public class ListDir {
    private JPanel panel;
    ListDir(){
        JButton button1 = new JButton("List 1");
        JButton button2 = new JButton("List 2");
        panel = new JPanel();
        panel.add(button1);
        panel.add(button2);
    }
    public JPanel method(){
        return panel;
    }
}

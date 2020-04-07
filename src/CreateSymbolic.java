import javax.swing.*;

public class CreateSymbolic {
    private JPanel panel;
    CreateSymbolic(){
        JButton button1 = new JButton("Symbolic 1");
        JButton button2 = new JButton("Symbolic 2");
        panel = new JPanel();
        panel.add(button1);
        panel.add(button2);
    }
    public JPanel method(){
        return panel;
    }
}

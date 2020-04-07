import javax.swing.*;

public class DeleteDir {

    private JPanel panel;
    DeleteDir(){
        JButton button1 = new JButton("delete 1");
        JButton button2 = new JButton("delete 2");
        panel = new JPanel();
        panel.add(button1);
        panel.add(button2);
    }
    public JPanel method(){
        return panel;
    }
}

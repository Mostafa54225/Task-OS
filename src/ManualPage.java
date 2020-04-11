import javax.swing.*;

public class ManualPage {
    ManualPage(){
        JFrame frame = new JFrame();
        JFrame.setDefaultLookAndFeelDecorated(true);
        JButton button = new JButton("Click");
        frame.add(button);
        frame.setSize(400,400);
        frame.setVisible(true);
    }
}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MakeDir implements ActionListener {
    private JPanel panel;
    JButton button1;
    JButton button2;
    JTextField text1;
    MakeDir(){
        button1 = new JButton("Make Dir");
        button2 = new JButton("Make File");

        JLabel l1=new JLabel("Enter the path and dir/file name :   ");

        text1 =new JTextField();
        text1 =new JTextField(25);

        panel = new JPanel();

        panel.add(l1);
        panel.add(text1);
        panel.add(button1);
        panel.add(button2);
        button1.addActionListener(this);
        button2.addActionListener(this);




    }
    public JPanel method(){
        return panel;
    }

    public  void  MakeDirector(String dir){
        String [] command = {"mkdir" , dir};

        ProcessBuilder processBuilder = new ProcessBuilder(command);

        processBuilder.directory(new File(System.getProperty("user.home")));

        try{
            Process process =processBuilder.start();

        } catch (IOException e){
            e.printStackTrace();
        }

    }

    public  void  MakeFile(String file){
        String [] command = {"touch" , file};

        ProcessBuilder processBuilder = new ProcessBuilder(command);

        processBuilder.directory(new File(System.getProperty("user.home")));

        try{
            Process process =processBuilder.start();
            int exitCode = process.waitFor();
            if(exitCode != 0)
                JOptionPane.showMessageDialog(null, "ERROR FOUND!");

        } catch (IOException | InterruptedException e){
            e.printStackTrace();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()== button1)
        {
            MakeDirector(text1.getText());
            text1.setText("");
        }
        if (e.getSource()== button2)
        {
            MakeFile( text1.getText());
            text1.setText("");
        }



    }
}

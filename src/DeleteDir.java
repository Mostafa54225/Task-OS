import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class DeleteDir {

    private JPanel panel;


    DeleteDir(){
        JButton deletebutton = new JButton("delete");
        JTextField deletetext = new JTextField(40);
        panel = new JPanel();
        panel.add(deletetext);
        panel.add(deletebutton);

        deletebutton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                deletedirmethod(deletetext.getText());

            }
        });


    }
    public JPanel method(){
        return panel;
    }

    public  void  deletedirmethod(String deletefielddata){
       String [] command = {"rm" , "-r" , deletefielddata};

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
    }



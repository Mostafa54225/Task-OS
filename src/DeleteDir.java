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
        JButton deletebutton = new JButton("delete 1");
        JTextField deletetext = new JTextField(40);
        panel = new JPanel();
        panel.add(deletebutton);
        panel.add(deletetext);


        deletebutton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                 /*deletefielddata = deletetext.getText();
                 System.out.println(deletefielddata);*/
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

        } catch (IOException e){
            e.printStackTrace();
        }

    }
    }



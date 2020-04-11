import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class CreateSymbolic {
    private JPanel panel;
    private JTextField fileField, symbolicField;
    private JButton submitButton;
    CreateSymbolic(){
        panel = new JPanel(new FlowLayout(FlowLayout.LEADING, 40,0));
        JLabel fileLabel = new JLabel("file:");
        fileField = new JTextField(15);
        JLabel symbolicLabel = new JLabel("Symbolic File:");
        symbolicField = new JTextField(15);
        submitButton = new JButton("Create Symbolic Link");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                createSymbolic(fileField.getText(), symbolicField.getText());
            }
        });
        panel.add(fileLabel);
        panel.add(fileField);
        panel.add(symbolicLabel);
        panel.add(symbolicField);
        panel.add(submitButton);
    }
    public void createSymbolic(String file, String symbolicFile){
        String[] command = {"ln", "-s", file, symbolicFile};
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        processBuilder.directory(new File(System.getProperty("user.home")));

        try {
            Process process = processBuilder.start();
            int exitCode = process.waitFor();
            if(exitCode != 0)
                JOptionPane.showMessageDialog(null, "Check your inputs, and try again");

            else
                JOptionPane.showMessageDialog(null, "Symbolic File is Created");
        } catch (IOException |InterruptedException e){
            e.printStackTrace();
        }
    }
    public JPanel method(){
        return panel;
    }
}

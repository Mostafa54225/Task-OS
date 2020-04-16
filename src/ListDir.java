import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ListDir {
    private JPanel panel;
    JButton listBtn;
    JTextField path;
    JTextArea list;
    JLabel label;
    //GridLayout layout;
    JScrollPane scroll;
    ProcessBuilder processBuilder;
    private List<String> command;

    ListDir() {
        panel = new JPanel();
        listBtn  = new JButton("List");
        label = new JLabel("enter the path:");
        path = new JTextField(15);
        list = new JTextArea(18,40);
        list.setEditable(false);
        list.setLineWrap(false);
        list.setWrapStyleWord(false);
        scroll = new JScrollPane (list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        //list.setSize(80,40);
        processBuilder = new ProcessBuilder();
        processBuilder.directory(new File(System.getProperty("user.home")));
        command = new ArrayList<>();
        command.add("ls");
        command.add("-l");
        command.add("-a");
        listBtn.addActionListener(e->{
            command.add(path.getText());
            processBuilder.command(command);
            try {
                Process process = processBuilder.start();
                int exitCode = process.waitFor();
                if(exitCode != 0)
                    JOptionPane.showMessageDialog(null, "ERROR FOUND!");
                else {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    String line;
                    while ((line = bufferedReader.readLine())!=null) {
                        list.setText(list.getText()+line+"\n");
                    }
                }
            } catch (IOException | InterruptedException ex) {
                ex.printStackTrace();
            }
        });
        //layout = new GridLayout(4,3);
        //layout.setVgap(10);
        //panel.setLayout(layou);
        panel.add(label);
        panel.add(path);
        panel.add(listBtn);
        panel.add(scroll);
    }

    public JPanel method() {
        return panel;
    }
}
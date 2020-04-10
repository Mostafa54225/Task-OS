import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ChangeMod {
    private JPanel panel;
    private JButton changeBtn;
    private JTextField path;
    private JLabel instructions;
    private JCheckBox uchk;
    private JCheckBox gchk;
    private JCheckBox ochk;
    private JCheckBox rchk;
    private JCheckBox wchk;
    private JCheckBox xchk;
    private GridLayout layout;
    private ProcessBuilder builder;
    private List<String> command;
    private String subCommand;
    ChangeMod(){
        changeBtn = new JButton("Change");
        instructions = new JLabel("Enter the path from root to your file");
        path = new JTextField();
        path.setText("ex: /home/computer/Desktop/example.ex");
        uchk = new JCheckBox("User");
        gchk = new JCheckBox("Group");
        ochk = new JCheckBox("Others");
        rchk = new JCheckBox("Read");
        wchk = new JCheckBox("Write");
        xchk = new JCheckBox("Excute");
        command = new ArrayList<>();
        command.add("chmod");
        subCommand="";
        builder = new ProcessBuilder();
        changeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (uchk.isSelected()&&gchk.isSelected()&&ochk.isSelected())
                    subCommand+="a";
                else {
                    if (uchk.isSelected())
                        subCommand+="u";
                    if (gchk.isSelected())
                        subCommand+="g";
                    if (ochk.isSelected())
                        subCommand+="o";
                }
                subCommand+=("=");

                if (rchk.isSelected()&&wchk.isSelected()&&xchk.isSelected())
                    subCommand+="rwx";
                else if (rchk.isSelected()||wchk.isSelected()||xchk.isSelected()) {
                    if (rchk.isSelected())
                        subCommand+="r";
                    if (wchk.isSelected())
                        subCommand+="w";
                    if (xchk.isSelected())
                        subCommand+="x";
                }
                else subCommand+="0";
                command.add(subCommand);
                command.add(path.getText());
                builder.command(command);
                //builder.command("touch","Test.txt");
                System.out.println(command);
                try {
                    Process process = builder.start();
                    int exitCode = process.waitFor();
                    if(exitCode != 0)
                        JOptionPane.showMessageDialog(null, "ERROR FOUND!");

                    else
                        JOptionPane.showMessageDialog(null, "Permissions are CHANGED successfully!");
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
                subCommand="";
                uchk.setSelected(false);
                gchk.setSelected(false);
                ochk.setSelected(false);
                rchk.setSelected(false);
                wchk.setSelected(false);
                xchk.setSelected(false);
                command.clear();
                command.add("chmod");
            }

        });
        panel = new JPanel();
        layout = new GridLayout(3,1);
        layout.setHgap(50);
        panel.setLayout(layout);
        panel.add(uchk);
        panel.add(gchk);
        panel.add(ochk);
        panel.add(rchk);
        panel.add(wchk);
        panel.add(xchk);
        panel.add(instructions);
        panel.add(path);
        panel.add(changeBtn);
    }
    public JPanel method(){
        return panel;
    }
}

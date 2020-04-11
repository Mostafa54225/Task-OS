import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static JPanel contentPanel;
    public static void main(String[] args) {
        JFrame frame = new JFrame("File Manager");
        JFrame.setDefaultLookAndFeelDecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel, choicesPanel;

        // Main Panel for the page
        mainPanel = new JPanel(new GridLayout(2, 1));

        JButton list = new JButton("List");
        JButton makeDir = new JButton("Make (dir,file)");
        JButton deleteDir = new JButton("Delete (dir,file)");
        JButton createSymbolicLink = new JButton("Create Symbolic Link");
        JButton changePermission = new JButton("Change Permission of a file");
        JButton manPage = new JButton("Manual Page");
        // Choices Panel for the buttons
        choicesPanel = new JPanel(new FlowLayout(FlowLayout.LEADING, 45,50));


        // Content Panel
        contentPanel = new JPanel();

        // Action Button (List)
        list.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ListDir listDir = new ListDir();
                switchContent(listDir.method());
            }
        });


        // Action Button (Make Dir)
        makeDir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                MakeDir makeDir = new MakeDir();
                switchContent(makeDir.method());
            }
        });

        // Action Button (Delete)
        deleteDir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DeleteDir deleteDir = new DeleteDir();
                switchContent(deleteDir.method());
            }
        });

        // Action Button (Create Symbolic)
        createSymbolicLink.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                CreateSymbolic createSymbolic = new CreateSymbolic();
                switchContent(createSymbolic.method());
            }
        });

        // Action Button (Change Permission)
        changePermission.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ChangeMod changeMod = new ChangeMod();
                switchContent(changeMod.method());
            }
        });

        // Action Button (Manual Page)
        manPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ManualPage manualPage = new ManualPage();
            }
        });

        // Add Components to the panel
        choicesPanel.add(list);
        choicesPanel.add(makeDir);
        choicesPanel.add(deleteDir);
        choicesPanel.add(createSymbolicLink);
        choicesPanel.add(changePermission);
        choicesPanel.add(manPage);

        mainPanel.add(choicesPanel);
        mainPanel.add(contentPanel);

        frame.add(mainPanel);
        frame.setSize(1200,800);
        frame.setVisible(true);
    }

    //Method For Switching Between Contents
    public static void switchContent(JPanel panel){
        contentPanel.removeAll();
        contentPanel.add(panel);
        contentPanel.repaint();
        contentPanel.revalidate();
    }
}

package ken.gui.tab;

import ken.backend.plugin.PluginManager;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.jar.JarFile;

public class Setting extends KENTab implements ActionListener {
    private JButton buttonPlugin;
    private JButton buttonFile;
    private JLabel dataTypeText;
    private JComboBox dataType;
    private JButton dataTypeButton;
    public Setting(){
        this.setSize(500,500);
        this.setBackground(new Color(0x2C3333));
        this.setLayout(null);
        makePanelSetting();
        this.setBounds(0,0,500,500);
    }

    @Override
    public String tabName(){
        return "Setting";
    }

    public void makePanelSetting() {
        buttonPlugin = new JButton("Add Plugin");
        buttonPlugin.setBounds(50, 80,  300, 100);
        buttonPlugin.setBackground(new Color(0xD9D9D9));
        buttonPlugin.setForeground(Color.black);
        buttonPlugin.setFont(new Font("Poppins", Font.BOLD,25));
        buttonPlugin.addActionListener(this);
        buttonPlugin.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        buttonFile = new JButton("Choose Database File");
        buttonFile.setBounds(50, 230,  300, 100);
        buttonFile.setBackground(new Color(0xD9D9D9));
        buttonFile.setForeground(Color.black);
        buttonFile.setFont(new Font("Poppins", Font.BOLD,25));
        buttonFile.addActionListener(this);
        buttonFile.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));


//        dataTypeText = new JLabel("Database file format :");
//        dataTypeText.setFont(new Font("Poppins", Font.BOLD,30));
//        dataTypeText.setForeground(Color.white);
//        dataTypeText.setBounds(320,380,350,100);
        this.add(buttonPlugin);
        this.add(buttonFile);
//        this.add(dataTypeText);

        String[] dataTypeList = new String[]{"JSON", "XML","OBJ"};

        dataType = new JComboBox(dataTypeList);
        dataType.setBackground(new Color(0xD9D9D9));
        dataType.setBounds(50,400,230,70);
        dataType.setFont(new Font("Poppins", Font.BOLD,20));
        dataType.setForeground(new Color(0x395B64));
        dataType.setFocusable(false);
        this.add(dataType);

        dataTypeButton = new JButton("SET");
        dataTypeButton.setBounds(280, 400, 70 , 70);
        dataTypeButton.setBackground(new Color(0xD9D9D9));
        dataTypeButton.setForeground(Color.black);
        dataTypeButton.setFont(new Font("Poppins", Font.BOLD,25));
        dataTypeButton.addActionListener(this);
        dataTypeButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        this.add(dataTypeButton);
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource()==buttonPlugin) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            FileNameExtensionFilter jarFilter = new FileNameExtensionFilter("JAR FILES","jar");
            fileChooser.setFileFilter(jarFilter);
            int returnValue = fileChooser.showOpenDialog(this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                // File selected by the user
                String filePath = fileChooser.getSelectedFile().getPath();
                // Perform any necessary operations with the selected file
//                System.out.println("Selected file: " + filePath);
                try{
                    JarFile jar = new JarFile(filePath);
                    PluginManager.addFromArchive(jar);
                }catch(Exception ex){
                    System.out.println("Failed to load JAR:");
                    ex.printStackTrace();
                }
            }
        } else if (e.getSource() == buttonFile) {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showOpenDialog(this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                // File selected by the user
                String filePath = fileChooser.getSelectedFile().getPath();
                // Perform any necessary operations with the selected file
                System.out.println("Selected file: " + filePath);
            }
        } else if (e.getSource() == dataTypeButton) {
            String selectedType = (String) dataType.getSelectedItem();
            System.out.println("Selected Format: " + selectedType );
        }
    }

}

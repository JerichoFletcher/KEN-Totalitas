package ken.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class EditMember extends JPanel implements ActionListener{
    private JPanel panelEdit;
    private JButton editButton;
    private JTextField textField;
    private JTextField textField2;
    private JComboBox pilihMember;
    public EditMember(){
        panelEdit = new JPanel();
        this.setSize(500,500);
        this.setBackground(new Color(0x2C3333));
        this.setLayout(null);


        // Calculate the position of the center panel


        makePanelEdit();
        this.add(panelEdit);
        this.setBounds(0,0,500,500);
    }

    public void makePanelEdit(){
        panelEdit = new JPanel();
        panelEdit.setSize(1220,840);
        panelEdit.setBackground(new Color(0xE7F6F2));
        panelEdit.setBounds(0, 0, 1280, 580);
        panelEdit.setLayout(null);
        JLabel label = new JLabel("  Edit Member/VIP");
        label.setFont(new Font("Poppins", Font.BOLD,40));
        label.setForeground(new Color(0x395B64));
        panelEdit.add(label);
        label.setBounds(400,30,500,100);
        textField = new JTextField();
        textField.setBounds(310,130,590,65);
        textField.setText("Nama");
        textField.setFont(new Font("Poppins", Font.BOLD,20));
        textField.setForeground(new Color(0x395B64));
        textField.setBackground(new Color(0xD9D9D9));
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals("Nama")) {
                    textField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().equals("")) {
                    textField.setText("Nama");
                }
            }
        });
        textField2 = new JTextField();
        textField2.setBounds(310,215,590,65);
        textField2.setText("Nomor Telfon");
        textField2.setFont(new Font("Poppins", Font.BOLD,20));
        textField2.setForeground(new Color(0x395B64));
        textField2.setBackground(new Color(0xD9D9D9));
        textField2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField2.getText().equals("Nomor Telfon")) {
                    textField2.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField2.getText().equals("")) {
                    textField2.setText("Nomor Telfon");
                }
            }
        });
        String[] tipeMember = new String[]{"Member", "VIP"};
        pilihMember = new JComboBox(tipeMember);
        pilihMember.setBackground(new Color(0xD9D9D9));
        pilihMember.setBounds(310,300,590,65);
        pilihMember.setFont(new Font("Poppins", Font.BOLD,20));
        pilihMember.setForeground(new Color(0x395B64));
        editButton = new JButton();
        editButton.addActionListener(this);
        editButton.setFocusable(false);
        editButton.setContentAreaFilled( false );
        editButton.setText("SAVE");
        editButton.setFont(new Font("Poppins", Font.BOLD,40));
        editButton.setBackground(new Color(0, 0, 0, 0));
        editButton.setForeground(new Color(0x395B64));
        editButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        editButton.setBounds(950,440,200,90);
        panelEdit.add(textField);
        panelEdit.add(textField2);
        panelEdit.add(pilihMember);
        panelEdit.add(editButton);

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == editButton){
            String editNama = (String) textField.getText().trim();
            String editTelpString = (String) textField2.getText().trim();
            String editType = (String) pilihMember.getSelectedItem();
            if (editTelpString != "Nomor Telfon" || editTelpString.length() != 0) {
                System.out.println("Editing Member...");
                System.out.println("Nama: " + editNama);
                System.out.println("Harga: " + editTelpString);
                System.out.println("Kategori: " + editType);
            }
        }
    }
}

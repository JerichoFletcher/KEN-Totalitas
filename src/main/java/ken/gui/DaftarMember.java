package ken.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class DaftarMember extends JPanel {
    private JPanel panelDaftar;
    DaftarMember(){
        panelDaftar = new JPanel();
        this.setSize(500,500);
        this.setBackground(new Color(0x2C3333));
        this.setLayout(null);


        // Calculate the position of the center panel


        makePanelDaftar();
        this.add(panelDaftar);
        this.setBounds(0,0,500,500);
    }

    public void makePanelDaftar(){
        panelDaftar = new JPanel();
        panelDaftar.setSize(1220,840);
        panelDaftar.setBackground(new Color(0xE7F6F2));
        panelDaftar.setBounds(350, 130, 1220, 840);
        panelDaftar.setLayout(null);
        JLabel label = new JLabel("Daftar Member/VIP");
        label.setFont(new Font("Poppins", Font.BOLD,40));
        label.setForeground(new Color(0x395B64));
        panelDaftar.add(label);
        label.setBounds(400,50,500,100);
        JTextField textField = new JTextField();
        textField.setBounds(310,180,590,90);
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
        JTextField textField2 = new JTextField();
        textField2.setBounds(310,330,590,90);
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
        panelDaftar.add(textField);
        panelDaftar.add(textField2);

    }
}

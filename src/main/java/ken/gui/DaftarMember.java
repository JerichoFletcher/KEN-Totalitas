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

        panelDaftar.setSize(1220,840);
        panelDaftar.setBackground(new Color(0xF8FFFD));
        panelDaftar.setBounds(350, 130, 1220, 840);
        panelDaftar.setLayout(null);
        this.add(panelDaftar);
        JLabel label = new JLabel("Daftar Member/VIP");
        label.setFont(new Font("Poppins", Font.BOLD,20));
        label.setForeground(new Color((0x395B64)));
        panelDaftar.add(label);
        label.setBounds(0,0,400,200);
        JTextField textField = new JTextField("Enter text here");
        textField.setBounds(0,0,590,108);
        textField.setText("Nama");
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
        panelDaftar.add(textField);


        this.setBounds(0,0,500,500);
    }
}

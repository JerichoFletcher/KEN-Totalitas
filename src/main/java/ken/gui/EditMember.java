package ken.gui;

import ken.backend.controller.Controller;
import ken.backend.controller.holder.CustomerHolder;
import ken.backend.controller.holder.MemberHolder;
import ken.backend.controller.holder.VIPHolder;
import ken.backend.kelas.anggota.Member;
import ken.backend.kelas.anggota.VIP;

import javax.swing.*;
import javax.xml.bind.JAXBException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.net.URISyntaxException;

public class EditMember extends JPanel implements ActionListener{
    private JPanel panelEdit;
    private JButton editButton;
    private JTextField textField;
    private JTextField textField2;
    private JComboBox pilihMember;
    private JComboBox pilihStateMember;
    private int id;
    private String nama;
    private String phone;
    private String memberType;
    private boolean activeType;
    public EditMember(int iid, String inama, String iphone, String imemberType, boolean iactiveType){
        panelEdit = new JPanel();
        this.setSize(500,500);
        this.setBackground(new Color(0x2C3333));
        this.setLayout(null);
        this.id = iid;
        this.nama = inama;
        this.phone = iphone;
        this.memberType = imemberType;
        this.activeType = iactiveType;


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
        textField.setBounds(310,130,590,50);
        textField.setText(nama);
        textField.setFont(new Font("Poppins", Font.BOLD,20));
        textField.setForeground(new Color(0x395B64));
        textField.setBackground(new Color(0xD9D9D9));
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().trim().equals(nama)) {
                    textField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().trim().equals("")) {
                    textField.setText(nama);
                }
            }
        });
        textField2 = new JTextField();
        textField2.setBounds(310,200,590,50);
        textField2.setText(phone);
        textField2.setFont(new Font("Poppins", Font.BOLD,20));
        textField2.setForeground(new Color(0x395B64));
        textField2.setBackground(new Color(0xD9D9D9));
        textField2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField2.getText().trim().equals(phone)) {
                    textField2.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField2.getText().trim().equals("")) {
                    textField2.setText(phone);
                }
            }
        });
        String[] tipeMember = new String[]{"Member", "VIP"};
        pilihMember = new JComboBox(tipeMember);
        pilihMember.setBackground(new Color(0xD9D9D9));
        pilihMember.setBounds(310,270,590,50);
        pilihMember.setFont(new Font("Poppins", Font.BOLD,20));
        pilihMember.setForeground(new Color(0x395B64));
        if (memberType == "ken.backend.kelas.anggota.Member") {
            pilihMember.setSelectedItem("Member");
        }else {
            pilihMember.setSelectedItem("VIP");
        }

        String[] tipeStateMember = new String[]{"Aktif", "Non-Aktif"};
        pilihStateMember = new JComboBox(tipeStateMember);
        pilihStateMember.setBackground(new Color(0xD9D9D9));
        pilihStateMember.setBounds(310,340,590,50);
        pilihStateMember.setFont(new Font("Poppins", Font.BOLD,20));
        pilihStateMember.setForeground(new Color(0x395B64));
        if (activeType) {
            pilihStateMember.setSelectedItem("Aktif");
        } else {
            pilihStateMember.setSelectedItem("Non-Aktif");
        }


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
        panelEdit.add(pilihStateMember);

    }

    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource() == editButton){
                String editNama = (String) textField.getText().trim();
                String editTelpString = (String) textField2.getText().trim();
                String editType = (String) pilihMember.getSelectedItem();
                String editStatus = (String) pilihStateMember.getSelectedItem();
                if (editNama.length() == 0) {
                    editNama = nama;
                }
                if (editTelpString.length() ==0 ) {
                    editTelpString = phone;
                }
                if (editTelpString != "Nomor Telfon" || editTelpString.length() != 0) {
                    System.out.println("Editing Member...");
                    System.out.println("Nama: " + editNama);
                    System.out.println("Telp: " + editTelpString);
                    System.out.println("Tipe: " + editType);
                    System.out.println("Status: " + editStatus);
                    Controller.instance().fetchData(VIPHolder.instance(), "vip");
                    Controller.instance().fetchData(MemberHolder.instance(), "member");
                    if(editType.equals("VIP")){
                        System.out.println("masuk");
//                    Member memberHolder =  MemberHolder.instance().getMemberById(id);
                        VIP newVIP = new VIP(editNama, editTelpString, id);
                        newVIP.setActive(editStatus.equals("Aktif"));
                        MemberHolder.instance().removeMember(id);
                        VIPHolder.instance().addVIP(newVIP);
                        Controller.instance().writeData(MemberHolder.instance(), "member");
                        Controller.instance().writeData(VIPHolder.instance(), "vip");
                    }else{
                        System.out.println("masuk2");
//                    VIP VIPHolder =  MemberHolder.instance().getMemberById(id);
                        Member newMember = new Member(editNama, editTelpString, id);
                        newMember.setActive(editStatus.equals("Aktif"));
                        VIPHolder.instance().removeVIP(id);
                        MemberHolder.instance().addMember(newMember);
                        Controller.instance().writeData(MemberHolder.instance(), "member");
                        Controller.instance().writeData(VIPHolder.instance(), "vip");
                    }
                }

            }
        }catch (URISyntaxException | IOException | JAXBException ex) {
            throw new RuntimeException(ex);
        }
    }
}

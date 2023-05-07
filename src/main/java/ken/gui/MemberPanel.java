package ken.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemberPanel extends JPanel implements ActionListener {
    private JButton editButton;
    private int id;
    private String nama;
    private String phone;
    private String memberType;
    private boolean activeType;
    public MemberPanel(int iid, String judul, String iphone, String imemberType, boolean iactiveType){
        super();
        this.id = iid;
        this.nama = judul;
        this.phone = iphone;
        this.memberType = imemberType;
        this.activeType = iactiveType;
        JLabel title = new JLabel(id +"  " +judul);
        JLabel activeT = new JLabel();
        JLabel tipeMember = new JLabel();
        editButton = new JButton("EDIT");
        this.setLayout(null);
        this.setBackground(new Color(0xF2F2F2));
        this.setPreferredSize(new Dimension(1000,50));
        this.setMaximumSize(new Dimension(1280,100)); // set maximum size to fixed value
        this.setMinimumSize(new Dimension(1280,100));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        editButton.addActionListener(this);
        editButton.setFocusable(false);
        editButton.setContentAreaFilled( false );
        editButton.setFont(new Font("Poppins", Font.BOLD,20));
        editButton.setBackground(new Color(0, 0, 0, 0));
        editButton.setForeground(new Color(0x395B64));
        editButton.setBorder(BorderFactory.createEmptyBorder());
        editButton.setBounds(1020,25,100,50);
        title.setBounds(10,25,500,50);
        title.setForeground(new Color(0x395B64));
        title.setFont(new Font("Poppins", Font.BOLD,20));
        activeT.setBounds(700,25,500,50);
        activeT.setForeground(new Color(0x395B64));
        activeT.setFont(new Font("Poppins", Font.BOLD,20));
        tipeMember.setBounds(550,25,500,50);
        tipeMember.setForeground(new Color(0x395B64));
        tipeMember.setFont(new Font("Poppins", Font.BOLD,20));

        if (activeType) {
            activeT.setText("Aktif");
        } else {
            activeT.setText("Non-Aktif");
        }

        if (memberType == "ken.backend.kelas.anggota.Member") {
            tipeMember.setText("Member");
        }else {
            tipeMember.setText("VIP");
        }

        this.add(activeT);
        this.add(tipeMember);
        this.add(title);
        this.add(editButton);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == editButton){
            System.out.println("tambah dummy");
            EditMember layarEM = new EditMember(id,nama,phone,memberType,activeType);
            Tabs.tabs.addCustomTab("Edit Member", layarEM, Tabs.tabCount);
            Tabs.tabs.setSelectedComponent(layarEM);
        }
    }
}

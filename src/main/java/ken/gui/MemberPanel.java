package ken.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemberPanel extends JPanel implements ActionListener {
    private JButton editButton;
    public MemberPanel(String judul){
        super();
        JLabel title = new JLabel(judul);
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
        editButton.setBounds(1020,0,100,50);
        title.setBounds(10,0,500,50);
        title.setForeground(new Color(0x395B64));
        title.setFont(new Font("Poppins", Font.BOLD,20));
        this.add(title);
        this.add(editButton);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == editButton){
            System.out.println("tambah dummy");
            EditMember layarEM = new EditMember();
            Tabs.tabs.addCustomTab("Edit Member", layarEM, Tabs.tabCount);
            Tabs.tabs.setSelectedComponent(layarEM);
        }
    }
}

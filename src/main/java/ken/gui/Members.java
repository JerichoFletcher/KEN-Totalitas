package ken.gui;

import javax.swing.*;
import java.awt.*;

public class Members extends JPanel {
    private JPanel members;
    Members(){
        super();
        this.setSize(500,500);
        this.setBackground(new Color(0x2C3333));
        this.setLayout(null);
        makePanelMembers();
        this.setBounds(0,0,500,500);
    }

    public void makePanelMembers(){
        members = new JPanel();
        JPanel headerMember = new JPanel();
        headerMember.setLayout(null);
        headerMember.setBackground(new Color(0xD9D9D9));
        JLabel headerText = new JLabel("List of Members");
        headerText.setFont(new Font("Poppins", Font.BOLD,15));
        headerText.setForeground(Color.black);
        headerMember.add(headerText);
        headerText.setBounds(550,0,200,50);
        headerMember.setBounds(370,50,1200, 50);
        this.add(headerMember);
        members.setBackground(new Color(0xFFFFFF));
        members.setLayout(new BoxLayout(members, BoxLayout.Y_AXIS));
        for (int i = 1; i <= 20; i++) {
            MemberPanel memberPanel = new MemberPanel("nama " + i);
            members.add(memberPanel);
        }
        JScrollPane scrollPane = new JScrollPane(members);
        scrollPane.setBounds(370, 100, 1200, 920);
        this.add(scrollPane);
    }

}

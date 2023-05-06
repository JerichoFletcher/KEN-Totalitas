package ken.gui.tab;

import ken.gui.MemberPanel;

import javax.swing.*;
import java.awt.*;

public class Members extends KENTab {
    private JPanel members;
    public Members(){
        super();
        this.setSize(500,500);
        this.setBackground(new Color(0x2C3333));
        this.setLayout(null);
        makePanelMembers();
        this.setBounds(0,0,500,500);
    }

    @Override
    public String tabName(){
        return "Members";
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
        headerText.setBounds(600,0,1280,50);
        headerMember.setBounds(0,0,1280, 50);
        this.add(headerMember);
        members.setBackground(new Color(0xFFFFFF));
        members.setLayout(new BoxLayout(members, BoxLayout.Y_AXIS));
        for (int i = 1; i <= 20; i++) {
            MemberPanel memberPanel = new MemberPanel("nama " + i);
            members.add(memberPanel);
        }
        JScrollPane scrollPane = new JScrollPane(members);
        scrollPane.setBounds(0, 50, 1260, 520);
        this.add(scrollPane);
    }

}

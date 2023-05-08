package ken.gui.tab;

import ken.backend.controller.Controller;
import ken.backend.controller.holder.FixedBillHolder;
import ken.backend.controller.holder.MemberHolder;
import ken.backend.controller.holder.VIPHolder;
import ken.backend.dataStore.AdapterJSON;
import ken.backend.kelas.anggota.Member;
import ken.backend.kelas.anggota.VIP;
import ken.gui.MemberPanel;

import javax.swing.*;
import javax.xml.bind.JAXBException;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class Members extends KENTab {
    private JPanel members;
    public Members(){
        super();
        this.setSize(500,500);
        this.setBackground(new Color(0x2C3333));
        this.setLayout(null);
        try {
            makePanelMembers();;
        }catch (IOException | URISyntaxException | RuntimeException | JAXBException ex){
            ex.printStackTrace();
        }
        this.setBounds(0,0,500,500);
    }

    @Override
    public String tabName(){
        return "Members";
    }

    public void makePanelMembers() throws URISyntaxException, IOException, JAXBException {
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
//        for (int i = 1; i <= 20; i++) {
//            MemberPanel memberPanel = new MemberPanel("nama " + i);
//            members.add(memberPanel);
//        }
        try{
            Controller.instance().fetchData(VIPHolder.instance(), "vip");
            for(Map.Entry<Integer, VIP> entry : VIPHolder.instance().getListVIP().entrySet()){
                Integer key = entry.getKey();
                Member value = entry.getValue();
                // Do something with the key and value...

                MemberPanel memberPanel = new MemberPanel(key, value.getName(), value.getPhoneNumber(), value.getClass().getName(), value.isActive());
                members.add(memberPanel);

            }

            Controller.instance().fetchData(MemberHolder.instance(), "member");
            for(Map.Entry<Integer, Member> entry : MemberHolder.instance().getListMember().entrySet()){
                Integer key = entry.getKey();
                Member value = entry.getValue();
                // Do something with the key and value...

                MemberPanel memberPanel = new MemberPanel(key, value.getName(), value.getPhoneNumber(), value.getClass().getName(), value.isActive());
                members.add(memberPanel);

            }
        }catch(Exception ex){
            throw new RuntimeException();
        }




        JScrollPane scrollPane = new JScrollPane(members);
        scrollPane.setBounds(0, 50, 1260, 520);
        this.add(scrollPane);
    }

}

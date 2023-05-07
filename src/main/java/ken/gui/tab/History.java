package ken.gui.tab;

import ken.gui.HistoryPanel;
import ken.gui.UnduhDetil;
import ken.gui.UnduhHistory;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class History extends KENTab implements ActionListener {
    private JPanel history;
    private JButton unduhButton;
    private List<String> listOfName;
    private List<Integer>  listOfPrice;
    public History(){
        super();
        listOfPrice = new ArrayList<Integer>();
        listOfName = new ArrayList<String>();
        this.setSize(500,500);
        this.setBackground(new Color(0x2C3333));
        this.setLayout(null);
        makePanelMembers();
        this.setBounds(0,0,500,500);
    }

    @Override
    public String tabName(){
        return "History";
    }

    public void makePanelMembers(){
        history = new JPanel();
        JPanel headerMember = new JPanel();
        headerMember.setLayout(null);
        headerMember.setBackground(new Color(0xD9D9D9));
        JLabel headerText = new JLabel("     History");
        headerText.setFont(new Font("Poppins", Font.BOLD,15));
        headerText.setForeground(Color.black);
        unduhButton = new JButton();
        unduhButton.addActionListener(this);
        unduhButton.setFocusable(false);
        unduhButton.setContentAreaFilled( false );
        unduhButton.setText("UNDUH HISTORY");
        unduhButton.setFont(new Font("Poppins", Font.BOLD,15));
        unduhButton.setBackground(new Color(0, 0, 0, 0));
        unduhButton.setForeground(Color.black);
        unduhButton.setBorder(BorderFactory.createEmptyBorder());
        unduhButton.setBounds(1050,0,250,50);
        headerMember.add(unduhButton);
        headerMember.add(headerText);
        headerText.setBounds(600,0,1280,50);
        headerMember.setBounds(0,0,1280, 50);
        this.add(headerMember);
        history.setBackground(new Color(0xFFFFFF));
        history.setLayout(new BoxLayout(history, BoxLayout.Y_AXIS));
        for (int i = 1; i <= 20; i++) {
            HistoryPanel historyPanel = new HistoryPanel("nama " + i);
            history.add(historyPanel);
            listOfName.add("nama " + i);
            listOfPrice.add(1000);
        }
        JScrollPane scrollPane = new JScrollPane(history);
        scrollPane.setBounds(0, 50, 1260, 520);
        this.add(scrollPane);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == unduhButton){
            System.out.println("unduh dummy");
            UnduhHistory unduhHistory = new UnduhHistory(listOfName, listOfPrice);
            Thread cetakBill = new Thread(unduhHistory);
            cetakBill.run();
        }
    }
}

package ken.gui.tab;

import ken.backend.Vars;
import ken.backend.controller.Controller;
import ken.backend.controller.holder.FixedBillHolder;
import ken.backend.controller.holder.InventoryHolder;
import ken.backend.dataStore.AdapterJSON;
import ken.backend.kelas.bill.Bill;
import ken.gui.HistoryPanel;
import ken.gui.UnduhHistory;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        try {
            makePanelMembers();
        }catch (IOException | URISyntaxException ex){
            ex.printStackTrace();
        }
        this.setBounds(0,0,500,500);
    }

    @Override
    public String tabName(){
        return "History";
    }

    public void makePanelMembers() throws URISyntaxException, IOException{
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
        Controller.instance().fetchData(FixedBillHolder.instance(), "billFixed");
        for (Map.Entry<Integer, Bill> entry : FixedBillHolder.instance().getListBill().entrySet()) {
            Integer key = entry.getKey();
            Bill value = entry.getValue();
            // Do something with the key and value...

            HistoryPanel historyPanel = new HistoryPanel(key, value.getIdCustomer(), value.getTotalHarga().get(Vars.mataUang), value.getListBarang());
            history.add(historyPanel);
            listOfName.add(key + "   " + value.getIdCustomer());
            listOfPrice.add(value.getTotalHarga().get(Vars.mataUang));
        }
        JScrollPane scrollPane = new JScrollPane(history);
        scrollPane.setBounds(0, 50, 1260, 520);
        this.add(scrollPane);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == unduhButton){
            UnduhHistory unduhHistory = new UnduhHistory(listOfName, listOfPrice);
            Thread cetakBill = new Thread(unduhHistory);
            cetakBill.run();
        }
    }
}

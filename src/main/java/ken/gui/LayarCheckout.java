package ken.gui;

import ken.backend.controller.Controller;
import ken.backend.controller.holder.FixedBillHolder;
import ken.backend.controller.holder.InventoryHolder;
import ken.backend.controller.holder.MemberHolder;
import ken.backend.controller.holder.VIPHolder;
import ken.backend.kelas.anggota.Customer;
import ken.backend.kelas.anggota.Member;
import ken.backend.kelas.anggota.VIP;
import ken.backend.Vars;
import ken.backend.kelas.barang.Barang;
import ken.backend.kelas.bill.Bill;
import ken.backend.kelas.bill.BillItem;
import ken.backend.settings.Settings;
import ken.util.UID;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.xml.bind.JAXBException;


public class LayarCheckout extends JPanel implements ActionListener{
    private JPanel panelBarang;
    private JButton fixBill;
    private JComboBox pilihMember;
    private JPanel panelMember;
    private JTextField inputField;
    private JTextField pointField;
    private List<CartItem> listOfCartItem;
    private int id;
    private float total;
    private int clickCounter;

    public LayarCheckout(List<CartItem> listOfCartItem, float total){
        super();
        this.clickCounter = 0;
        this.listOfCartItem = listOfCartItem;
        this.setVisible(true);
        this.setBackground(new Color(0x2C3333));
        this.setLayout(null);
        this.total = total;
        try {
            makePanelLC();
        }catch (IOException | URISyntaxException | JAXBException ex){
            ex.printStackTrace();
        }
        this.setBounds(0,0,500,500);
    }

    public void makePanelLC() throws URISyntaxException, IOException, JAXBException {
        JLabel checkoutText = new JLabel("Checkout");
        JLabel totalPrice = new JLabel("Total: " + (String) Settings.get(UID.of(Vars.defaultNamespace, "settings", "currency")) + " " + total);
        checkoutText.setFont(new Font("Poppins", Font.BOLD,40));
        checkoutText.setForeground(Color.white);
        checkoutText.setBounds(550,30,500,100);
        totalPrice.setFont(new Font("Poppins", Font.BOLD,30));
        totalPrice.setForeground(Color.white);
        totalPrice.setBounds(35,480,500,100);
        this.add(checkoutText);
        this.add(totalPrice);
        panelBarang = new JPanel();
        panelBarang.setBackground(new Color(0x2C3333));
        panelBarang.setLayout(new BoxLayout(panelBarang, BoxLayout.Y_AXIS));
        panelBarang.setBorder(BorderFactory.createEmptyBorder());
        for (int i = 0; i <= listOfCartItem.size() - 1; i++) {
            String judulBarang = listOfCartItem.get(i).getJudul();
            int jmlhBarang = listOfCartItem.get(i).getCounter();
            JLabel item = new JLabel(judulBarang + "    " + jmlhBarang + 'x');
            item.setForeground(Color.white);
            item.setFont(new Font("Poppins", Font.BOLD,20));
            panelBarang.add(item);
        }
        JScrollPane scrollPane = new JScrollPane(panelBarang);
        scrollPane.setBackground(new Color(0, 0, 0, 0));
        scrollPane.setBounds(450, 150, 200, 350);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        List<Map.Entry<Integer, String>> allMember = new ArrayList<>();
//        allMember.add(new AbstractMap.SimpleEntry<>(-1, ""));
//        allMember.add(new AbstractMap.SimpleEntry<>(1, "Alek"));
//        allMember.add(new AbstractMap.SimpleEntry<>(2, "Farhan"));
//        allMember.add(new AbstractMap.SimpleEntry<>(3, "Jericho"));
//        allMember.add(new AbstractMap.SimpleEntry<>(4, "Jovan"));
//        allMember.add(new AbstractMap.SimpleEntry<>(5, "Shidqi"));
//        allMember.add(new AbstractMap.SimpleEntry<>(6, "Obama"));
//        allMember.add(new AbstractMap.SimpleEntry<>(7, "Trump"));
//        allMember.add(new AbstractMap.SimpleEntry<>(8, "Putin"));
//        allMember.add(new AbstractMap.SimpleEntry<>(9, "Jokowi"));
//        allMember.add(new AbstractMap.SimpleEntry<>(10, "Xi Jinping"));

        try{
            Controller.instance().fetchData(VIPHolder.instance(), "vip");
            for(Map.Entry<Integer, VIP> entry : VIPHolder.instance().getListVIP().entrySet()){
                Integer key = entry.getKey();
                Member value = entry.getValue();
                // Do something with the key and value...
                allMember.add(new AbstractMap.SimpleEntry<>(key, value.getName()));

            }

            Controller.instance().fetchData(MemberHolder.instance(), "member");
            for(Map.Entry<Integer, Member> entry : MemberHolder.instance().getListMember().entrySet()){
                Integer key = entry.getKey();
                Member value = entry.getValue();
                // Do something with the key and value...
                allMember.add(new AbstractMap.SimpleEntry<>(key, value.getName()));

            }
        }catch(Exception ex){
            throw new RuntimeException(ex);
        }

//        pilihMember = new JComboBox(tipeMember);
//        pilihMember.setBackground(new Color(0xD9D9D9));
//        pilihMember.setBounds(920,400,250,50);
//        pilihMember.setFont(new Font("Poppins", Font.BOLD,20));
//        pilihMember.setForeground(new Color(0x395B64));
//        pilihMember.setFocusable(false);
//        this.add(pilihMember);
        inputField = new JTextField();
        inputField.setBounds(920, 100, 300, 50);
        inputField.setFont(new Font("Poppins", Font.PLAIN, 20));

        pointField = new JTextField();
        pointField.setBounds(920, 25, 300, 50);
        pointField.setFont(new Font("Poppins", Font.PLAIN, 20));

        this.add(pointField);
        pointField.setVisible(false);
        panelMember = new JPanel();
        panelMember.setBackground(new Color(0x2C3333));
        panelMember.setLayout(new BoxLayout(panelMember, BoxLayout.Y_AXIS));
        panelMember.setBorder(BorderFactory.createEmptyBorder());


        for (Map.Entry<Integer, String> member: allMember) {
            if (member.getKey()!=-1) {
                MemberCheckoutPanel panelNama = new MemberCheckoutPanel(member.getValue(),member.getKey(),this, inputField, pointField);
                panelMember.add(panelNama);
            }

        }

        JScrollPane scrollMember = new JScrollPane(panelMember);
        scrollMember.setBackground(new Color(0, 0, 0, 0));
        scrollMember.setBounds(830, 150, 500, 350);
        scrollMember.setBorder(BorderFactory.createEmptyBorder());

        LayarCheckout layar = this;
        inputField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                handleTextChanged();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                handleTextChanged();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                handleTextChanged();
            }

            private void handleTextChanged() {
                String enteredText = inputField.getText().toLowerCase();
                panelMember.removeAll();
                for (Map.Entry<Integer, String> member : allMember) {
                    if (member.getValue().toLowerCase().startsWith(enteredText)) {
                        if (member.getKey() != -1) {
                            MemberCheckoutPanel panelNama = new MemberCheckoutPanel(member.getValue(), member.getKey(), layar, inputField,pointField);
                            panelMember.add(panelNama);
                        }
                    }
                }
                panelMember.revalidate();
                panelMember.repaint();
            }
        });
        this.add(inputField);
        this.add(scrollPane);
        this.add(scrollMember);

        fixBill = new JButton();
        fixBill.addActionListener(this);
        fixBill.setFocusable(false);
        fixBill.setContentAreaFilled( false );
        fixBill.setText("FIX BILL");
        fixBill.setFont(new Font("Poppins", Font.BOLD,40));
        fixBill.setBackground(new Color(0, 0, 0, 0));
        fixBill.setForeground(Color.white);
        fixBill.setBorder(BorderFactory.createEmptyBorder());
        fixBill.setBounds(920,500,250,75);
        this.add(fixBill);

    }

    public void setId(int newID) {
        this.id = newID;
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == fixBill){
            try{
                if(clickCounter == 0){
                    System.out.println("Fixed Bill Created");
                    System.out.println("Name : " + inputField.getText());
                    System.out.println("ID : " + id);
                    String selectedItem = (String) inputField.getText();
                    Controller.instance().fetchData(FixedBillHolder.instance(), "billFixed");
                    Controller.instance().fetchData(InventoryHolder.instance(), "barang");
                    Controller.instance().fetchData(MemberHolder.instance(), "member");
                    Controller.instance().fetchData(VIPHolder.instance(), "vip");
                    boolean notMember = false;
                    try{
                        notMember = !MemberHolder.instance().getMemberById(id).getName().equals(inputField.getText());
                    }catch(NullPointerException ex){
                        ex.printStackTrace();
                    }
                    try{
                        notMember = !VIPHolder.instance().getVIPById(id).getName().equals(inputField.getText());
                    }catch(NullPointerException ex){
                        ex.printStackTrace();
                    }
                    if(inputField.getText().length() ==  0 || notMember){
                        Customer newCustomer = new Customer();
                        int idNew = newCustomer.getId();
                        Bill fixedBill = new Bill(idNew, total);
                        LayarFixedBill layarFB = new LayarFixedBill("", listOfCartItem, total, idNew, fixedBill.getIdBill());
                        Tabs.tabs.addCustomTab("Layar Fixed Bill", layarFB, Tabs.tabCount);
                        Tabs.tabs.setSelectedComponent(layarFB);
                        for(int i = 0; i < listOfCartItem.size() ; i++){
                            int idt = listOfCartItem.get(i).getID();
                            String namaBarang = listOfCartItem.get(i).getJudul();
                            int jumlah = listOfCartItem.get(i).getCounter();
                            float harga = listOfCartItem.get(i).getHarga();
                            BillItem billItem = new BillItem(idt, namaBarang, jumlah, harga);
                            Barang barang = InventoryHolder.instance().getBarangById(listOfCartItem.get(i).getID());
                            barang.setStok(barang.getStok() - listOfCartItem.get(i).getCounter());
                            fixedBill.addBarang(billItem);
                        }
                        FixedBillHolder.instance().addBill(fixedBill);
                        Controller.instance().writeData(FixedBillHolder.instance(), "billFixed");
                        Controller.instance().writeData(InventoryHolder.instance(), "barang");
                    }
                    else{
                        Float point = Float.parseFloat(pointField.getText());
                        if(MemberHolder.instance().getMemberById(id) != null){
                            float memberPoint = MemberHolder.instance().getMemberById(id).getPoints();
                            if(point >= memberPoint){
                                point = memberPoint;
                            }
                            if(this.total <= memberPoint){
                                MemberHolder.instance().getMemberById(id).setPoints(memberPoint - this.total);
                                this.total = 0;
                            }else{
                                this.total -= point;
                                MemberHolder.instance().getMemberById(id).setPoints(memberPoint - point);
                            }
                            double setAdd = this.total * 0.01;
                            float fsetAdd = (float) setAdd;
                            float setPoint = MemberHolder.instance().getMemberById(id).getPoints() + fsetAdd;
                            MemberHolder.instance().getMemberById(id).setPoints(setPoint);
                        }else{
                            this.total *= 0.9;
                            float VIPPoint = VIPHolder.instance().getVIPById(id).getPoints();
                            if(point >= VIPPoint){
                                point = VIPPoint;
                            }
                            if(this.total <= VIPPoint){
                                VIPHolder.instance().getVIPById(id).setPoints(VIPPoint - this.total);
                                this.total = 0;
                            }else{
                                this.total -= point;
                                VIPHolder.instance().getVIPById(id).setPoints(VIPPoint - point);
                            }
                            double setAdd = this.total * 0.01;
                            float fsetAdd = (float) setAdd;
                            float setPoint = VIPHolder.instance().getVIPById(id).getPoints() + fsetAdd;
                            VIPHolder.instance().getVIPById(id).setPoints(setPoint);
                        }
                        Bill fixedBill = new Bill(id, total);
                        LayarFixedBill layarFB = new LayarFixedBill(selectedItem, listOfCartItem, total, id, fixedBill.getIdBill());
                        Tabs.tabs.addCustomTab("Layar Fixed Bill", layarFB, Tabs.tabCount);
                        Tabs.tabs.setSelectedComponent(layarFB);
                        for(int i = 0; i < listOfCartItem.size() ; i++){
//                        System.out.println();
                            int idt = listOfCartItem.get(i).getID();
                            String namaBarang = listOfCartItem.get(i).getJudul();
                            int jumlah = listOfCartItem.get(i).getCounter();
                            float harga = listOfCartItem.get(i).getHarga();
                            BillItem billItem = new BillItem(idt, namaBarang, jumlah, harga);
                            Barang barang = InventoryHolder.instance().getBarangById(listOfCartItem.get(i).getID());
                            System.out.println(listOfCartItem.get(i).getID());
                            barang.setStok(barang.getStok() - listOfCartItem.get(i).getCounter());
                            fixedBill.addBarang(billItem);
                        }
                        FixedBillHolder.instance().addBill(fixedBill);
                        Controller.instance().writeData(FixedBillHolder.instance(), "billFixed");
                        Controller.instance().writeData(InventoryHolder.instance(), "barang");
                    }
                    Controller.instance().writeData(MemberHolder.instance(), "member");
                    Controller.instance().writeData(VIPHolder.instance(), "vip");
                    this.clickCounter++;
                }

            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
}

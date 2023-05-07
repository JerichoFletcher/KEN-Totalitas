package ken.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class LayarFixedBill extends JPanel implements ActionListener {
    private JPanel panelBarang;
    private JButton daftarButton;
    private JButton cetakButton;
    private String customer;
    private List<CartItem> listOfCartItem;
    private List<String> listOfName;
    private ArrayList<Integer> listOfAmount;
    private int total;
    private int idNewCust;


    public LayarFixedBill(String customer, List<CartItem> listOfCartItem, int total, int idNewCust) {
        super();
        this.listOfCartItem = listOfCartItem;
        this.customer = customer;
        this.idNewCust = idNewCust;
        listOfAmount = new ArrayList<Integer>();
        listOfName = new ArrayList<String>();
        this.total = total;
        this.setVisible(true);
        this.setBackground(new Color(0x2C3333));
        this.setLayout(null);
        makePanelLC();
        this.setBounds(0, 0, 500, 500);
    }

    public void makePanelLC() {
        JLabel fixedBill = new JLabel("Fixed Bill");
        JLabel totalPrice = new JLabel("Total: Rp." + total);
        fixedBill.setFont(new Font("Poppins", Font.BOLD, 40));
        fixedBill.setForeground(Color.white);
        fixedBill.setBounds(160, 10, 500, 100);
        totalPrice.setFont(new Font("Poppins", Font.BOLD, 30));
        totalPrice.setForeground(Color.white);
        totalPrice.setBounds(135, 480, 500, 100);
        this.add(fixedBill);
        this.add(totalPrice);
        panelBarang = new JPanel();
        panelBarang.setBackground(new Color(0x2C3333));
        panelBarang.setLayout(new BoxLayout(panelBarang, BoxLayout.Y_AXIS));
        panelBarang.setBorder(BorderFactory.createEmptyBorder());
        for (int i = 0; i <= listOfCartItem.size() - 1; i++) {
            String judulBarang = listOfCartItem.get(i).getJudul();
            int jmlhBarang = listOfCartItem.get(i).getCounter();
            listOfName.add(judulBarang);
            listOfAmount.add(jmlhBarang);
            JLabel item = new JLabel(judulBarang + "    " + jmlhBarang + 'x');
            item.setForeground(Color.white);
            item.setFont(new Font("Poppins", Font.BOLD,20));
            panelBarang.add(item);
        }
        JScrollPane scrollPane = new JScrollPane(panelBarang);
        scrollPane.setBackground(new Color(0, 0, 0, 0));
        scrollPane.setBounds(100, 110, 500, 400);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        this.add(scrollPane);
        if (customer.length() == 0) {
            JLabel namaCustomer = new JLabel("Pembelian customer berhasil dicatat!");
            namaCustomer.setFont(new Font("Poppins", Font.BOLD, 30));
            namaCustomer.setForeground(Color.white);
            namaCustomer.setBounds(650, 120, 1000, 100);
            this.add(namaCustomer);
            daftarButton = new JButton("Daftar Member/VIP");
            daftarButton.addActionListener(this);
            daftarButton.setBackground(new Color(0xD9D9D9));
            daftarButton.setBounds(775, 250, 230, 100);
            daftarButton.setFont(new Font("Poppins", Font.BOLD, 20));
            daftarButton.setForeground(new Color(0x395B64));
            daftarButton.setFocusable(false);
            this.add(daftarButton);
        }
        else{
            JLabel namaCustomer = new JLabel("Pembelian " + customer + " berhasil dicatat!");
            namaCustomer.setFont(new Font("Poppins", Font.BOLD, 30));
            namaCustomer.setForeground(Color.white);
            namaCustomer.setBounds(650, 120, 1000, 100);
            this.add(namaCustomer);
        }
        cetakButton = new JButton("Cetak Bill");
        cetakButton.addActionListener(this);
        cetakButton.setBackground(new Color(0xD9D9D9));
        cetakButton.setBounds(775, 400, 230, 50);
        cetakButton.setFont(new Font("Poppins", Font.BOLD, 20));
        cetakButton.setForeground(new Color(0x395B64));
        cetakButton.setFocusable(false);
        this.add(cetakButton);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == daftarButton) {
            DaftarMember layarDM = new DaftarMember(idNewCust);
            Tabs.tabs.addCustomTab("Daftar Member", layarDM, Tabs.tabCount);
            Tabs.tabs.setSelectedComponent(layarDM);
        }
        if(e.getSource() == cetakButton) {
            this.total = 1000;
            System.out.println("cetak dummy");
            UnduhDetil unduhDetil = new UnduhDetil(listOfName, listOfAmount, total);
            Thread cetakBill = new Thread(unduhDetil);
            cetakBill.run();

        }
    }



}

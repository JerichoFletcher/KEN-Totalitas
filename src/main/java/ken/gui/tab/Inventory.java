package ken.gui.tab;

import ken.gui.InventoryPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Inventory extends KENTab implements ActionListener {
    private JPanel inventory;
    private JTextField inputFieldNama;
    private JTextField inputFieldHarga;
    private JComboBox catDrop;
    private JButton searchButton;
    public Inventory(){
        super();
        this.setSize(500,500);
        this.setBackground(new Color(0x2C3333));
        this.setLayout(null);
        makePanelInventory();
        this.setBounds(0,0,500,500);
    }

    @Override
    public String tabName(){
        return "Inventory";
    }

    public void makePanelInventory(){
        inventory = new JPanel();
        JPanel headerInventory = new JPanel();
        headerInventory.setLayout(null);
        headerInventory.setBackground(new Color(0xD9D9D9));
        JLabel headerText = new JLabel("Inventory List");
        headerText.setFont(new Font("Poppins", Font.BOLD,15));
        headerText.setForeground(Color.black);
        headerInventory.add(headerText);
        headerText.setBounds(600,0,1280,50);
        headerInventory.setBounds(0,0,1280, 50);
        this.add(headerInventory);
        inventory.setBackground(new Color(0xFFFFFF));
        inventory.setLayout(new BoxLayout(inventory, BoxLayout.Y_AXIS));
        for (int i = 1; i <= 20; i++) {
            InventoryPanel invPanel = new InventoryPanel("item " + i);
            inventory.add(invPanel);
        }
        JScrollPane scrollPane = new JScrollPane(inventory);
        scrollPane.setBounds(0, 90, 1260, 480);
        this.add(scrollPane);

        inputFieldNama = new JTextField();
        inputFieldNama.setBounds(0, 50, 400, 40);
        inputFieldNama.setFont(new Font("Poppins", Font.PLAIN, 20));
        inputFieldNama.setText("Nama Barang");
        inputFieldNama.setForeground(new Color(0x395B64));
        inputFieldNama.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (inputFieldNama.getText().equals("Nama Barang")) {
                    inputFieldNama.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (inputFieldNama.getText().equals("")) {
                    inputFieldNama.setText("Nama Barang");
                }
            }
        });
        this.add(inputFieldNama);
        inputFieldHarga = new JTextField();
        inputFieldHarga.setBounds(400, 50, 400, 40);
        inputFieldHarga.setFont(new Font("Poppins", Font.PLAIN, 20));
        inputFieldHarga.setText("Harga Barang");
        inputFieldHarga.setForeground(new Color(0x395B64));
        inputFieldHarga.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (inputFieldHarga.getText().equals("Harga Barang")) {
                    inputFieldHarga.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (inputFieldHarga.getText().equals("")) {
                    inputFieldHarga.setText("Harga Barang");
                }
            }
        });
        this.add(inputFieldHarga);

        String[] catList = new String[]{"","Makanan","Minuman"};

        catDrop = new JComboBox(catList);
        catDrop.setBackground(new Color(0xD9D9D9));
        catDrop.setBounds(800,50,400,40);
        catDrop.setFont(new Font("Poppins", Font.BOLD,15));
        catDrop.setForeground(new Color(0x395B64));
        catDrop.setFocusable(false);
        this.add(catDrop);

        searchButton = new JButton("Search");
        searchButton.setBounds(1200, 50,  60, 40);
        searchButton.setBackground(new Color(0xD9D9D9));
        searchButton.setForeground(Color.black);
        searchButton.setFont(new Font("Poppins", Font.BOLD,12));
        searchButton.addActionListener(this);
        searchButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        this.add(searchButton);
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource()==searchButton) {
            int searchHarga= -1;
            String searchNama = (String) inputFieldNama.getText().trim();
            String searchHargaString = (String) inputFieldHarga.getText().trim();
            String searchCat = (String) catDrop.getSelectedItem();
            if (searchHargaString.length() !=0 ) {
                try {
                    searchHarga = Integer.parseInt(searchHargaString);
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid integer input");
                }
            }
            if (searchHarga != -1 || searchHargaString.length() == 0) {
                System.out.println("Searching...");
                System.out.println("Nama: " + searchNama);
                System.out.println("Harga: " + searchHarga);
                System.out.println("Kategori: " + searchCat);
            }
        }
    }
}

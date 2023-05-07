package ken.gui.tab;

import ken.backend.controller.holder.InventoryHolder;
import ken.backend.dataStore.AdapterJSON;
import ken.backend.kelas.barang.Barang;
import ken.gui.InventoryPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;


public class Inventory extends KENTab implements ActionListener {
    private JPanel inventory;
    private JTextField inputFieldNama;
    private JTextField inputFieldHarga;
    private JTextField inputFieldKategori;
    private JButton searchButton;
    public Inventory() throws URISyntaxException, IOException {
        super();
        this.setSize(500,500);
        this.setBackground(new Color(0x2C3333));
        this.setLayout(null);
        makePanelInventory();
        this.setBounds(0,0,500,500);
//        this.inventoryHolder = InventoryHolder.instance();
    }

    @Override
    public String tabName(){
        return "Inventory";
    }

    public void makePanelInventory() throws URISyntaxException, IOException {
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

        AdapterJSON adapter = new AdapterJSON();;
        InventoryHolder.instance().load(getClass().getResource("/database/barang.json").toURI(),adapter);

        for (Map.Entry<Integer, Barang> entry : InventoryHolder.instance().getListBarang().entrySet()) {
            Integer key = entry.getKey();
            Barang value = entry.getValue();
            // Do something with the key and value...

            ken.gui.InventoryPanel invPanel = new InventoryPanel(key, value.getNamaBarang(), value.getHargaBarang(), value.getHargaBeliBarang(), value.getStok(), value.getGambar(), value.getKategori());
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

        inputFieldKategori = new JTextField();
        inputFieldKategori.setBounds(800, 50, 400, 40);
        inputFieldKategori.setFont(new Font("Poppins", Font.PLAIN, 20));
        inputFieldKategori.setText("Kategori");
        inputFieldKategori.setForeground(new Color(0x395B64));
        inputFieldKategori.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (inputFieldKategori.getText().equals("Kategori")) {
                    inputFieldKategori.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (inputFieldKategori.getText().equals("")) {
                    inputFieldKategori.setText("Kategori");
                }
            }
        });
        this.add(inputFieldKategori);

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
            String searchCat = (String) inputFieldKategori.getText().trim();
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

package ken.gui.tab;

import ken.backend.controller.Controller;
import ken.backend.controller.holder.FixedBillHolder;
import ken.backend.controller.holder.InventoryHolder;
import ken.backend.dataStore.AdapterJSON;
import ken.backend.kelas.barang.Barang;
import ken.gui.*;

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
    private JPanel inventory2;
    private JTextField inputFieldNama;
    private JTextField inputFieldHarga;
    private JTextField inputFieldKategori;
    private JButton searchButton;
    private JButton addItemButton;
    private JScrollPane scrollPane;
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
        inventory2 = new JPanel();
        JPanel headerInventory = new JPanel();
        headerInventory.setLayout(null);
        headerInventory.setBackground(new Color(0xD9D9D9));
        JLabel headerText = new JLabel("Inventory List");
        headerText.setFont(new Font("Poppins", Font.BOLD,15));
        headerText.setForeground(Color.black);
        addItemButton = new JButton("ADD ITEM");
        addItemButton.addActionListener(this);
        addItemButton.setFocusable(false);
        addItemButton.setContentAreaFilled( false );
        addItemButton.setFont(new Font("Poppins", Font.BOLD,20));
        addItemButton.setBackground(new Color(0, 0, 0, 0));
        addItemButton.setForeground(new Color(0x395B64));
        addItemButton.setBorder(BorderFactory.createEmptyBorder());
        addItemButton.setBounds(1120,0,150,50);
        headerInventory.add(headerText);
        headerInventory.add(addItemButton);
        headerText.setBounds(600,0,1280,50);
        headerInventory.setBounds(0,0,1280, 50);
        this.add(headerInventory);
        inventory.setBackground(new Color(0xFFFFFF));
        inventory.setLayout(new BoxLayout(inventory, BoxLayout.Y_AXIS));

        inventory2.setBackground(new Color(0xFFFFFF));
        inventory2.setLayout(new BoxLayout(inventory2, BoxLayout.Y_AXIS));


        Controller.instance().fetchData(InventoryHolder.instance(), "barang");
        for (Map.Entry<Integer, Barang> entry : InventoryHolder.instance().getListBarang().entrySet()) {
            Integer key = entry.getKey();
            Barang value = entry.getValue();
            // Do something with the key and value...

            ken.gui.InventoryPanel invPanel = new InventoryPanel(key, value.getNamaBarang(), value.getHargaBarang(), value.getHargaBeliBarang(), value.getStok(), value.getGambar(), value.getKategori());
            inventory.add(invPanel);
        }
        scrollPane = new JScrollPane(inventory);
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
                if (inputFieldNama.getText().trim().equals("Nama Barang")) {
                    inputFieldNama.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (inputFieldNama.getText().trim().equals("")) {
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
                if (inputFieldHarga.getText().trim().equals("Harga Barang")) {
                    inputFieldHarga.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (inputFieldHarga.getText().trim().equals("")) {
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
                if (inputFieldKategori.getText().trim().equals("Kategori")) {
                    inputFieldKategori.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (inputFieldKategori.getText().trim().equals("")) {
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
    public JScrollPane getScrollPane(){
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane){
        this.scrollPane = scrollPane;
        this.scrollPane.revalidate();
        this.scrollPane.repaint();
    }
    public void actionPerformed(ActionEvent e){
        if (e.getSource()==searchButton) {

            float searchHarga= -1;
            String searchNama = (String) inputFieldNama.getText();
            String searchHargaString = (String) inputFieldHarga.getText().trim();
            String searchCat = (String) inputFieldKategori.getText();
            if (searchHargaString.length() !=0 ) {
                try {
                    searchHarga = Integer.parseInt(searchHargaString);
                } catch (NumberFormatException ex) {
                    System.out.println("Invalid integer input");
                }
            }
            if (searchNama.equals("Nama Barang")){
                searchNama = "";
            }
            if (searchCat.equals("Kategori")) {
                searchCat = "";
            }
            if (searchHarga != -1 || searchNama.length() != 0 || searchCat.length() != 0) {
                System.out.println("Searching...");
                System.out.println("Nama: " + searchNama);
                System.out.println("Harga: " + searchHarga);
                System.out.println("Kategori: " + searchCat);

                if (searchHarga == -1) {
                    searchHarga = Float.MAX_VALUE;
                }
                inventory2.removeAll();
                inventory2.revalidate();
                inventory2.repaint();


                for (Map.Entry<Integer, Barang> entry : InventoryHolder.instance().getListBarang().entrySet()) {

                    Integer key = entry.getKey();
                    Barang value = entry.getValue();

//                    ken.gui.InventoryPanel invPanel = new InventoryPanel(key, value.getNamaBarang(), value.getHargaBarang(), value.getHargaBeliBarang(), value.getStok(), value.getGambar(), value.getKategori());
//                    inventory2.add(invPanel);

                    System.out.println(value.getNamaBarang().trim().toLowerCase().startsWith(searchNama.toLowerCase()));
                    System.out.println(value.getKategori().trim().toLowerCase().startsWith(searchCat.toLowerCase()));
                    System.out.println(value.getHargaBarang()<=searchHarga);
                    // Do something with the key and value...
                    if (value.getNamaBarang().trim().toLowerCase().startsWith(searchNama.toLowerCase()) && value.getKategori().trim().toLowerCase().startsWith(searchCat.toLowerCase()) && value.getHargaBarang()<=searchHarga){
                        System.out.println(value.getNamaBarang() + ' ' + value.getKategori() + ' ' + value.getHargaBarang());
                        ken.gui.InventoryPanel invPanel = new InventoryPanel(key, value.getNamaBarang(), value.getHargaBarang(), value.getHargaBeliBarang(), value.getStok(), value.getGambar(), value.getKategori());
                        inventory2.add(invPanel);
                    }
                }

                JViewport viewport = scrollPane.getViewport();
                viewport.remove(inventory);
                viewport.add(inventory2);

                scrollPane.repaint();
                scrollPane.revalidate();
//                scrollPane.removeAll();
//                setScrollPane(getScrollPane());
//                scrollPane.add(inventory2);
//                setScrollPane(getScrollPane());
            } else {
                JViewport viewport = scrollPane.getViewport();
                viewport.remove(inventory2);
                viewport.add(inventory);

                scrollPane.repaint();
                scrollPane.revalidate();
            }
        } else if (e.getSource() == addItemButton) {
            AddItem layarAI = new AddItem();
            Tabs.tabs.addCustomTab("Add Item", layarAI, Tabs.tabCount);
            Tabs.tabs.setSelectedComponent(layarAI);
        }
    }
}

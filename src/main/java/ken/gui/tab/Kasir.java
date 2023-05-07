package ken.gui.tab;

import ken.backend.controller.Controller;
import ken.backend.controller.holder.InventoryHolder;
import ken.backend.dataStore.AdapterJSON;
import ken.backend.kelas.barang.Barang;
import ken.gui.CartItem;
import ken.gui.LayarCheckout;
import ken.gui.MenuItem;
import ken.gui.Tabs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Kasir extends KENTab implements ActionListener {
    private JPanel inventory;
    private JPanel cart;
    private JButton checkoutButton;

    private JButton saveBillButton;
    private JButton searchButton;
    private JTabbedPane tabbedPane;
    private Tabs tabs;
    private JComboBox pilihHistory;
    private JScrollPane scrollPane;

    private JButton getHistoryButton;
    private String selectedHistory;
    private JTextField inputFieldNama;
    private JTextField inputFieldHarga;
    private JTextField inputFieldKategori;
    private int price;
    private JLabel priceText;
//    private JPanel pricePanel;
    private List<CartItem> listOfCartItem = new ArrayList<>();

    public Kasir(){
        this.setSize(500,500);
        this.setBackground(new Color(0x2C3333));
        this.setLayout(null);
        try {
            makePanelKasir();
        }catch (IOException | URISyntaxException ex){
            ex.printStackTrace();
        }

        this.setBounds(0,0,500,500);
    }

    @Override
    public String tabName(){
        return "Kasir";
    }

    public void makePanelKasir() throws URISyntaxException, IOException {

        JPanel headerInv = new JPanel();
        JPanel headerCart = new JPanel();
        JPanel pricePanel = new JPanel();
        priceText = new JLabel("Rp. " + 0);
        headerInv.setLayout(null);
        headerCart.setLayout(null);
        cart = new JPanel();
        inventory = new JPanel();
        this.tabs = tabs;
        // Set the background and size of the header panel
        JLabel menuText = new JLabel("Items");
        JLabel cartText = new JLabel("Cart");
        menuText.setFont(new Font("Poppins", Font.BOLD,15));
        menuText.setForeground(Color.black);
        cartText.setFont(new Font("Poppins", Font.BOLD,15));
        cartText.setForeground(Color.black);
        priceText.setFont(new Font("Poppins", Font.BOLD,15));
        priceText.setForeground(Color.black);
        headerInv.add(menuText);
        menuText.setBounds(360,0,100,50);
        cartText.setBounds(240,0,100,50);
        priceText.setBounds(240,0,100,50);pricePanel.add(priceText);
        headerInv.setBackground(new Color(0xD9D9D9));
        headerInv.setBounds(10,5,740, 50);
        headerCart.setBackground(new Color(0xD9D9D9));
        headerCart.setBounds( 760,5,490, 50);
        headerCart.add(cartText);
        pricePanel.setBackground(new Color(0xD9D9D9));
        pricePanel.setBounds(760,475,490, 40);


        String[] historyList = new String[]{"","History1", "History2"};

        pilihHistory = new JComboBox(historyList);
        pilihHistory.setBackground(new Color(0xD9D9D9));
        pilihHistory.setBounds(760,55,350,50);
        pilihHistory.setFont(new Font("Poppins", Font.BOLD,20));
        pilihHistory.setForeground(new Color(0x395B64));
        pilihHistory.setFocusable(false);
        this.add(pilihHistory);

        selectedHistory = (String) pilihHistory.getSelectedItem();

        getHistoryButton = new JButton("Get Bill");
        getHistoryButton.setBounds(1110, 55,  140, 50);
        getHistoryButton.setBackground(new Color(0xD9D9D9));
        getHistoryButton.setForeground(Color.black);
        getHistoryButton.setFont(new Font("Poppins", Font.BOLD,20));
        getHistoryButton.addActionListener(this);
        getHistoryButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        this.add(getHistoryButton);

        inventory.setBackground(new Color(0xFFFFFF));
        inventory.setLayout(new BoxLayout(inventory, BoxLayout.Y_AXIS));
        inventory.setLocation(0,0);
        cart.setLayout(new BoxLayout(cart, BoxLayout.Y_AXIS));
        Controller.instance().fetchData("barang");
        for (Map.Entry<Integer, Barang> entry : InventoryHolder.instance().getListBarang().entrySet()) {
            Integer key = entry.getKey();
            Barang value = entry.getValue();
            // Do something with the key and value...

            ken.gui.MenuItem menuItem = new MenuItem(key, value.getNamaBarang(), value.getHargaBarang(), value.getStok(), value.getGambar(), price, cart, this);
            inventory.add(menuItem);
        }

        inputFieldNama = new JTextField();
        inputFieldNama.setBounds(10, 55, 230, 40);
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
        inputFieldHarga.setBounds(240, 55, 230, 40);
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
        inputFieldKategori.setBounds(470, 55, 230, 40);
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
        searchButton.setBounds(700, 55,  50, 40);
        searchButton.setBackground(new Color(0xD9D9D9));
        searchButton.setForeground(Color.black);
        searchButton.setFont(new Font("Poppins", Font.BOLD,12));
        searchButton.addActionListener(this);
        searchButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        this.add(searchButton);


        scrollPane = new JScrollPane(inventory);
        JScrollPane scrollPane1 = new JScrollPane(cart);
        scrollPane.setBounds(10, 95, 740, 480);
        scrollPane1.setBounds(760, 105, 490, 370);
        checkoutButton = new JButton("Checkout");
        checkoutButton.setBounds(950, 515,  300, 60);
        checkoutButton.setBackground(new Color(0xD9D9D9));
        checkoutButton.setForeground(Color.black);
        checkoutButton.setFont(new Font("Poppins", Font.BOLD,25));
        checkoutButton.addActionListener(this);
        checkoutButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        saveBillButton = new JButton("Save Bill");
        saveBillButton.setBounds(760, 515,  190, 60);
        saveBillButton.setBackground(new Color(0xD9D9D9));
        saveBillButton.setForeground(Color.black);
        saveBillButton.setFont(new Font("Poppins", Font.BOLD,20));
        saveBillButton.addActionListener(this);
        saveBillButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        pricePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        this.add(pricePanel);
        this.add(checkoutButton);
        this.add(headerCart);
        this.add(scrollPane1);
        this.add(headerInv);
        this.add(scrollPane);
        this.add(saveBillButton);
        JPanel item1 = new JPanel();
    }

    public List<CartItem> getCart(){
        return listOfCartItem;
    }

    public void addCartItem(CartItem cartItem){
        listOfCartItem.add(cartItem);
    }
    public void eraseItemFromCart(CartItem cartItem){
        listOfCartItem.remove(cartItem);
    }

    public void setPriceText(int price){
        this.price = price;
        priceText.setText("Rp. " + price);
    }
    public int getPriceText(){
        return this.price;
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
        if(e.getSource() == checkoutButton){
            System.out.println("redirect ke checkout menu");
            System.out.println(listOfCartItem.size());
            LayarCheckout layarCheckout = new LayarCheckout(listOfCartItem, price);
            Tabs.tabs.addCustomTab("Layar Checkout", layarCheckout, Tabs.tabCount);
            Tabs.tabs.setSelectedComponent(layarCheckout);
        } else if (e.getSource()==saveBillButton) {
            System.out.println("save bill");
        } else if (e.getSource()==getHistoryButton) {
            selectedHistory = (String) pilihHistory.getSelectedItem();
            if (selectedHistory.length() != 0) {
                System.out.println("get history" + selectedHistory);
            } else {
                System.out.println("Tidak memilih history");
            }
        } else if (e.getSource()==searchButton) {
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

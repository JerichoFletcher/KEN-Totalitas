package ken.gui.tab;

import ken.gui.LayarCheckout;
import ken.gui.MenuItem;
import ken.gui.Tabs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;

public class Kasir extends KENTab implements ActionListener {
    private JPanel inventory;
    private JPanel cart;
    private JButton checkoutButton;

    private JButton saveBillButton;
    private JButton searchButton;
    private JTabbedPane tabbedPane;
    private Tabs tabs;
    private JComboBox pilihHistory;

    private JButton getHistoryButton;
    private String selectedHistory;
    private JTextField inputFieldNama;
    private JTextField inputFieldHarga;
    private JComboBox catDrop;
<<<<<<< Updated upstream:src/main/java/ken/gui/Kasir.java
    public static List<CartItem> listOfCartItem = new ArrayList<>();
    Kasir(){
=======
    public Kasir(){
>>>>>>> Stashed changes:src/main/java/ken/gui/tab/Kasir.java
        this.setSize(500,500);
        this.setBackground(new Color(0x2C3333));
        this.setLayout(null);
        makePanelKasir();
        this.setBounds(0,0,500,500);
    }

    @Override
    public String tabName(){
        return "Kasir";
    }

    public void makePanelKasir() {

        JPanel headerInv = new JPanel();
        JPanel headerCart = new JPanel();
        JPanel pricePanel = new JPanel();
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
        headerInv.add(menuText);
        menuText.setBounds(360,0,100,50);
        cartText.setBounds(240,0,100,50);
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
        for (int i = 1; i <= 15; i++) {
<<<<<<< Updated upstream:src/main/java/ken/gui/Kasir.java
            MenuItem menuItem = new MenuItem(i, "Barang ke " + i, i, cart);
=======
            ken.gui.MenuItem menuItem = new MenuItem("Barang ke " + i, i, cart);
>>>>>>> Stashed changes:src/main/java/ken/gui/tab/Kasir.java
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

        String[] catList = new String[]{"","Makanan","Minuman"};

        catDrop = new JComboBox(catList);
        catDrop.setBackground(new Color(0xD9D9D9));
        catDrop.setBounds(470,55,230,40);
        catDrop.setFont(new Font("Poppins", Font.BOLD,15));
        catDrop.setForeground(new Color(0x395B64));
        catDrop.setFocusable(false);
        this.add(catDrop);

        searchButton = new JButton("Search");
        searchButton.setBounds(700, 55,  50, 40);
        searchButton.setBackground(new Color(0xD9D9D9));
        searchButton.setForeground(Color.black);
        searchButton.setFont(new Font("Poppins", Font.BOLD,12));
        searchButton.addActionListener(this);
        searchButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        this.add(searchButton);


        JScrollPane scrollPane = new JScrollPane(inventory);
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

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == checkoutButton){
            System.out.println("redirect ke checkout menu");
            System.out.println(listOfCartItem.size());
            LayarCheckout layarCheckout = new LayarCheckout(listOfCartItem);
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
            String searchNama = (String) inputFieldNama.getText();
            String searchHargaString = (String) inputFieldHarga.getText();
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

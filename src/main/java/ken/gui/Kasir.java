package ken.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kasir extends JPanel implements ActionListener {
    private JPanel inventory;
    private JPanel cart;
    private JButton checkoutButton;

    private JButton saveBillButton;
    private JTabbedPane tabbedPane;
    private Tabs tabs;
    Kasir(){
        this.setSize(500,500);
        this.setBackground(new Color(0x2C3333));
        this.setLayout(null);
        makePanelKasir();
        this.setBounds(0,0,500,500);
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
        JLabel menuText = new JLabel("Menu");
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
        inventory.setBackground(new Color(0xFFFFFF));
        inventory.setLayout(new BoxLayout(inventory, BoxLayout.Y_AXIS));
        inventory.setLocation(0,0);
        cart.setLayout(new BoxLayout(cart, BoxLayout.Y_AXIS));
        for (int i = 1; i <= 15; i++) {
            MenuItem menuItem = new MenuItem("Barang ke " + i, i, cart);
            inventory.add(menuItem);
        }
        JScrollPane scrollPane = new JScrollPane(inventory);
        JScrollPane scrollPane1 = new JScrollPane(cart);
        scrollPane.setBounds(10, 55, 740, 520);
        scrollPane1.setBounds(760, 55, 490, 420);
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
            LayarCheckout layarCheckout = new LayarCheckout();
            Tabs.tabs.addCustomTab("Layar Checkout", layarCheckout, Tabs.tabCount);
            Tabs.tabs.setSelectedComponent(layarCheckout);
        } else if (e.getSource()==saveBillButton) {
            System.out.println("save bill");
        }
    }

}

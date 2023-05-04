package ken.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Kasir extends JPanel implements ActionListener {
    private JPanel inventory;
    private JPanel cart;
    private JButton checkoutButton;
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
        // Set the background and size of the header panel
        JLabel menuText = new JLabel("Menu");
        JLabel cartText = new JLabel("Cart");
        menuText.setFont(new Font("Poppins", Font.BOLD,15));
        menuText.setForeground(Color.black);
        cartText.setFont(new Font("Poppins", Font.BOLD,15));
        cartText.setForeground(Color.black);
        headerInv.add(menuText);
        menuText.setBounds(500,0,100,50);
        cartText.setBounds(400,0,100,50);
        headerInv.setBackground(new Color(0xD9D9D9));
        headerInv.setBounds(50,50,1000, 50);
        headerCart.setBackground(new Color(0xD9D9D9));
        headerCart.setBounds(1100,50,800, 50);
        headerCart.add(cartText);
        pricePanel.setBackground(new Color(0xD9D9D9));
        pricePanel.setBounds(1100,910,800, 110);
        inventory.setBackground(new Color(0xFFFFFF));
        inventory.setLayout(new BoxLayout(inventory, BoxLayout.Y_AXIS));
        cart.setLayout(new BoxLayout(cart, BoxLayout.Y_AXIS));
        for (int i = 1; i <= 5; i++) {
            MenuItem menuItem = new MenuItem("Barang ke " + i, i, cart);
            inventory.add(menuItem);

        }
        JScrollPane scrollPane = new JScrollPane(inventory);
        JScrollPane scrollPane1 = new JScrollPane(cart);
        scrollPane.setBounds(50, 100, 1000, 920);
        scrollPane1.setBounds(1100, 100, 800, 770);
        checkoutButton = new JButton("Checkout");
        checkoutButton.setBounds(1100, 865, 800, 50);
        checkoutButton.setBackground(new Color(0xD9D9D9));
        checkoutButton.setForeground(Color.black);
        checkoutButton.setFont(new Font("Poppins", Font.BOLD,25));
        checkoutButton.addActionListener(this);
        checkoutButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        pricePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        this.add(pricePanel);
        this.add(checkoutButton);
        this.add(headerCart);
        this.add(scrollPane1);
        this.add(headerInv);
        this.add(scrollPane);
        JPanel item1 = new JPanel();
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == checkoutButton){
            System.out.println("redirect ke checkout menu");
        }
    }

}

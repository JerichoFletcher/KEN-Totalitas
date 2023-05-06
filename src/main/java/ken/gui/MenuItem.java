package ken.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuItem extends JPanel implements ActionListener {
    private JButton addButton;
    private JPanel cart;
    private String judul;
    private int harga;
    MenuItem(String judul, int harga, JPanel cart){
        super();
        this.judul = judul;
        this.harga = harga;
        this.cart = cart;
        JLabel title = new JLabel(judul);
        JLabel price = new JLabel("Rp" + harga +"000");
        addButton = new JButton("+");
        this.setLayout(null);
        this.setBackground(new Color(0xF2F2F2));
        this.setPreferredSize(new Dimension(720,50));
        this.setMaximumSize(new Dimension(1000,50)); // set maximum size to fixed value
        this.setMinimumSize(new Dimension(1000,50));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        addButton.addActionListener(this);
        addButton.setFocusable(false);
        addButton.setContentAreaFilled( false );
        addButton.setFont(new Font("Poppins", Font.BOLD,15));
        addButton.setBackground(new Color(0, 0, 0, 0));
        addButton.setForeground(new Color(0x395B64));
        addButton.setBorder(BorderFactory.createEmptyBorder());
        addButton.setBounds(640,0,50,50);
        title.setBounds(10,0,200,50);
        title.setForeground(new Color(0x395B64));
        title.setFont(new Font("Poppins", Font.BOLD,20));
        price.setBounds(800,0,200,50);
        price.setForeground(new Color(0x395B64));
        price.setFont(new Font("Poppins", Font.BOLD,20));
        this.add(price);
        this.add(title);
        this.add(addButton);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == addButton){
            System.out.println("tambah dummy");
            CartItem cartItem = new CartItem(judul, harga, cart);
            cart.add(cartItem);
            cart.revalidate();
            cart.repaint();
        }
    }
}

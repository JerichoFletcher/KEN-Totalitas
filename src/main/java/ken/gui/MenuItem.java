package ken.gui;

import ken.gui.tab.Kasir;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.util.List;

public class MenuItem extends JPanel implements ActionListener {
    private JButton addButton;
    private JPanel cart;
    private String judul;
    private int harga;
    private int id;

    public MenuItem(String judul, int harga, JPanel cart){
        super();
        this.judul = judul;
        this.harga = harga;
        this.cart = cart;
        this.id = id;
        ImageIcon image = new ImageIcon("./test.jpg");
        Image scaledImage = image.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        ImageIcon scaledImageIcon = new ImageIcon(scaledImage);

        JLabel title = new JLabel(judul);
        title.setIcon((Icon) scaledImageIcon);
        JLabel price = new JLabel("Rp" + harga + "000");
        addButton = new JButton("+");
        this.setLayout(null);
        this.setBackground(new Color(0xF2F2F2));
        this.setPreferredSize(new Dimension(720, 100));
        this.setMaximumSize(new Dimension(1000, 100)); // set maximum size to fixed value
        this.setMinimumSize(new Dimension(1000, 100));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        addButton.addActionListener(this);
        addButton.setFocusable(false);
        addButton.setContentAreaFilled(false);
        addButton.setFont(new Font("Poppins", Font.BOLD, 15));
        addButton.setBackground(new Color(0, 0, 0, 0));
        addButton.setForeground(new Color(0x395B64));
        addButton.setBorder(BorderFactory.createEmptyBorder());
        addButton.setBounds(640, 20, 50, 50);
        title.setBounds(10, 0, 200, 50);
        title.setForeground(new Color(0x395B64));
        title.setFont(new Font("Poppins", Font.BOLD, 20));
        price.setBounds(800, 0, 200, 50);
        price.setForeground(new Color(0x395B64));
        price.setFont(new Font("Poppins", Font.BOLD, 20));
        this.add(price);
        this.add(title);
        this.add(addButton);
    }


    public void actionPerformed(ActionEvent e) {
        boolean found = false;
        if (e.getSource() == addButton) {
            CartItem cartItem = new CartItem(id, judul, harga, cart);
            for (CartItem item : Kasir.listOfCartItem) {
                if (item.getID() == id) {
                    item.incrementCounter();
                    found = true;
                    break;
                }
            }
            if (!found) {
                Kasir.listOfCartItem.add(cartItem);
                cart.add(cartItem);
            }
            cart.revalidate();
            cart.repaint();
        }
    }
}

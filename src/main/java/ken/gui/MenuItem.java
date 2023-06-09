package ken.gui;

import ken.backend.Vars;
import ken.backend.kelas.bill.BillItem;
import ken.backend.settings.Settings;
import ken.gui.tab.Kasir;
import ken.util.UID;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.util.HashMap;
import java.util.List;
import java.io.File;
import java.util.Map;

public class MenuItem extends JPanel implements ActionListener {
    private JButton addButton;
    private JPanel cart;
    private String judul;
    private float harga;
    private int id;
    private int quantity;
    private float priceHolder;
    private JLabel counterLabel;
    private String imagePath;
    private Kasir kasir;
    private String kategori;


    public MenuItem(int id, String judul, float harga, int quantity, String path, float priceHolder, JPanel cart, Kasir kasir, String ikat){

        super();
        this.priceHolder = priceHolder;
        this.judul = judul;
        this.harga = harga;
        this.cart = cart;
        this.id = id;
        this.kasir = kasir;
        this.quantity = quantity;
        this.kategori = ikat;
        JLabel title = new JLabel(judul);
        this.harga = harga;
        imagePath = path;
        File imageFile = new File(imagePath);
        if (imageFile.exists()) {
            ImageIcon image = new ImageIcon(imagePath);
            Image scaledImage = image.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            ImageIcon scaledImageIcon = new ImageIcon(scaledImage);


            title.setIcon(scaledImageIcon);
        } else {
            System.out.println("Image file not found: " + imagePath);
            imagePath = "./asset/no-image-replacement.jpg";
            ImageIcon image = new ImageIcon(imagePath);
            Image scaledImage = image.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            ImageIcon scaledImageIcon = new ImageIcon(scaledImage);


            title.setIcon(scaledImageIcon);
        }


        JLabel price = new JLabel((String) Settings.get(UID.of(Vars.defaultNamespace, "settings", "currency")) + " " + harga);
        counterLabel = new JLabel(""+ quantity);
        addButton = new JButton("+");
        JLabel kat = new JLabel(kategori);
        this.setLayout(null);
        this.setBackground(new Color(0xF2F2F2));
        this.setPreferredSize(new Dimension(720, 100));
        this.setMaximumSize(new Dimension(1000, 100)); // set maximum size to fixed value
        this.setMinimumSize(new Dimension(1000, 100));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        addButton.addActionListener(this);
        addButton.setFocusable(false);
        addButton.setContentAreaFilled(false);
        addButton.setFont(new Font("Poppins", Font.BOLD, 25));
        addButton.setBackground(new Color(0, 0, 0, 0));
        addButton.setForeground(new Color(0x395B64));
        addButton.setBorder(BorderFactory.createEmptyBorder());
        addButton.setBounds(640, 20, 50, 50);
        title.setBounds(10, 0, 300, 100);
        title.setForeground(new Color(0x395B64));
        title.setFont(new Font("Poppins", Font.BOLD, 20));
        price.setBounds(400, 0, 200, 100);
        price.setForeground(new Color(0x395B64));
        price.setFont(new Font("Poppins", Font.BOLD, 20));
        counterLabel.setBounds(600, 0, 200, 100);
        counterLabel.setForeground(new Color(0x395B64));
        counterLabel.setFont(new Font("Poppins", Font.BOLD, 20));
        kat.setBounds(250, 0, 300, 100);
        kat.setForeground(new Color(0x395B64));
        kat.setFont(new Font("Poppins", Font.BOLD, 20));
        this.add(counterLabel);
        this.add(price);
        this.add(title);
        this.add(addButton);
        this.add(kat);
    }
    public int getQuantity(){
        return quantity;
    }

    public void addBackQuantity(){
        quantity++;
        counterLabel.setText(Integer.toString(quantity));
    }

    public void decrementQuantity(int quantityNow){
        if(quantity != 0 ){
            quantity--;
            counterLabel.setText(Integer.toString(quantity));
        }
    }



    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            boolean found = false;
            if(quantity != 0){
                quantity--;
                CartItem cartItem = new CartItem(id, judul, harga, cart, kasir, priceHolder, this);
                for (CartItem item : kasir.getCart()) {
                    System.out.println(item.getID());
                    if (item.getID() == id) {
                        item.incrementCounter();
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    kasir.addCartItem(cartItem);
                    cart.add(cartItem);
                }
                System.out.println(found);
                cart.revalidate();
                cart.repaint();
                counterLabel.setText(Integer.toString(quantity));
            }
            kasir.updatePriceText();
        }
    }
}

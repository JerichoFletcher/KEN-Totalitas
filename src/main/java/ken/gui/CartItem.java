package ken.gui;

import ken.gui.tab.Kasir;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CartItem extends JPanel implements ActionListener {
    private JButton addButton;
    private JButton minusButton;
    private JPanel cart;
    private String judul;
    private int harga;
    private int id;
    private int counter; // added counter variable
    private int priceHolder;
    private Kasir kasir;
    private MenuItem correspondingMI;
    private JLabel counterLabel; // added counter label

    public CartItem(int id, String judul, int harga, JPanel cart, Kasir kasir, int priceHolder, MenuItem menuItem){
        super();
        this.priceHolder = priceHolder;
        this.judul = judul;
        this.harga = harga;
        this.cart = cart;
        this.counter = 1; // initialize counter to 0
        this.id = id;
        this.kasir = kasir;
        this.correspondingMI = menuItem;
        JLabel title = new JLabel(judul);
        JLabel price = new JLabel("Rp" + harga);
        addButton = new JButton("+");
        minusButton = new JButton("-");
        this.setLayout(null);
        this.setBackground(new Color(0xF2F2F2));
        this.setPreferredSize(new Dimension(470,50));
        this.setMaximumSize(new Dimension(800,50)); // set maximum size to fixed value
        this.setMinimumSize(new Dimension(800,50));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        addButton.addActionListener(this);
        addButton.setFocusable(false);
        addButton.setContentAreaFilled( false );
        addButton.setFont(new Font("Poppins", Font.BOLD,15));
        addButton.setBackground(new Color(0, 0, 0, 0));
        addButton.setForeground(new Color(0x395B64));
        addButton.setBorder(BorderFactory.createEmptyBorder());
        addButton.setBounds(300,0,50,50);
        minusButton.addActionListener(this);
        minusButton.setFocusable(false);
        minusButton.setContentAreaFilled( false );
        minusButton.setFont(new Font("Poppins", Font.BOLD,15));
        minusButton.setBackground(new Color(0, 0, 0, 0));
        minusButton.setForeground(new Color(0x395B64));
        minusButton.setBorder(BorderFactory.createEmptyBorder());
        minusButton.setBounds(200,0,50,50);
        title.setBounds(10,0,180,50);
        title.setForeground(new Color(0x395B64));
        title.setFont(new Font("Poppins", Font.BOLD,20));
        price.setBounds(350,0,200,50);
        price.setForeground(new Color(0x395B64));
        price.setFont(new Font("Poppins", Font.BOLD,20));
        counterLabel = new JLabel(Integer.toString(counter)); // create counter label and set text to 0
        counterLabel.setBounds(275,0,50,50);
        counterLabel.setForeground(new Color(0x395B64));
        counterLabel.setFont(new Font("Poppins", Font.BOLD,20));
        this.add(minusButton);
        this.add(price);
        this.add(title);
        this.add(addButton);
        this.add(counterLabel); // add counter label to panel
    }

    public int getID(){
        return id;
    }

    public void incrementCounter(){
        counter++;
        counterLabel.setText(Integer.toString(counter));
    }

    public String getJudul(){
        return judul;
    }

    public int getCounter() {
        return this.counter;
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == addButton){
            if(correspondingMI.getQuantity() > 0){
                priceHolder = kasir.getPriceText();
                priceHolder += harga;
                kasir.setPriceText(priceHolder);
                counter++; // increment counter
                counterLabel.setText(Integer.toString(counter));
                correspondingMI.decrementQuantity(counter);// update counter label text
            }
        }
        if(e.getSource() == minusButton){
            correspondingMI.addBackQuantity();
            priceHolder = kasir.getPriceText();
            priceHolder -= harga;
            kasir.setPriceText(priceHolder);
            if(counter == 1) {
                // remove this panel from the parent panel
                cart.remove(this);
                kasir.eraseItemFromCart(this);
                // update the parent panel
                cart.revalidate();
                cart.repaint();
            } else {
                counter--;
                counterLabel.setText(Integer.toString(counter));
            }
        }

    }
}

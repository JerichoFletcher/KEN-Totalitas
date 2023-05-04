package ken.gui;

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
    private int counter; // added counter variable
    private JLabel counterLabel; // added counter label
    CartItem(String judul, int harga, JPanel cart){
        super();
        this.judul = judul;
        this.harga = harga;
        this.cart = cart;
        this.counter = 0; // initialize counter to 0
        JLabel title = new JLabel(judul);
        JLabel price = new JLabel("Rp" + harga +"000");
        addButton = new JButton("+");
        minusButton = new JButton("-");
        this.setLayout(null);
        this.setBackground(new Color(0xF2F2F2));
        this.setPreferredSize(new Dimension(700,50));
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
        addButton.setBounds(720,0,50,50);
        minusButton.addActionListener(this);
        minusButton.setFocusable(false);
        minusButton.setContentAreaFilled( false );
        minusButton.setFont(new Font("Poppins", Font.BOLD,15));
        minusButton.setBackground(new Color(0, 0, 0, 0));
        minusButton.setForeground(new Color(0x395B64));
        minusButton.setBorder(BorderFactory.createEmptyBorder());
        minusButton.setBounds(670,0,50,50);
        title.setBounds(10,0,200,50);
        title.setForeground(new Color(0x395B64));
        title.setFont(new Font("Poppins", Font.BOLD,20));
        price.setBounds(500,0,200,50);
        price.setForeground(new Color(0x395B64));
        price.setFont(new Font("Poppins", Font.BOLD,20));
        counterLabel = new JLabel(Integer.toString(counter)); // create counter label and set text to 0
        counterLabel.setBounds(630,0,50,50);
        counterLabel.setForeground(new Color(0x395B64));
        counterLabel.setFont(new Font("Poppins", Font.BOLD,20));
        this.add(minusButton);
        this.add(price);
        this.add(title);
        this.add(addButton);
        this.add(counterLabel); // add counter label to panel
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == addButton){
            counter++; // increment counter
            counterLabel.setText(Integer.toString(counter)); // update counter label text
        }
        if(e.getSource() == minusButton){
            if(counter == 0) {
                // remove this panel from the parent panel
                cart.remove(this);
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

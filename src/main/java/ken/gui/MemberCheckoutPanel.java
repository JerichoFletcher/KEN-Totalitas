package ken.gui;

import ken.backend.controller.holder.MemberHolder;
import ken.backend.controller.holder.VIPHolder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemberCheckoutPanel extends JPanel implements ActionListener {
    private JButton editButton;
    private int id;
    private String nama;
    private LayarCheckout co;
    private JTextField field;
    private JTextField pointfield;
    private String type;
    public MemberCheckoutPanel(String inama,int iid, LayarCheckout checkout, JTextField ifield, JTextField poin){
        super();
        this.nama = inama;
        this.id = iid;
        this.co = checkout;
        this.field = ifield;
        this.pointfield = poin;
//        this.type = tipe;
        JLabel title = new JLabel(nama);
        editButton = new JButton("CHOOSE");
        this.setLayout(null);
        this.setBackground(new Color(0xF2F2F2));
        this.setPreferredSize(new Dimension(300,50));
        this.setMaximumSize(new Dimension(300,50)); // set maximum size to fixed value
        this.setMinimumSize(new Dimension(300,50));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        editButton.addActionListener(this);
        editButton.setFocusable(false);
        editButton.setContentAreaFilled( false );
        editButton.setFont(new Font("Poppins", Font.BOLD,15));
        editButton.setBackground(new Color(0, 0, 0, 0));
        editButton.setForeground(new Color(0x395B64));
        editButton.setBorder(BorderFactory.createEmptyBorder());
        editButton.setBounds(180,0,100,50);
        title.setBounds(10,0,200,50);
        title.setForeground(new Color(0x395B64));
        title.setFont(new Font("Poppins", Font.BOLD,15));
        this.add(title);
        this.add(editButton);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == editButton){
            System.out.println("Chose Member with ID: " + id);
            co.setId(id);
            field.setText(nama);
            pointfield.setVisible(true);
            float points = 0;
            try {
                points = MemberHolder.instance().getMemberById(id).getPoints();
            } catch (NullPointerException ex) {
                points = VIPHolder.instance().getVIPById(id).getPoints();
            }

//            System.out.println(points);
            pointfield.setText(Float.toString(points));
        }
    }
}

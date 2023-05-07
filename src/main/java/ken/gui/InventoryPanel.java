package ken.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ken.gui.tab.Kasir;

public class InventoryPanel extends JPanel implements ActionListener {
    private JButton editButton;
    private int id;
    private String judul;
    private int harga;
    private int hargaBeli;
    private int quantity;
    private String path;
    private String kategori;

    public InventoryPanel(int iid, String ijudul, int iharga,int ihargaBeli, int iquantity, String ipath, String ikategori){
        super();
        this.id = iid;
        this.judul = ijudul;
        this.harga = iharga;
        this.hargaBeli= ihargaBeli;
        this.quantity = iquantity;
        this.path = ipath;
        this.kategori=ikategori;
        JLabel title = new JLabel(judul);
        editButton = new JButton("EDIT");
        this.setLayout(null);
        this.setBackground(new Color(0xF2F2F2));
        this.setPreferredSize(new Dimension(1000,50));
        this.setMaximumSize(new Dimension(1280,100)); // set maximum size to fixed value
        this.setMinimumSize(new Dimension(1280,100));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        editButton.addActionListener(this);
        editButton.setFocusable(false);
        editButton.setContentAreaFilled( false );
        editButton.setFont(new Font("Poppins", Font.BOLD,20));
        editButton.setBackground(new Color(0, 0, 0, 0));
        editButton.setForeground(new Color(0x395B64));
        editButton.setBorder(BorderFactory.createEmptyBorder());
        editButton.setBounds(1020,0,100,50);
        title.setBounds(10,0,200,50);
        title.setForeground(new Color(0x395B64));
        title.setFont(new Font("Poppins", Font.BOLD,20));
        this.add(title);
        this.add(editButton);
    }


    public void actionPerformed(ActionEvent e){
        if(e.getSource() == editButton){
            System.out.println("edit dummy");
            EditInventoryItem layarEI = new EditInventoryItem(id,judul,harga,hargaBeli,quantity,kategori);
            Tabs.tabs.addCustomTab("Edit Inventory", layarEI, Tabs.tabCount);
            Tabs.tabs.setSelectedComponent(layarEI);
        }
    }
}

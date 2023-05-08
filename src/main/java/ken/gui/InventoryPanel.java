package ken.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import ken.backend.Vars;
import ken.backend.settings.Settings;
import ken.gui.tab.Kasir;
import ken.util.UID;

public class InventoryPanel extends JPanel {
    private JButton editButton;
    private int id;
    private String judul;
    private float harga;
    private float hargaBeli;
    private int quantity;
    private String path;
    private String kategori;

    public InventoryPanel(int iid, String ijudul, float iharga,float ihargaBeli, int iquantity, String ipath, String ikategori){
        super();
        this.id = iid;
        this.judul = ijudul;
        this.harga = iharga;
        this.hargaBeli= ihargaBeli;
        this.quantity = iquantity;
        this.path = ipath;
        if (path.isEmpty()) {
            path = "./asset/no-image-replacement.jpg";
        }
        this.kategori=ikategori;
        JLabel title = new JLabel(judul);
        JLabel price = new JLabel((String) Settings.get(UID.of(Vars.defaultNamespace, "settings", "currency")) + " " + harga);
        JLabel katLabel = new JLabel(kategori);
        JLabel stokLabel = new JLabel(quantity + " x");
        editButton = new JButton("EDIT");
        this.setLayout(null);
        this.setBackground(new Color(0xF2F2F2));
        this.setPreferredSize(new Dimension(1000,100));
        this.setMaximumSize(new Dimension(1280,100)); // set maximum size to fixed value
        this.setMinimumSize(new Dimension(1280,100));
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        editButton.addActionListener(event -> {
            System.out.println("edit dummy");
            EditInventoryItem layarEI = new EditInventoryItem(id,judul,harga,hargaBeli,quantity,kategori,path);
            Tabs.tabs.addCustomTab("Edit Inventory", layarEI, Tabs.tabCount);
            Tabs.tabs.setSelectedComponent(layarEI);
        });
        editButton.setFocusable(false);
        editButton.setContentAreaFilled( false );
        editButton.setFont(new Font("Poppins", Font.BOLD,20));
        editButton.setBackground(new Color(0, 0, 0, 0));
        editButton.setForeground(new Color(0x395B64));
        editButton.setBorder(BorderFactory.createEmptyBorder());
        editButton.setBounds(1020,25,100,50);
        title.setBounds(10, 0, 300, 100);
        title.setForeground(new Color(0x395B64));
        title.setFont(new Font("Poppins", Font.BOLD, 20));
        katLabel.setBounds(600, 0, 300, 100);
        katLabel.setForeground(new Color(0x395B64));
        katLabel.setFont(new Font("Poppins", Font.BOLD, 20));
        price.setBounds(800, 0, 300, 100);
        price.setForeground(new Color(0x395B64));
        price.setFont(new Font("Poppins", Font.BOLD, 20));
        stokLabel.setBounds(400, 0, 300, 100);
        stokLabel.setForeground(new Color(0x395B64));
        stokLabel.setFont(new Font("Poppins", Font.BOLD, 20));
        File imageFile = new File(path);
        if (imageFile.exists()) {
            ImageIcon image = new ImageIcon(path);
            Image scaledImage = image.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            ImageIcon scaledImageIcon = new ImageIcon(scaledImage);


            title.setIcon(scaledImageIcon);
        } else {
            System.out.println("Image file not found: " + path);
            path = "./asset/no-image-replacement.jpg";
            ImageIcon image = new ImageIcon(path);
            Image scaledImage = image.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
            ImageIcon scaledImageIcon = new ImageIcon(scaledImage);


            title.setIcon(scaledImageIcon);

        }
        this.add(katLabel);
        this.add(title);
        this.add(price);
        this.add(editButton);
        this.add(stokLabel);
    }
}

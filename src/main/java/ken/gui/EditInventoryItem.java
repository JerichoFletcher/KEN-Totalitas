package ken.gui;

import ken.backend.controller.Controller;
import ken.backend.controller.holder.InventoryHolder;
import ken.backend.kelas.barang.Barang;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.bind.JAXBException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.net.URISyntaxException;

public class EditInventoryItem extends JPanel {
    private JPanel panelEdit;
    private JButton editButton;
    private JButton deleteButton;
    private JTextField textField;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton imageButton;
    private JLabel imagelinkLabel;
    private String imgurl;

    private int id;
    private String judul;
    private float harga;
    private float hargaBeli;
    private int quantity;
    private String path;
    private String kategori;
    public EditInventoryItem(int iid, String ijudul, float iharga,float ihargaBeli, int iquantity, String ikategori, String ipath){
        panelEdit = new JPanel();
        this.setSize(500,500);
        this.setBackground(new Color(0x2C3333));
        this.setLayout(null);
        this.id = iid;
        this.judul = ijudul;
        this.harga = iharga;
        this.hargaBeli= ihargaBeli;
        this.quantity = iquantity;
        this.path = ipath;
        this.kategori = ikategori;

        // Calculate the position of the center panel


        makePanelEdit();
        this.add(panelEdit);
        this.setBounds(0,0,500,500);
    }

    public void makePanelEdit(){
        imgurl = "";
        panelEdit = new JPanel();
        panelEdit.setSize(1220,840);
        panelEdit.setBackground(new Color(0xE7F6F2));
        panelEdit.setBounds(0, 0, 1280, 580);
        panelEdit.setLayout(null);
        JLabel label = new JLabel("Edit Item");
        label.setFont(new Font("Poppins", Font.BOLD,40));
        label.setForeground(new Color(0x395B64));
        panelEdit.add(label);
        label.setBounds(500,30,500,100);
        textField = new JTextField();
        textField.setBounds(50,130,550,50);
        textField.setText(judul);
        textField.setFont(new Font("Poppins", Font.BOLD,18));
        textField.setForeground(new Color(0x395B64));
        textField.setBackground(new Color(0xD9D9D9));
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().trim().equals(judul)) {
                    textField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().trim().equals("")) {
                    textField.setText(judul);
                }
            }
        });
        textField2 = new JTextField();
        textField2.setBounds(50,190,550,50);
        textField2.setText(Integer.toString(quantity));
        textField2.setFont(new Font("Poppins", Font.BOLD,18));
        textField2.setForeground(new Color(0x395B64));
        textField2.setBackground(new Color(0xD9D9D9));
        textField2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField2.getText().trim().equals(Integer.toString(quantity))) {
                    textField2.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField2.getText().trim().equals("")) {
                    textField2.setText(Integer.toString(quantity));
                }
            }
        });

        textField3 = new JTextField();
        textField3.setBounds(50,250,550,50);
        textField3.setText(Float.toString(harga));
        textField3.setFont(new Font("Poppins", Font.BOLD,18));
        textField3.setForeground(new Color(0x395B64));
        textField3.setBackground(new Color(0xD9D9D9));
        textField3.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField3.getText().trim().equals(Float.toString(harga))) {
                    textField3.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField3.getText().trim().equals("")) {
                    textField3.setText(Float.toString(harga));
                }
            }
        });

        textField4 = new JTextField();
        textField4.setBounds(650,130,550,50);
        textField4.setText(Float.toString(hargaBeli));
        textField4.setFont(new Font("Poppins", Font.BOLD,18));
        textField4.setForeground(new Color(0x395B64));
        textField4.setBackground(new Color(0xD9D9D9));
        textField4.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField4.getText().trim().equals(Float.toString(hargaBeli))) {
                    textField4.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField4.getText().trim().equals("")) {
                    textField4.setText(Float.toString(hargaBeli));
                }
            }
        });

        textField5 = new JTextField();
        textField5.setBounds(650,190,550,50);
        textField5.setText(kategori);
        textField5.setFont(new Font("Poppins", Font.BOLD,18));
        textField5.setForeground(new Color(0x395B64));
        textField5.setBackground(new Color(0xD9D9D9));
        textField5.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField5.getText().trim().equals(kategori)) {
                    textField5.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField5.getText().trim().equals("")) {
                    textField5.setText(kategori);
                }
            }
        });

        editButton = new JButton();
        editButton.addActionListener(event -> {
            String editName = textField.getText();
            String editStok = textField2.getText();
            String editHarga = textField3.getText();
            String editHargaBeli = textField4.getText();
            String editKategori = textField5.getText();

            if (editName.length() == 0) {
                editName = judul;
            }
            if (editStok.length() == 0) {
                editStok = Integer.toString(quantity);
            }
            if (editHarga.length() == 0) {
                editHarga = Float.toString(harga);
            }
            if (editHargaBeli.length() == 0) {
                editHargaBeli = Float.toString(hargaBeli);
            }
            if (editKategori.length() == 0) {
                editKategori= kategori;
            }
            if (imgurl.length() == 0) {
                imgurl = path;
            }

            System.out.println("Editing Item...");
            System.out.println("Nama : " + textField.getText());
            System.out.println("Stok : " + textField2.getText());
            System.out.println("Harga : " + textField3.getText());
            System.out.println("Harga Beli : " + textField4.getText());
            System.out.println("Kategori : " + textField5.getText());
            System.out.println("Image URL : " + imgurl);
            try {
                Controller.instance().fetchData(InventoryHolder.instance(), "barang");
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            Barang barang = InventoryHolder.instance().getBarangById(id);
            barang.setNamaBarang(editName);
            barang.setStok(Integer.parseInt(editStok));
            barang.setHargaBarang(Float.parseFloat(editHarga));
            barang.setHargaBeliBarang(Float.parseFloat(editHargaBeli));
            barang.setKategori(editKategori);
            barang.setGambar(imgurl);
            try {
                Controller.instance().writeData(InventoryHolder.instance(), "barang");
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        editButton.setFocusable(false);
        editButton.setContentAreaFilled( false );
        editButton.setText("SAVE");
        editButton.setFont(new Font("Poppins", Font.BOLD,40));
        editButton.setBackground(new Color(0, 0, 0, 0));
        editButton.setForeground(new Color(0x395B64));
        editButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        editButton.setBounds(950,440,200,90);

        deleteButton = new JButton();
        deleteButton.addActionListener(event -> {
            try {
                Controller.instance().fetchData(InventoryHolder.instance(), "barang");
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
            InventoryHolder.instance().removeBarang(id);
            try {
                Controller.instance().writeData(InventoryHolder.instance(), "barang");
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        deleteButton.setFocusable(false);
        deleteButton.setContentAreaFilled( false );
        deleteButton.setText("DELETE");
        deleteButton.setFont(new Font("Poppins", Font.BOLD,40));
        deleteButton.setBackground(new Color(0, 0, 0, 0));
        deleteButton.setForeground(new Color(0x395B64));
        deleteButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        deleteButton.setBounds(100,440,200,90);

        imageButton = new JButton("Choose Image");
        imageButton.setBounds(650, 250,  550, 50);
        imageButton.setBackground(new Color(0xD9D9D9));
        imageButton.setForeground(Color.black);
        imageButton.setFont(new Font("Poppins", Font.BOLD,18));
        imageButton.addActionListener(event -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            FileNameExtensionFilter jpgFilter = new FileNameExtensionFilter("JPG Files", "jpg");
            fileChooser.setFileFilter(jpgFilter); // Set the JPG file filter
            int returnValue = fileChooser.showOpenDialog(this);

            if (returnValue == JFileChooser.APPROVE_OPTION) {
                // File selected by the user
                imgurl = fileChooser.getSelectedFile().getPath();
                // Perform any necessary operations with the selected file
                System.out.println("Selected file: " + imgurl);
                imagelinkLabel.setText("Selected file: " + imgurl);
            }
        });
        imageButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        imagelinkLabel= new JLabel("");
        imagelinkLabel.setFont(new Font("Poppins", Font.BOLD,18));
        imagelinkLabel.setForeground(new Color(0x395B64));
        imagelinkLabel.setBounds(650,310,550,50);

        panelEdit.add(textField);
        panelEdit.add(textField2);
        panelEdit.add(textField3);
        panelEdit.add(textField4);
        panelEdit.add(textField5);
        panelEdit.add(editButton);
        panelEdit.add(deleteButton);
        panelEdit.add(imageButton);
        panelEdit.add(imagelinkLabel);

    }
}

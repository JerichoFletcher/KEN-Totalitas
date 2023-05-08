package ken.gui;

import ken.backend.controller.Controller;
import ken.backend.controller.holder.CustomerHolder;
import ken.backend.controller.holder.InventoryHolder;
import ken.backend.controller.holder.MemberHolder;
import ken.backend.controller.holder.VIPHolder;
import ken.backend.kelas.anggota.Member;
import ken.backend.kelas.anggota.VIP;
import ken.backend.kelas.barang.Barang;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.net.URISyntaxException;

public class AddItem extends JPanel implements ActionListener{
    private JPanel panelEdit;
    private JButton editButton;
    private JTextField textField;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JButton imageButton;
    private JLabel imagelinkLabel;
    private String imgurl;

    public AddItem(){
        panelEdit = new JPanel();
        this.setSize(500,500);
        this.setBackground(new Color(0x2C3333));
        this.setLayout(null);

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
        JLabel label = new JLabel("Add Item");
        label.setFont(new Font("Poppins", Font.BOLD,40));
        label.setForeground(new Color(0x395B64));
        panelEdit.add(label);
        label.setBounds(500,30,500,100);
        textField = new JTextField();
        textField.setBounds(50,130,550,50);
        textField.setText("Nama Barang");
        textField.setFont(new Font("Poppins", Font.BOLD,18));
        textField.setForeground(new Color(0x395B64));
        textField.setBackground(new Color(0xD9D9D9));
        textField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().trim().equals("Nama Barang")) {
                    textField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().trim().equals("")) {
                    textField.setText("Nama Barang");
                }
            }
        });
        textField2 = new JTextField();
        textField2.setBounds(50,190,550,50);
        textField2.setText("Stok");
        textField2.setFont(new Font("Poppins", Font.BOLD,18));
        textField2.setForeground(new Color(0x395B64));
        textField2.setBackground(new Color(0xD9D9D9));
        textField2.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField2.getText().trim().equals("Stok")) {
                    textField2.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField2.getText().trim().equals("")) {
                    textField2.setText("Stok");
                }
            }
        });

        textField3 = new JTextField();
        textField3.setBounds(50,250,550,50);
        textField3.setText("Harga");
        textField3.setFont(new Font("Poppins", Font.BOLD,18));
        textField3.setForeground(new Color(0x395B64));
        textField3.setBackground(new Color(0xD9D9D9));
        textField3.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField3.getText().trim().equals("Harga")) {
                    textField3.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField3.getText().trim().equals("")) {
                    textField3.setText("Harga");
                }
            }
        });

        textField4 = new JTextField();
        textField4.setBounds(650,130,550,50);
        textField4.setText("Harga Beli");
        textField4.setFont(new Font("Poppins", Font.BOLD,18));
        textField4.setForeground(new Color(0x395B64));
        textField4.setBackground(new Color(0xD9D9D9));
        textField4.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField4.getText().trim().equals("Harga Beli")) {
                    textField4.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField4.getText().trim().equals("")) {
                    textField4.setText("Harga Beli");
                }
            }
        });

        textField5 = new JTextField();
        textField5.setBounds(650,190,550,50);
        textField5.setText("Kategori");
        textField5.setFont(new Font("Poppins", Font.BOLD,18));
        textField5.setForeground(new Color(0x395B64));
        textField5.setBackground(new Color(0xD9D9D9));
        textField5.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField5.getText().trim().equals("Kategori")) {
                    textField5.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (textField5.getText().trim().equals("")) {
                    textField5.setText("Kategori");
                }
            }
        });

        editButton = new JButton();
        editButton.addActionListener(this);
        editButton.setFocusable(false);
        editButton.setContentAreaFilled( false );
        editButton.setText("SAVE");
        editButton.setFont(new Font("Poppins", Font.BOLD,40));
        editButton.setBackground(new Color(0, 0, 0, 0));
        editButton.setForeground(new Color(0x395B64));
        editButton.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
        editButton.setBounds(950,440,200,90);


        imageButton = new JButton("Choose Image");
        imageButton.setBounds(650, 250,  550, 50);
        imageButton.setBackground(new Color(0xD9D9D9));
        imageButton.setForeground(Color.black);
        imageButton.setFont(new Font("Poppins", Font.BOLD,18));
        imageButton.addActionListener(this);
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
        panelEdit.add(imageButton);
        panelEdit.add(imagelinkLabel);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == editButton) {
            try {
                Controller.instance().fetchData(InventoryHolder.instance(), "barang");
                String addName = textField.getText().trim();
                String addStok = textField2.getText().trim();
                String addHarga = textField3.getText().trim();
                String addHargaBeli = textField4.getText().trim();
                String addKategori = textField5.getText().trim();
                if (!addName.equals("Nama Barang") && addName.length() != 0 && !addStok.equals("Stok") && addStok.length() != 0 && !addHarga.equals("Harga") && addHarga.length() != 0 && !addHargaBeli.equals("Harga Beli") && addHargaBeli.length() != 0 && !addKategori.equals("Kategori") && addKategori.length() != 0) {
                    System.out.println("Nama : " + addName);
                    System.out.println("Stok : " + addStok);
                    System.out.println("Harga : " + addHarga);
                    System.out.println("Harga Beli : " + addHargaBeli);
                    System.out.println("Kategori : " + addKategori);
                    System.out.println("Image URL : " + imgurl);
                    Barang newBarang = new Barang(addName, Integer.parseInt(addStok), Float.parseFloat(addHarga), Float.parseFloat(addHargaBeli), addKategori, imgurl);
                    InventoryHolder.instance().addBarang(newBarang);
                    Controller.instance().writeData(InventoryHolder.instance(), "barang");
//                    Controller.instance().writeData(MemberHolder.instance() , "member");
//                    Controller.instance().writeData(VIPHolder.instance() , "vip");
                }
            } catch (URISyntaxException | IOException ex) {
                throw new RuntimeException(ex);
            }
        } else if (e.getSource() == imageButton) {
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
        }
    }
}

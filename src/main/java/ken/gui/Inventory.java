package ken.gui;

import javax.swing.*;
import java.awt.*;

public class Inventory extends JPanel {
    private JPanel inventory;
    Inventory(){
        super();
        this.setSize(500,500);
        this.setBackground(new Color(0x2C3333));
        this.setLayout(null);
        makePanelInventory();
        this.setBounds(0,0,500,500);
    }

    public void makePanelInventory(){
        inventory = new JPanel();
        JPanel headerInventory = new JPanel();
        headerInventory.setLayout(null);
        headerInventory.setBackground(new Color(0xD9D9D9));
        JLabel headerText = new JLabel("Inventory List");
        headerText.setFont(new Font("Poppins", Font.BOLD,15));
        headerText.setForeground(Color.black);
        headerInventory.add(headerText);
        headerText.setBounds(600,0,1280,50);
        headerInventory.setBounds(0,0,1280, 50);
        this.add(headerInventory);
        inventory.setBackground(new Color(0xFFFFFF));
        inventory.setLayout(new BoxLayout(inventory, BoxLayout.Y_AXIS));
        for (int i = 1; i <= 20; i++) {
            InventoryPanel invPanel = new InventoryPanel("item " + i);
            inventory.add(invPanel);
        }
        JScrollPane scrollPane = new JScrollPane(inventory);
        scrollPane.setBounds(0, 50, 1260, 520);
        this.add(scrollPane);
    }

}

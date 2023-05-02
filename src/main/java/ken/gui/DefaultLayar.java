package ken.gui;

import javax.swing.*;
import java.awt.*;

public class DefaultLayar extends JFrame {
    DefaultLayar(){
        super();
        this.setSize(1960, 1280);
        this.getContentPane().setBackground(new Color(0x2C3333));
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        Menu menu = new Menu();
        menu.setBounds(20,10,300,50);
        menu.setBackground(Color.red);
        menu.setPreferredSize(new Dimension(300, 50));
        this.add(menu);
    }
}

package ken.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Menu extends JLabel {
    private JLabel menuLabel;
    private JPopupMenu menuPop;
    Menu() {
        super("MENU");
        this.setForeground(new Color(0xFFFFFF));
        this.setFont(new Font("Poppins", Font.BOLD,20));
        menuPop = new JPopupMenu();
        JMenuItem option1 = new JMenuItem("Option 1");
        menuPop.add(option1);

        JMenuItem option2 = new JMenuItem("Option 2");
        menuPop.add(option2);
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                menuPop.show(Menu.this, 0, Menu.this.getHeight());
            }
        });

    }
}
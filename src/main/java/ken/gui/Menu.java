package ken.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JLabel {
    private JLabel menuLabel;
    private JPopupMenu menuPop;
    private String[] menuItems;
    private Tabs tabs;
    private JPanel[] panelList;
    private Class<? extends JPanel>[] contentClasses;
    Menu(Tabs tabs) {
        super("MENU");
        this.setForeground(new Color(0xFFFFFF));
        this.setFont(new Font("Poppins", Font.BOLD,20));
        this.tabs = tabs;
        menuItems = new String[]{"Daftar Member", "Edit Member", "Kasir"};
        menuPop = new JPopupMenu();
        for (int i = 0; i <= menuItems.length-1; i++) {
            final int index = i;
            JMenuItem menuItem = new JMenuItem(menuItems[i]);
            menuPop.add(menuItem);
            menuItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    tabs.addTab(menuItems[index], new JLabel("Content for " + menuItems[index]));
                }
            });
        }

//        menuPop = new JPopupMenu();
//        JMenuItem option1 = new JMenuItem("Option 1");
//        menuPop.add(option1);
//
//        JMenuItem option2 = new JMenuItem("Option 2");
//        menuPop.add(option2);
        this.setVisible(true);
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                menuPop.show(Menu.this, 0, Menu.this.getHeight());
            }
        });



    }
}
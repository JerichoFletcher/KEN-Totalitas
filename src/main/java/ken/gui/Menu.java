package ken.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

public class Menu extends JLabel {
    private JLabel menuLabel;
    private JPopupMenu menuPop;
    private String[] menuItems;
    private Tabs tabs;
    private JPanel[] panelList;
    private Class<? extends JPanel>[] contentClasses;
    Menu(Tabs tabs, Class<? extends JPanel>[] contentClasses) {
        super("MENU");
        this.setForeground(new Color(0xFFFFFF));
        this.setFont(new Font("Poppins", Font.BOLD,20));
        this.tabs = tabs;
        this.contentClasses = contentClasses;
        menuItems = new String[]{"Daftar Member", "Edit Member", "Kasir"};
        menuPop = new JPopupMenu();
        for (int i = 0; i <= menuItems.length-1; i++) {
            final int index = i;
            JMenuItem menuItem = new JMenuItem(menuItems[i]);
            menuPop.add(menuItem);
            menuItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        Class<? extends JPanel> contentClass = contentClasses[index];
                        JPanel contentPanel = contentClass.getDeclaredConstructor().newInstance();
                        Tabs.tabs.addCustomTab(menuItems[index], contentPanel, tabs.getTabCount());
                        Tabs.tabCount = tabs.getTabCount();
                    } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException ex) {
                        ex.printStackTrace();
                    }
                }
            });
        }

        this.setVisible(true);
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                menuPop.show(Menu.this, 0, Menu.this.getHeight());
            }
        });
    }
}
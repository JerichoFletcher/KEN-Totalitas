package ken.gui;

import ken.gui.tab.KENTab;
import ken.util.UID;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class Menu extends JLabel {
    private JLabel menuLabel;
    private JPopupMenu menuPop;
    private String[] menuItems;
    private Tabs tabs;
    private JPanel[] panelList;
    private Class<? extends JPanel>[] contentClasses;
    private Map<UID, Class<? extends KENTab>> panels;

    Menu(Tabs tabs) {
        super("MENU");
        this.setForeground(new Color(0xFFFFFF));
        this.setFont(new Font("Poppins", Font.BOLD, 20));
        this.tabs = tabs;
        this.panels = TabManager.getPanels();
        // this.contentClasses = contentClasses;
        menuPop = new JPopupMenu();

        this.setVisible(true);
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                menuPop.removeAll();
                for (Map.Entry<UID, Class<? extends KENTab>> entry : panels.entrySet()) {
                    Class<? extends KENTab> clazz = entry.getValue();
                    try {
                        String judulMenuItem = (String) clazz.getMethod("tabName").invoke(clazz.getConstructor().newInstance());
                        JMenuItem menuItem = new JMenuItem(judulMenuItem);
                        menuPop.add(menuItem);
                        System.out.printf("Added item %s -> %s to menu%n", judulMenuItem, entry.getKey());
                        menuItem.addActionListener(event -> {
                            try {
                                Class<? extends JPanel> contentClass = entry.getValue();
                                JPanel contentPanel = contentClass.getDeclaredConstructor().newInstance();
                                Tabs.tabs.addCustomTab(judulMenuItem, contentPanel, tabs.getTabCount());
                                Tabs.tabCount = tabs.getTabCount();
                                Tabs.tabs.setSelectedComponent(contentPanel);
                            } catch (InstantiationException | IllegalAccessException | NoSuchMethodException
                                | InvocationTargetException ex) {
                                ex.printStackTrace();
                            }
                        });
                    } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException
                        | InstantiationException ex) {
                        ex.printStackTrace();
                    }
                }
                menuPop.show(Menu.this, 0, Menu.this.getHeight());
            }
        });
    }
}
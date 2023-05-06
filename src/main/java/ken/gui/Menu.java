package ken.gui;

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
    private Map<String, Class<? extends JPanel>> panels;
    Menu(Tabs tabs, Panels panels) {
        super("MENU");
        this.setForeground(new Color(0xFFFFFF));
        this.setFont(new Font("Poppins", Font.BOLD,20));
        this.tabs = tabs;
        this.panels = panels.getPanels();
        this.contentClasses = contentClasses;
        menuItems = new String[]{"Kasir", "Members", "Inventory", "History", "Setting"};
        menuPop = new JPopupMenu();
<<<<<<< Updated upstream
        for (Map.Entry<String, Class<? extends JPanel>> entry : this.panels.entrySet()) {
            String judulMenuItem = entry.getKey(); // gets the String key
            Class<? extends JPanel> value = entry.getValue(); // gets the Class<? extends JPanel> value
            JMenuItem menuItem = new JMenuItem(judulMenuItem);
            menuPop.add(menuItem);
            menuItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        Class<? extends JPanel> contentClass = entry.getValue();
                        JPanel contentPanel = contentClass.getDeclaredConstructor().newInstance();
                        Tabs.tabs.addCustomTab(judulMenuItem, contentPanel, tabs.getTabCount());
                        Tabs.tabCount = tabs.getTabCount();
                        Tabs.tabs.setSelectedComponent(contentPanel);
                    } catch (InstantiationException | IllegalAccessException | NoSuchMethodException |
                             InvocationTargetException ex) {
                        ex.printStackTrace();
                    }
                }
            });
=======
        for (Map.Entry<String, Class<? extends KENTab>> entry : this.panels.entrySet()) {
            Class<? extends KENTab> clazz = entry.getValue();
            try {
                String judulMenuItem = (String) clazz.getMethod("tabName").invoke(clazz.getConstructor().newInstance());
//                String judulMenuItem = ((KENTab)contentPanel).tabName(); // gets the String key
//                Class<? extends JPanel> value = entry.getValue(); // gets the Class<? extends JPanel> value
                JMenuItem menuItem = new JMenuItem(judulMenuItem);
                menuPop.add(menuItem);
                menuItem.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            Class<? extends JPanel> contentClass = entry.getValue();
                            JPanel contentPanel = contentClass.getDeclaredConstructor().newInstance();
                            Tabs.tabs.addCustomTab(judulMenuItem, contentPanel, tabs.getTabCount());
                            Tabs.tabCount = tabs.getTabCount();
                            Tabs.tabs.setSelectedComponent(contentPanel);
                        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException |
                                 InvocationTargetException ex) {
                            ex.printStackTrace();
                        }
                    }
                });
            }catch(NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException ex){
                ex.printStackTrace();
            }
>>>>>>> Stashed changes
        }

        this.setVisible(true);
        this.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                menuPop.show(Menu.this, 0, Menu.this.getHeight());
            }
        });
    }
}
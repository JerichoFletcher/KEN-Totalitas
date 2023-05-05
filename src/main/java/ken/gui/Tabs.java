package ken.gui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tabs extends JTabbedPane {
    public static Tabs tabs;
    public static int tabCount;
    public Tabs() {
        super();
        tabs = this;
        tabCount = 0;
        this.setVisible(true);
        this.setBackground(new Color(0x395B64));
        this.setFocusable(false);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.addCustomTab("Members", new Members(), Tabs.tabCount);
        this.setUI(new BasicTabbedPaneUI() {
            @Override
            protected void paintContentBorder(Graphics g, int tabPlacement, int selectedIndex) {
                // Set the color for the content border
                g.setColor(new Color(0x395B64));

                g.fillRect(0, 0, getWidth(), getHeight());
            }

            @Override
            protected Insets getContentBorderInsets(int tabPlacement) {
                // Set the insets for the content border
                return new Insets(5, 5, 5, 5);
            }

        });
    }

    public void addCustomTab(String title, Component component, int index){
        this.addTab(null, component);
        this.setTabComponentAt(index, new ButtonTabComponent(this, title));
        Tabs.tabCount = this.getTabCount();
    }
}

class ButtonTabComponent extends JPanel {
    private final JTabbedPane pane;

    public ButtonTabComponent(final JTabbedPane pane, String title) {
        super(new FlowLayout(FlowLayout.LEFT, 0, 0));
        if (pane == null) {
            throw new NullPointerException("TabbedPane is null");
        }
        this.pane = pane;
        this.setOpaque(false);
        this.setFocusable(false);

        JLabel label = new JLabel(title);

        label.setOpaque(false);
        label.setForeground(Color.white);
        label.setFont(new Font("Poppins", Font.BOLD, 20));

        JButton button = new JButton("  x");
        button.setOpaque(false);
        button.setBorder(null);
        button.setBackground(new Color(0x395B64));
        button.setFont(new Font("Poppins", Font.BOLD,20));
        button.setForeground(Color.white);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i = pane.indexOfTabComponent(ButtonTabComponent.this);
                if (i != -1) {
                    pane.remove(i);
                    Tabs.tabCount = pane.getTabCount();
                }
            }
        });

        this.add(label);
        this.add(button);
    }
}




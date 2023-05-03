package ken.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tabs extends JTabbedPane {
    public Tabs() {
        super();
        this.setVisible(true);
    }

    public void addCustomTab(String title, Component component, int index){
        this.addTab(title, component);
        this.setTabComponentAt(index, new ButtonTabComponent(this));
    }
}

class ButtonTabComponent extends JPanel {
    private final JTabbedPane pane;

    public ButtonTabComponent(final JTabbedPane pane) {
        super(new FlowLayout(FlowLayout.LEFT, 0, 0));
        if (pane == null) {
            throw new NullPointerException("TabbedPane is null");
        }
        this.pane = pane;
        this.setOpaque(false);

        JLabel label = new JLabel() {
            public String getText() {
                int i = pane.indexOfTabComponent(ButtonTabComponent.this);
                if (i != -1) {
                    return pane.getTitleAt(i);
                }
                return null;
            }
        };

        JButton button = new JButton("x");
        button.setOpaque(false);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int i = pane.indexOfTabComponent(ButtonTabComponent.this);
                if (i != -1) {
                    pane.remove(i);
                }
            }
        });

        this.add(label);
        this.add(button);
    }
}
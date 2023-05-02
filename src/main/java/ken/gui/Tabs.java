package ken.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tabs extends JTabbedPane {
    public Tabs() {
        super();
        this.addTab("Tab 1",new JLabel("Content for Tab 2") );
        this.addTab("Tab 2", new JLabel("Content for Tab 2"));
        this.setVisible(true);
    }
}

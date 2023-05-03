package ken.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tabs extends JTabbedPane {
    public Tabs() {
        super();
        DaftarMember layarDM = new DaftarMember();
//        this.addTab("Tab 1", layarDM );
//        this.addTab("Tab 2", new JLabel("Content for Tab 2"));
        this.setVisible(true);
    }
}

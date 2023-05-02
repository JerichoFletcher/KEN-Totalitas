package ken.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main{

    public static void main(String[] args) {
        DefaultLayar defLay = new DefaultLayar();
        Tabs tabs = new Tabs();
        tabs.setBounds(0, 70, defLay.getWidth(), defLay.getHeight() - 70); // set the bounds
        defLay.add(tabs);
    }
}

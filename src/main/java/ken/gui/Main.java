package ken.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main{
    public static void main(String[] args) {
        DefaultLayar defLay = new DefaultLayar();
        Class<? extends JPanel>[] contentClasses = new Class[] {EditMember.class, Kasir.class, Members.class};
        Tabs tabs = new Tabs();
        Menu menu = new Menu(tabs, contentClasses);
        defLay.add(menu);
        menu.setBounds(20,10,300,50);
        menu.setPreferredSize(new Dimension(300, 50));
        defLay.add(tabs);
        tabs.setBounds(0, 70, defLay.getWidth(), defLay.getHeight() - 70); // set the bounds
    }


}

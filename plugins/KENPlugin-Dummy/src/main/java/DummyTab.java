import ken.backend.plugin.CallOnLoad;
import ken.gui.TabManager;
import ken.gui.tab.KENTab;
import ken.util.UID;

import javax.swing.*;
import java.awt.*;

public class DummyTab extends KENTab{
    @Override
    public String tabName(){
        return "Dummy";
    }

    @CallOnLoad(namespace = KENPluginDummy.NAMESPACE)
    public static void addDummyTab() throws Exception{
        TabManager.add(UID.of(KENPluginDummy.NAMESPACE, "tabs", "dummy"), DummyTab.class);
    }

    public DummyTab(){
        this.setSize(500,500);
        this.setBackground(new Color(0x2C3333));
        this.setLayout(null);
        this.setBounds(0,0,500,500);

        JLabel label = new JLabel();
        label.setFont(new Font("Poppins", Font.BOLD, 100));
        label.setForeground(new Color(0xFFFFFF));
        label.setBounds(300,100,1000,250);
        label.setText("Hello dummy");
        this.add(label);
    }
}

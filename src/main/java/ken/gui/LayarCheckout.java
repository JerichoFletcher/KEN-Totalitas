package ken.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;


public class LayarCheckout extends JPanel implements ActionListener{
    private JPanel panelBarang;
    private JButton fixBill;
    private JComboBox pilihMember;
    private JTextField inputField;
    private List<CartItem> listOfCartItem;

    public LayarCheckout(List<CartItem> listOfCartItem){
        super();
        this.listOfCartItem = listOfCartItem;
        this.setVisible(true);
        this.setBackground(new Color(0x2C3333));
        this.setLayout(null);
        makePanelLC();
        this.setBounds(0,0,500,500);
    }

    public void makePanelLC(){
        JLabel checkoutText = new JLabel("Checkout");
        JLabel totalPrice = new JLabel("Total: Rp." + 1000);
        checkoutText.setFont(new Font("Poppins", Font.BOLD,40));
        checkoutText.setForeground(Color.white);
        checkoutText.setBounds(550,30,500,100);
        totalPrice.setFont(new Font("Poppins", Font.BOLD,30));
        totalPrice.setForeground(Color.white);
        totalPrice.setBounds(35,480,500,100);
        this.add(checkoutText);
        this.add(totalPrice);
        panelBarang = new JPanel();
        panelBarang.setBackground(new Color(0x2C3333));
        panelBarang.setLayout(new BoxLayout(panelBarang, BoxLayout.Y_AXIS));
        panelBarang.setBorder(BorderFactory.createEmptyBorder());
        for (int i = 0; i <= listOfCartItem.size() - 1; i++) {
            String judulBarang = listOfCartItem.get(i).getJudul();
            int jmlhBarang = listOfCartItem.get(i).getCounter();
            JLabel item = new JLabel(judulBarang + "    " + jmlhBarang + 'x');
            item.setForeground(Color.white);
            item.setFont(new Font("Poppins", Font.BOLD,20));
            panelBarang.add(item);
        }
        JScrollPane scrollPane = new JScrollPane(panelBarang);
        scrollPane.setBackground(new Color(0, 0, 0, 0));
        scrollPane.setBounds(500, 150, 500, 350);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        String[] tipeMember = new String[]{"", "jovan", "farhan", "shidqi", "alek", "jericho"};
        pilihMember = new JComboBox(tipeMember);
        pilihMember.setBackground(new Color(0xD9D9D9));
        pilihMember.setBounds(920,400,250,50);
        pilihMember.setFont(new Font("Poppins", Font.BOLD,20));
        pilihMember.setForeground(new Color(0x395B64));
        pilihMember.setFocusable(false);
        this.add(pilihMember);

        inputField = new JTextField();
        inputField.setBounds(920, 400, 250, 50);
        inputField.setFont(new Font("Poppins", Font.PLAIN, 20));
        inputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                String enteredText = inputField.getText().toLowerCase();
                DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>();
                for (String member : tipeMember) {
                    if (member.toLowerCase().startsWith(enteredText)) {
                        model.addElement(member);
                    }
                }
                pilihMember.setModel(model);
                pilihMember.setPopupVisible(model.getSize() > 0);
            }
        });
        this.add(inputField);
        this.add(scrollPane);
        fixBill = new JButton();
        fixBill.addActionListener(this);
        fixBill.setFocusable(false);
        fixBill.setContentAreaFilled( false );
        fixBill.setText("FIX BILL");
        fixBill.setFont(new Font("Poppins", Font.BOLD,40));
        fixBill.setBackground(new Color(0, 0, 0, 0));
        fixBill.setForeground(Color.white);
        fixBill.setBorder(BorderFactory.createEmptyBorder());
        fixBill.setBounds(920,500,250,75);
        this.add(fixBill);

    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == fixBill){
            System.out.println("tix dummy");
            String selectedItem = (String) pilihMember.getSelectedItem();
            LayarFixedBill layarFB = new LayarFixedBill(selectedItem, listOfCartItem);
            Tabs.tabs.addCustomTab("Layar Fixed Bill", layarFB, Tabs.tabCount);
            Tabs.tabs.setSelectedComponent(layarFB);
        }
    }
}

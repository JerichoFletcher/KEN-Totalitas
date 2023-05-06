package ken.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.text.SimpleDateFormat;

public class LayarUtama extends JFrame implements Runnable, ActionListener{

    private JLabel clockLabel;
    private JLabel dayLabel;
    private JLabel dateLabel;
    private SimpleDateFormat timeFormat;
    private SimpleDateFormat dayFormat;
    private SimpleDateFormat dateFormat;
    private String time;
    private String day;
    private String date;

    private JPanel timeDayPanel;

    private JButton startButton;

    LayarUtama(){
        this.setSize(1280, 720);
        this.getContentPane().setBackground(new Color(0x2C3333));
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        startButton = new JButton();
        startButton.setBounds(900,520,400,200);
        startButton.addActionListener(this);
        startButton.setFocusable(false);
        startButton.setContentAreaFilled( false );
        startButton.setText("START");
        startButton.setFont(new Font("Poppins", Font.BOLD,50));
        startButton.setBackground(new Color(0, 0, 0, 0));
        startButton.setForeground(Color.white);
        startButton.setBorder(BorderFactory.createEmptyBorder());
        createLabels();
        this.add(dayLabel);
        this.add(dateLabel);
        this.add(clockLabel);
        this.add(startButton);
        this.setVisible(true);
        setTime();
    }

    public void setTime(){
        while(true){
            Thread clockThread = new Thread(this); // create a new thread
            clockThread.start();
//            time = timeFormat.format(Calendar.getInstance().getTime());
//            clockLabel.setText(time);
            day = dayFormat.format(Calendar.getInstance().getTime());
            dayLabel.setText(day);
            date = dateFormat.format(Calendar.getInstance().getTime());
            dateLabel.setText(date);
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run(){
        while(true){
            try{
                time = timeFormat.format(Calendar.getInstance().getTime());
                clockLabel.setText(time);
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public void createLabels(){
        timeFormat = new SimpleDateFormat("HH:mm ");
        dayFormat = new SimpleDateFormat("EEEE, ");
        dateFormat = new SimpleDateFormat("dd MMMMM YYYY");
        timeDayPanel = new JPanel();
        clockLabel = new JLabel();
        dayLabel = new JLabel();
        dateLabel = new JLabel();
        clockLabel.setFont(new Font("Poppins", Font.BOLD,100));
        clockLabel.setForeground(new Color(0xFFFFFF));
        clockLabel.setBounds(490,80,1000,250);
        dayLabel.setFont(new Font("Poppins", Font.BOLD,30));
        dayLabel.setBounds(450,0,400,250);
        dayLabel.setForeground(new Color(0xFFFFFF));
        dateLabel.setFont(new Font("Poppins", Font.BOLD,30));
        dateLabel.setBounds(620,0,400,250);
        dateLabel.setForeground(new Color(0xFFFFFF));
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == startButton){
            System.out.println("run main program");
            this.setVisible(false);
            DefaultLayar defLay = new DefaultLayar();
            Class<? extends JPanel>[] contentClasses = new Class[] {Kasir.class, Members.class, History.class};
            Tabs tabs = new Tabs();
            Menu menu = new Menu(tabs, contentClasses);
            defLay.add(menu);
            menu.setBounds(20,10,300,50);
            menu.setPreferredSize(new Dimension(300, 50));
            defLay.add(tabs);
            tabs.setBounds(0, 70, defLay.getWidth(), defLay.getHeight() - 70); // set the bounds
        }
    }
}

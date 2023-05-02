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
        this.setSize(1960, 1280);
        this.getContentPane().setBackground(new Color(0x2C3333));
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        startButton = new JButton();
        startButton.setBounds(1580,1010,400,200);
        startButton.addActionListener(this);
        startButton.setFocusable(false);
        startButton.setContentAreaFilled( false );
        startButton.setText("START");
        startButton.setFont(new Font("Poppins", Font.PLAIN,80));
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
        clockLabel.setFont(new Font("Poppins", Font.BOLD,150));
        clockLabel.setForeground(new Color(0xFFFFFF));
        clockLabel.setBounds(750,100,1000,250);
        dayLabel.setFont(new Font("Poppins", Font.BOLD,50));
        dayLabel.setBounds(680,0,400,250);
        dayLabel.setForeground(new Color(0xFFFFFF));
        dateLabel.setFont(new Font("Poppins", Font.BOLD,50));
        dateLabel.setBounds(950,0,400,250);
        dateLabel.setForeground(new Color(0xFFFFFF));
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == startButton){
            System.out.println("run main program");
            startButton.getModel().setPressed(false);
            startButton.getModel().setSelected(false);
        }
    }
}

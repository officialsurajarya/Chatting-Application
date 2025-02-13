package chatting.application;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;

public class Client extends JFrame implements ActionListener {
        
    JTextField text;
    JPanel a1;
    Box vertical = Box.createVerticalBox();
    
    Client() {
        setLayout(null);
        
        //Header Panel (Top Bar)
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(7, 94, 84));
        p1.setBounds(0, 0, 450, 70);
        p1.setLayout(null);
        add(p1);
        
        //Back Button (Exit)
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
        Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel back = new JLabel(i3);
        back.setBounds(5, 20, 25, 25);
        p1.add(back);
        
        back.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ae) {
                System.exit(0);
            }
        });
        
        //Profile Image
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/2.png"));
        Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel profile = new JLabel(i6);
        profile.setBounds(40, 10, 50, 50);
        p1.add(profile);
        
        //Video Call Icon
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
        Image i8 = i7.getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel video = new JLabel(i9);
        video.setBounds(300, 20, 30, 30);
        p1.add(video);
        
        //Phone Call Icon
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));
        Image i11 = i10.getImage().getScaledInstance(35, 30, Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel phone = new JLabel(i12);
        phone.setBounds(360, 20, 35, 30);
        p1.add(phone);
        
        //More Options Icon
        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));
        Image i14 = i13.getImage().getScaledInstance(10, 25, Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        JLabel morevert = new JLabel(i15);
        morevert.setBounds(410, 20, 10, 25);
        p1.add(morevert); 
        
        //Contact Name
        JLabel name = new JLabel("Shubham");
        name.setBounds(110, 15, 100, 18);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("SAN_SERIF",Font.BOLD, 20));
        p1.add(name);
        
        //Status Label
        JLabel status = new JLabel("Active Now");
        status.setBounds(110, 40, 100, 18);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("SAN_SERIF",Font.PLAIN, 15));
        p1.add(status);
        
        //Chat Panel
        a1 = new JPanel();
        a1.setBounds(5, 75, 440, 570);
        add(a1);
        
        //Text Field
        text = new JTextField(20);
        text.setBounds(5, 655, 310, 40);
        text.setFont(new Font ("SAN_SERIF", Font.PLAIN,16));
        add(text);
        
        //Send Button
        JButton send = new JButton("Send");
        send.setBounds(320, 655, 123, 40);
        send.setBackground(new Color(7, 94, 84));
        send.setForeground(Color.WHITE);
        send.addActionListener(this);
        send.setFont(new Font ("SAN_SERIF", Font.PLAIN,16));
        add(send);
        
        //Full Frame
        setSize(450, 700);
        setLocation(800,50);
        setUndecorated(true);
        getContentPane().setBackground(Color.WHITE);
        
        setVisible(true);
    }
    
    //Action Perform 
    public void actionPerformed(ActionEvent ae) {
        String out = text.getText();
             
        JPanel p2 = formatLabel(out);
        
        a1.setLayout(new BorderLayout());
        
        JPanel right = new JPanel (new BorderLayout());
        right.add(p2, BorderLayout.LINE_END);
        vertical.add(right);
        vertical.add(Box.createVerticalStrut(15));
        
        a1.add(vertical, BorderLayout.PAGE_START);
        
        text.setText("");
        
        repaint();
        invalidate();
        validate();
    }
    
    public static JPanel formatLabel(String out) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JLabel output = new JLabel("<html><p style='width:150px' >" + out + "</p></html>");
        output.setFont(new Font("Tahoma", Font.PLAIN, 16));
        output.setBackground(new Color(37, 211, 102));
        output.setOpaque(true);
        output.setBorder(new EmptyBorder(15, 15, 15, 50));
        
        panel.add(output);
        
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
        
        JLabel time = new JLabel();
        time.setText(sdf.format(cal.getTime()));
        
        panel.add(time);
        
        return panel;
    }
    
    public static void main(String[] args) {
        new Client();
    }
}

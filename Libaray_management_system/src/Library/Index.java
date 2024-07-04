package Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Index extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4;
    JButton b1,b2;
    JPanel p1,p2,p3;
    Font f1,f2;
    Index(){
        super("Login Page");
        setLocation(500,350);
        setSize(550,250);
        f1=new Font("Arial",Font.BOLD,30);
        f2=new Font("Arial",Font.BOLD,20);

        l1=new JLabel("Admin Login");
        l2=new JLabel("Librarian Login");
        l3=new JLabel("Library Management");

        b1=new JButton("Login");
        b2=new JButton("Login");

        b1.addActionListener(this);
        b2.addActionListener(this);

        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Library/icon/login.png"));
        Image i=img.getImage().getScaledInstance(200,170,Image.SCALE_DEFAULT);
        ImageIcon img2=new ImageIcon(i);
        l4=new JLabel(img2);

        l1.setFont(f2);
        l2.setFont(f2);
        l3.setFont(f1);
        b1.setFont(f2);
        b2.setFont(f2);

        l3.setHorizontalAlignment(JLabel.CENTER);
        l3.setForeground(Color.WHITE);

        p1=new JPanel();
        p1.setLayout(new GridLayout(2,2,10,10));
        p1.add(l1);
        p1.add(b1);
        p1.add(l2);
        p1.add(b2);

        p2=new JPanel();
        p2.setLayout(new GridLayout(1,1,10,10));
        p2.add(l4);

        p3=new JPanel();
        p3.setLayout(new GridLayout(1,1,10,10));
        p3.add(l3);
        p3.setBackground(Color.BLUE);

        setLayout(new BorderLayout(10,10));
        add(p3,"North");
        add(p2,"West");
        add(p1,"Center");





    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            new Admin().setVisible(true);
            this.setVisible(false);
        }
        if(ae.getSource()==b2){
            new Librarian().setVisible(true);
            this.setVisible(false);
        }


    }

    public static void main(String[] args) {
        new Index().setVisible(true);
    }

}

package Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Librarian extends JFrame implements ActionListener {
    JLabel l1,l2,l3 ;
    JButton b1,b2;
    JPanel p1,p2;
    Font f1,f2;
    JTextField tf1;
    JPasswordField pf1;

    Librarian(){
        super("Librarian Login Page");
        setLocation(450,400);
        setSize(500,200);
        f1=new Font("Arial",Font.BOLD,30);
        f2=new Font("Arial",Font.BOLD,20);

        l1=new JLabel("Librarian Login");
        l2=new JLabel("Name");
        l3=new JLabel("Password");

        b1=new JButton("Login");
        b2=new JButton("Cancel");

        b1.addActionListener(this);
        b2.addActionListener(this);

        tf1=new JTextField();
        pf1=new JPasswordField();

        l1.setFont(f1);
        l2.setFont(f2);
        l3.setFont(f2);
        b1.setFont(f2);
        b2.setFont(f2);
        tf1.setFont(f2);
        pf1.setFont(f2);

        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(Color.WHITE);

        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        p1.setBackground(Color.BLACK);

        p2=new JPanel();
        p2.setLayout(new GridLayout(3,2,10,10));
        p2.add(l2);
        p2.add(tf1);
        p2.add(l3);
        p2.add(pf1);
        p2.add(b1);
        p2.add(b2);

        setLayout(new BorderLayout(10,10));
        add(p1,"North");
        add(p2,"Center");
    }

    public void actionPerformed(ActionEvent ae){
        String name=tf1.getText();
        String password=pf1.getText();
        if(ae.getSource()==b1){
            try{
                ConnectionClass obj=new ConnectionClass();
                String s="select name,password from librarian where name='"+name+"'and password='"+password+"'";
                ResultSet rest=obj.stm.executeQuery(s);
                if(rest.next()){
                    new LibrarianSection().setVisible(true);
                    this.setVisible(false);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Your name And Password is Wrong");
                    this.setVisible(false);
                    this.setVisible(true);
                }

            }catch (Exception e){
                e.printStackTrace();
            }
        }
        if(ae.getSource()==b2){
            this.setVisible(false);
        }

    }
    public static void main(String[] args) {
        new Librarian().setVisible(true);

    }
}

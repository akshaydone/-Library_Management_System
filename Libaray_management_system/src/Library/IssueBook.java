package Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class IssueBook extends  JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JButton b1,b2;
    JPanel p1,p2;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6;
    Choice ch;
    Font f1,f2;

    IssueBook(){
        super("Issue Book");
        setLocation(450,200);
        setSize(650,400);

        f1=new Font("Arial",Font.BOLD,30);
        f2=new Font("Arial",Font.BOLD,20);

        l1=new JLabel("Issue Books");
        l2=new JLabel("Book ID");
        l3=new JLabel("Book No");
        l4=new JLabel("Book Name");
        l5=new JLabel("Student ID");
        l6=new JLabel("Student Name");
        l7=new JLabel("Student Contact");
        l8=new JLabel("Book Quantity");

        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setForeground(Color.WHITE);

        tf1=new JTextField();
        tf2=new JTextField();
        tf3=new JTextField();
        tf4=new JTextField();
        tf5=new JTextField();
        tf6=new JTextField();

        l1.setFont(f1);
        l2.setFont(f2);
        l3.setFont(f2);
        l4.setFont(f2);
        l5.setFont(f2);
        l6.setFont(f2);
        l7.setFont(f2);
        l8.setFont(f2);


        tf1.setFont(f2);
        tf1.setEditable(false);
        tf2.setFont(f2);
        tf2.setEditable(false);
        tf3.setFont(f2);
        tf4.setFont(f2);
        tf5.setFont(f2);
        tf6.setFont(f2);
        tf6.setEditable(false);
        //tf6.setBackground(Color.red);
        tf6.setForeground(Color.red);

        b1=new JButton("Issue Book");
        b2=new JButton("Cancel");

        b1.setFont(f2);
        b2.setFont(f2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        ch=new Choice();
        try{
            ConnectionClass obj=new ConnectionClass();
            String q="select id from addBook";
            ResultSet rest=obj.stm.executeQuery(q);
            while(rest.next()){
                ch.add(rest.getString("id"));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        ch.setFont(f2);

        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        p1.setBackground(Color.black);

        p2=new JPanel();
        p2.setLayout(new GridLayout(8,2,10,10));
        p2.add(l2);
        p2.add(ch);
        p2.add(l3);
        p2.add(tf1);
        p2.add(l4);
        p2.add(tf2);
        p2.add(l5);
        p2.add(tf3);
        p2.add(l6);
        p2.add(tf4);
        p2.add(l7);
        p2.add(tf5);
        p2.add(l8);
        p2.add(tf6);
        p2.add(b1);
        p2.add(b2);

        setLayout(new BorderLayout(10,10));
        add(p1,"North");
        add(p2,"Center");

        ch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try{
                    ConnectionClass obj1=new ConnectionClass();
                    int id=Integer.parseInt(ch.getSelectedItem());
                    String q1="select * from addBook where id='"+id+"'";
                    ResultSet rest1=obj1.stm.executeQuery(q1);
                    while(rest1.next()){
                        tf1.setText(rest1.getString("bookNo"));
                        tf2.setText(rest1.getString("bookName"));
                        tf6.setText(rest1.getString("quantity"));
                    }

                }catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });

    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1){
            int qnt=0;
            int id=Integer.parseInt(ch.getSelectedItem());
            String bookNo=tf1.getText();
            String bookName=tf2.getText();
            int studId=Integer.parseInt(tf3.getText());
            String studName=tf4.getText();
            String studContact=tf5.getText();
            String date=new java.util.Date().toString();
            try{
                ConnectionClass obj2=new ConnectionClass();
                String q2="select quantity from addBook where id='"+id+"'";
                ResultSet rest2=obj2.stm.executeQuery(q2);
                while(rest2.next()){
                    qnt=Integer.parseInt(rest2.getString("quantity"));
                }
                if(qnt<=0){
                    JOptionPane.showMessageDialog(null,"Book Quantity is less! can't issue");
                    this.setVisible(false);
                }
                else {
                    String q3 = "insert into issueBook(id,bookNo,bookName,studId,studName,studContact,date) values ('" + id + "','" + bookNo + "','" + bookName + "','" + studId + "','" + studName + "','" + studContact + "','" + date + "')";
                    String q4 = "update addBook set issueBook=issueBook+1 where id='" + id + "'";
                    String q5 = "update addBook set quantity=quantity-1 where id='" + id + "'";
                    int a1 = obj2.stm.executeUpdate(q3);
                    int a2 = obj2.stm.executeUpdate(q4);
                    int a3 = obj2.stm.executeUpdate(q5);
                    if (a1 == 1) {
                        if (a2 == 1) {
                            if (a3 == 1) {
                                JOptionPane.showMessageDialog(null, "Your data Successfully Updated");
                                this.setVisible(false);
                            } else {
                                JOptionPane.showMessageDialog(null, "Please! Fill all details carefully");

                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Please! Fill all details carefully");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Please! Fill all details carefully");
                    }
                }

            }catch (Exception e2){
                e2.printStackTrace();
            }

        }
        if(ae.getSource()==b2){
            JOptionPane.showMessageDialog(null,"Are you sure?");
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        new IssueBook().setVisible(true);
    }
}

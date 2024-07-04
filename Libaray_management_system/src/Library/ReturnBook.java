package Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReturnBook extends JFrame implements ActionListener {
    JLabel l1,l2,l3;
    JButton b1,b2;
    JPanel p1,p2;
    JTextField tf1,tf2;
    Font f1,f2;

    ReturnBook(){
        super("Return Book");
        setLocation(450,200);
        setSize(650,400);

        f1=new Font("Arial",Font.BOLD,30);
        f2=new Font("Arial",Font.BOLD,20);

        l1=new JLabel("Return Books");
        l2=new JLabel("Book No");
        l3=new JLabel("Student Id");

        l1.setForeground(Color.WHITE);
        l1.setHorizontalAlignment(JLabel.CENTER);

        tf1=new JTextField();
        tf2=new JTextField();

        l1.setFont(f1);
        l2.setFont(f2);
        l3.setFont(f2);

        tf1.setFont(f2);
        tf2.setFont(f2);

        b1=new JButton("Return Book");
        b2=new JButton("Cancel");

        b1.setFont(f2);
        b2.setFont(f2);

        b1.addActionListener(this);
        b2.addActionListener(this);

        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        p1.setBackground(Color.black);

        p2=new JPanel();
        p2.setLayout(new GridLayout(3,2,10,10));
        p2.add(l2);
        p2.add(tf1);
        p2.add(l3);
        p2.add(tf2);
        p2.add(b1);
        p2.add(b2);

        setLayout(new BorderLayout(10,10));
        add(p1,"North");
        add(p2,"Center");
    }

    public void actionPerformed(ActionEvent ae) {
        String bookNo=tf1.getText();
        int studId=Integer.parseInt(tf2.getText());

        if(ae.getSource()==b1){
            try{
                ConnectionClass obj=new ConnectionClass();
                String q="delete from issueBook where bookNo='"+bookNo+"'and studId='"+studId+"'";
                int rest=obj.stm.executeUpdate(q);
                if(rest==0){
                    JOptionPane.showMessageDialog(null,"Book was not issued");
                    this.setVisible(false);
                }else{
                    String q1="update addBook set issueBook=issueBook-1 where bookNo='"+bookNo+"'";
                    String q2="update addBook set quantity=quantity+1 where bookNo='"+bookNo+"'";
                    int a1=obj.stm.executeUpdate(q1);
                    int a2=obj.stm.executeUpdate(q2);
                    if(a1==1){
                        if(a2==1){
                            JOptionPane.showMessageDialog(null,"Your book returned Successfully");
                            this.setVisible(false);
                        }
                        else{
                            JOptionPane.showMessageDialog(null,"Please! Fill all details carefully");
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Please! Fill all details carefully");
                    }
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
        new ReturnBook().setVisible(true);
    }
}
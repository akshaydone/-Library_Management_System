package Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LibrarianSection extends JFrame implements ActionListener {
    Font f1,f2;
    LibrarianSection(){
        super("Librarian Section");
        setLocation(0,0);
        setSize(1500,800);

        f1=new Font("Arial",Font.BOLD,30);
        f2=new Font("Arial",Font.BOLD,20);


        //background-image
        setSize(1500,800);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(0, 0);
        setTitle("Admin Page");
        setResizable(false);
        JLabel background=new JLabel(new ImageIcon("C:\\Library_Management_System\\src\\Library\\icon\\library.jpeg"));
        setContentPane(background);
        background.setLayout(new FlowLayout());
        Panel cp = new Panel(null);
        background.add(cp);

        JMenuBar m1=new JMenuBar();
        m1.setOpaque(true);
        m1.setBackground(Color.lightGray);

        JMenu men1=new JMenu("Add Info");
        men1.setOpaque(true);
        men1.setBackground(Color.blue);
        JMenuItem ment1=new JMenuItem("Add Book");

        JMenu men2=new JMenu("View Info");
        men2.setOpaque(true);
        men2.setBackground(Color.green);
        JMenuItem ment2=new JMenuItem("View Book");
        JMenuItem ment2_A=new JMenuItem("View Issue Book");

        JMenu men3=new JMenu("Issue Info");
        men3.setOpaque(true);
        men3.setBackground(Color.magenta);
        JMenuItem ment3=new JMenuItem("Issue Book");

        JMenu men4=new JMenu("Return");
        men4.setOpaque(true);
        men4.setBackground(Color.cyan);
        JMenuItem ment4=new JMenuItem("Return Book");

        JMenu men5=new JMenu("Exit");
        men5.setOpaque(true);
        men5.setBackground(Color.lightGray);
        JMenuItem ment5=new JMenuItem("Logout");

        men1.add(ment1);
        men2.add(ment2);
        men2.add(ment2_A);
        men3.add(ment3);
        men4.add(ment4);
        men5.add(ment5);

        m1.add(men1);
        m1.add(men2);
        m1.add(men3);
        m1.add(men4);
        m1.add(men5);

        men1.setFont(f1);
        men2.setFont(f1);
        men3.setFont(f1);
        men4.setFont(f1);
        men5.setFont(f1);

        ment1.setFont(f2);
        ment2.setFont(f2);
        ment2_A.setFont(f2);
        ment3.setFont(f2);
        ment4.setFont(f2);
        ment5.setFont(f2);

        ment1.addActionListener(this);
        ment2.addActionListener(this);
        ment2_A.addActionListener(this);
        ment3.addActionListener(this);
        ment4.addActionListener(this);
        ment5.addActionListener(this);

        setJMenuBar(m1);
        add(m1);






    }
    public void actionPerformed(ActionEvent ae){
        String comnd=ae.getActionCommand();
        if(comnd.equals("Add Book")){
            new AddBook().setVisible(true);
        }
        else if(comnd.equals("View Book")){
            new ViewBook().setVisible(true);
        }
        else if(comnd.equals("View Issue Book")){
             new ViewIssueBook().setVisible(true);
        }
        else if(comnd.equals("Issue Book")){
             new IssueBook().setVisible(true);
        }else if(comnd.equals("Return Book")){
             new ReturnBook().setVisible(true);
        }else if(comnd.equals("Logout")){
           System.exit(0);
        }


    }

    public static void main(String[] args) {
        new LibrarianSection().setVisible(true);
    }

}

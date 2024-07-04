package Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AdminSection extends JFrame implements ActionListener {

    Font f1,f2;

    AdminSection(){
        super("Admin Page");
        setSize(1200,800);


        f1=new Font("Arial",Font.BOLD,30);
        f2=new Font("Arial",Font.BOLD,20);



        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(150, 0);
        setTitle("Admin Page");
        setResizable(false);
        JLabel background=new JLabel(new ImageIcon("C:\\Library_Management_System\\src\\Library\\icon\\table.jpg"));
        setContentPane(background);
        background.setLayout(new FlowLayout());
        Panel cp = new Panel(null);
        background.add(cp);


        JMenuBar m1=new JMenuBar();
        m1.setOpaque(true);
        m1.setBackground(Color.lightGray);


        JMenu men1=new JMenu("Add Info");
        men1.setOpaque(true);
        men1.setBackground(Color.pink);
        JMenuItem ment1=new JMenuItem("Add Librarian");


        JMenu men2=new JMenu("View Info");
        men2.setOpaque(true);
        men2.setBackground(Color.orange);
        JMenuItem ment2=new JMenuItem("View Librarian");

        JMenu men3=new JMenu("Delete Info");
        men3.setOpaque(true);
        men3.setBackground(Color.yellow);
        JMenuItem ment3=new JMenuItem("Delete Librarian");

        JMenu men4=new JMenu("Exit");
        men4.setOpaque(true);
        men4.setBackground(Color.lightGray);
        JMenuItem ment4=new JMenuItem("Logout");

        men1.add(ment1);
        men2.add(ment2);
        men3.add(ment3);
        men4.add(ment4);

        m1.add(men1);
        m1.add(men2);
        m1.add(men3);
        m1.add(men4);

        men1.setFont(f1);
        men2.setFont(f1);
        men3.setFont(f1);
        men4.setFont(f1);

        ment1.setFont(f2);
        ment2.setFont(f2);
        ment3.setFont(f2);
        ment4.setFont(f2);

        ment1.addActionListener(this);
        ment2.addActionListener(this);
        ment3.addActionListener(this);
        ment4.addActionListener(this);

        setJMenuBar(m1);
        add(m1);


    }
    public void actionPerformed(ActionEvent ae){
        String comnd=ae.getActionCommand();
        if(comnd.equals("Add Librarian")){
            new AddLibrarian().setVisible(true);

        }
        else if(comnd.equals("View Librarian")){
            System.out.println("View Librarian");
            new ViewLibrarian().setVisible(true);
        }
        else if(comnd.equals("Delete Librarian")){
            System.out.println("Delete Librarian");
            new DeleteLibrarian().setVisible(true);
        }
        else if(comnd.equals("Logout")){
            System.exit(0);
        }

    }

    public static void main(String[] args) {
        new AdminSection().setVisible(true);
    }
}

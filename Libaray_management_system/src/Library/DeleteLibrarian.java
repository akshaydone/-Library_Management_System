package Library;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class DeleteLibrarian extends JFrame implements ActionListener {
    String[] x ={"Lid","name","password","contact","address","city","email"};
    JButton b1;
    JTextField tf1;
    JPanel p1;
    JLabel l1;



    String[][] y =new String[25][7];
    int i=0,j=0;
    JTable t;
    Font f1;
    DeleteLibrarian(){

        super("Delete Librarian ");
        setLocation(20,100);
        setSize(1500,600);

        f1=new Font("Arial",Font.PLAIN,15);
        Font font = UIManager.getFont("TableHeader.font");
        font = font.deriveFont(22f);
        UIManager.put("TableHeader.font", font);


        try{
            ConnectionClass obj=new ConnectionClass();
            String query="select * from librarian;";
            ResultSet rest =obj.stm.executeQuery(query);
            while(rest.next()){
                y[i][j++]=rest.getString("Lid");
                y[i][j++]=rest.getString("name");
                y[i][j++]=rest.getString("password");
                y[i][j++]=rest.getString("contact");
                y[i][j++]=rest.getString("address");
                y[i][j++]=rest.getString("city");
                y[i][j++]=rest.getString("email");

                i++;
                j=0;
            }


            t=new JTable(y,x);
            t.setFont(f1);


        }catch (Exception e){
            e.printStackTrace();
        }
        JScrollPane sp=new JScrollPane(t);


        l1=new JLabel("Delete Librarian");
        tf1=new JTextField();
        b1=new JButton("Delete");
        b1.addActionListener(this);




        l1.setFont(font);
        tf1.setFont(f1);
        b1.setFont(font);

        p1=new JPanel();
        p1.setLayout(new GridLayout(1,3,10,10));
        p1.add(l1);
        p1.add(tf1);
        p1.add(b1);
        setLayout(new BorderLayout(10,10));


        add(sp,"Center");
        add(p1,"South");

    }

    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==b1){
           System.out.println("Hii");
           int id=Integer.parseInt(tf1.getText());
           try{
               ConnectionClass obj=new ConnectionClass();
               String q="delete from librarian where lid='"+id+"'";
               int res=obj.stm.executeUpdate(q);
               if(res==1){
                   JOptionPane.showMessageDialog(null,"Your data successfully deleted");
                   this.setVisible(false);
                   new DeleteLibrarian().setVisible(true);
               }
               else {
                   JOptionPane.showMessageDialog(null,"Your data not deleted successfully");

               }

           }catch (Exception e){
               e.printStackTrace();
           }

       }
    }

    public static void main(String[] args) {
        new DeleteLibrarian().setVisible(true);

    }

}

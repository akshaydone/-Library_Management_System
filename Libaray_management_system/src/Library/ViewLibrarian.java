package Library;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class ViewLibrarian extends JFrame {
   String[] x ={"Lid","Name","Password","Contact","Address","City","Email"};
   JButton b1;
   String[][] y =new String[25][7];
   int i=0,j=0;
   JTable t;
   Font f1;

   ViewLibrarian(){
       super("Librarian Information");
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
               y[i][j++]=rest.getString("Name");
               y[i][j++]=rest.getString("Password");
               y[i][j++]=rest.getString("Contact");
               y[i][j++]=rest.getString("Address");
               y[i][j++]=rest.getString("City");
               y[i][j++]=rest.getString("Email");

               i++;
               j=0;
           }


               t=new JTable(y,x);
               t.setFont(f1);


       }catch (Exception e){
           e.printStackTrace();
       }
       JScrollPane sp=new JScrollPane(t);

       add(sp);
   }

    public static void main(String[] args) {
       new ViewLibrarian().setVisible(true);
    }
}

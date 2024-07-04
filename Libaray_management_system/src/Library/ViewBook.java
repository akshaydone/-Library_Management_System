package Library;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class ViewBook  extends JFrame {
    String[] x ={"Id","Book No","Book Name","Author","Publisher","Quantity","Issued","Date"};
    JButton b1;
    String[][] y =new String[25][8];
    int i=0,j=0;
    JTable t;
    Font f1;
    ViewBook(){
        super("Book Information");
        setLocation(20,100);
        setSize(1500,600);

        f1=new Font("Arial",Font.PLAIN,15);
        Font font = UIManager.getFont("TableHeader.font");
        font = font.deriveFont(22f);
        UIManager.put("TableHeader.font", font);

        try{
            ConnectionClass obj=new ConnectionClass();
            String query="select * from addBook;";
            ResultSet rest =obj.stm.executeQuery(query);
            while(rest.next()){
                y[i][j++]=rest.getString("id");
                y[i][j++]=rest.getString("bookNo");
                y[i][j++]=rest.getString("bookName");
                y[i][j++]=rest.getString("author");
                y[i][j++]=rest.getString("publisher");
                y[i][j++]=rest.getString("quantity");
                y[i][j++]=rest.getString("issueBook");
                y[i][j++]=rest.getString("date");

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
        new ViewBook().setVisible(true);
    }

}

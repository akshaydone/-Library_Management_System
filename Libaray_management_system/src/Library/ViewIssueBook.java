package Library;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class ViewIssueBook extends JFrame {
    String[] x ={"Id","Book No","Book Name","Student Id","Student Name","Student Contact","Date"};
    JButton b1;
    String[][] y =new String[25][7];
    int i=0,j=0;
    JTable t;
    Font f1;

    ViewIssueBook() {

        super("Issued Books Information");
        setLocation(20, 100);
        setSize(1500, 600);

        f1 = new Font("Arial", Font.PLAIN, 15);
        Font font = UIManager.getFont("TableHeader.font");
        font = font.deriveFont(22f);
        UIManager.put("TableHeader.font", font);


        try{
            ConnectionClass obj=new ConnectionClass();
            String query="select * from issueBook;";
            ResultSet rest =obj.stm.executeQuery(query);
            while(rest.next()){
                y[i][j++]=rest.getString("id");
                y[i][j++]=rest.getString("bookNo");
                y[i][j++]=rest.getString("bookName");
                y[i][j++]=rest.getString("studId");
                y[i][j++]=rest.getString("studName");
                y[i][j++]=rest.getString("studContact");
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
        new ViewIssueBook().setVisible(true);
    }
}

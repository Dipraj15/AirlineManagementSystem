
package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class FlightInfo extends JFrame
{
    public FlightInfo()
    {
        getContentPane().setBackground(new Color(225,182,239));
        getContentPane().setForeground(new Color(225,182,239));
        setLayout(null);
        
        setSize(800,500);
        setLocation(400,200);
        setVisible(true);
        
        
        JTable table = new JTable();
        
        try
        {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from flight");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            table.setBackground(new Color(225,182,239));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,0,800,500);
        jsp.setBackground(new Color(225,182,239));
        add(jsp);
    }
    
    
    public static void main(String [] args)
    {
        new FlightInfo();
    }
}

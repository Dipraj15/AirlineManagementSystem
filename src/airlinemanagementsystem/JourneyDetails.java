package airlinemanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class JourneyDetails extends JFrame implements ActionListener
{
    JTable table;
    JTextField aadhar;
    JButton show;
    public JourneyDetails()
    {
        getContentPane().setBackground(new Color(225,182,239));
        setLayout(null);
        
        setSize(800,600);
        setLocation(400,150);
        setVisible(true);
        
        
        JLabel lblprn = new JLabel("Aadhar No: ");
        lblprn.setBounds(50,50,100,25);
        lblprn.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 12));
        add(lblprn);
       
        aadhar = new JTextField();
        aadhar.setBounds(160,50,120,25);
        add(aadhar);
        
        show = new JButton("Show Details");
        show.setBackground(Color.BLACK);
        show.setForeground(Color.WHITE);
        show.setBounds(290,50,120,25);
        show.addActionListener(this);
        add(show);
        
        
        table = new JTable();
        
        
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,100,800,150);
        jsp.setBackground(new Color(225,182,239));
        add(jsp);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/jd.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(300,280,200,200);
        add(lblimage);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        try
        {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from reservation where aadhar = '"+aadhar.getText()+"'");
            
            if(!rs.isBeforeFirst())
            {
                JOptionPane.showMessageDialog(null,"No Information Found..!");
                return;
            }
            table.setModel(DbUtils.resultSetToTableModel(rs));
            table.setBackground(new Color(225,182,239));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    public static void main(String [] args)
    {
        new JourneyDetails();
    }
}

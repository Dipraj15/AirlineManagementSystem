package airlinemanagementsystem;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import javax.sound.sampled.*;
import java.io.*;


public class Cancel extends JFrame implements ActionListener
{
    JTextField tfprn;
    JLabel tfname,lblcode,lbldateoftravel,cancellationno;
    JButton fetchbutton,flight;

    public Cancel()
    {
        getContentPane().setBackground(new Color(225,182,239));
        setLayout(null);
        setSize(800,450);
        setLocation(350,150);
        setVisible(true);
        
        Random random = new Random();
        
        JLabel heading = new JLabel("Cancelation");
        heading.setBounds(280,20,250,35);
        heading.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        heading.setForeground(Color.blue);
        add(heading);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/cancel55.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(470,100 ,250 ,250 );
        add(image);
        
        JLabel lblaadhar = new JLabel("PRN No :");
        lblaadhar.setBounds(60,80,150,25);
        lblaadhar.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
        lblaadhar.setForeground(Color.black);
        add(lblaadhar);
        
        tfprn = new JTextField();
        tfprn.setBounds(220,80,150,25);
        add(tfprn);
        
        fetchbutton = new JButton("Show Details");
        fetchbutton.setBackground(Color.YELLOW);
        fetchbutton.setForeground(Color.BLACK);
        fetchbutton.setBounds(380,80,125,25);
        fetchbutton.addActionListener(this);
        add(fetchbutton);
        
        JLabel lblname = new JLabel("Name :");
        lblname.setBounds(60,130,150,25);
        lblname.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
        lblname.setForeground(Color.black);
        add(lblname);
        
        tfname = new JLabel();
        tfname.setBounds(220,130,150,25);  // This matches the 'Name :' label y-position
        add(tfname);
        
        
        JLabel lblnationality = new JLabel("Cancellation No :");
        lblnationality.setBounds(60,180,150,25);
        lblnationality.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
        lblnationality.setForeground(Color.black);
        add(lblnationality);
        
        cancellationno = new JLabel(" " + random.nextInt(1000000));
        cancellationno.setBounds(220,180,150,25);
        add(cancellationno);
        
        
        
        
        JLabel lbladdress = new JLabel("Flight Code :");
        lbladdress.setBounds(60,230,150,25);
        lbladdress.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
        lbladdress.setForeground(Color.black);
        add(lbladdress);
        
        lblcode = new JLabel();
        lblcode.setBounds(220,230,150,25);
        add(lblcode);
        
        JLabel lblgender = new JLabel("Date :");
        lblgender.setBounds(60,280,150,25);
        lblgender.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
        lblgender.setForeground(Color.black);
        add(lblgender);
        
        lbldateoftravel = new JLabel();
        lbldateoftravel.setBounds(220,280,150,25);
        add(lbldateoftravel);

        flight = new JButton("Cancel");
        flight.setBackground(Color.RED);
        flight.setForeground(Color.WHITE);
        flight.setBounds(220,330,120,25);
        flight.setFont(new Font("Rockwell", Font.PLAIN, 12));
        flight.addActionListener(this);
        add(flight);
        

    }
    
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == fetchbutton)
            {

                String prn = tfprn.getText();
                
                try
                {
                    Conn conn = new Conn();

                    String query = "select * from reservation where PRN = '"+prn+"'";

                    ResultSet rs = conn.s.executeQuery(query);
                    
                    if(rs.next())
                    {
                        tfname.setText(rs.getString("name"));
                        lblcode.setText(rs.getString("flightcode"));
                        lbldateoftravel.setText(rs.getString("ddate"));
                        
                    }
                    
                    else
                    {
                        JOptionPane.showMessageDialog(null,"User does not exist..!");
                    }

                }

                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        // FECHING THE SOURCE AND DEST OF FLIGHT
        else if(ae.getSource() == flight)
            {

                String name = tfname.getText();
                String prn = tfprn.getText();
                String cancelno = cancellationno.getText();
                String fcode = lblcode.getText();
                String ddate = lbldateoftravel.getText();
                try
                {
                    Conn conn = new Conn();

                    String query = "insert into cancel values('"+prn+"', '"+name+"', '"+cancelno+"', '"+fcode+"', '"+ddate+"')";

                    conn.s.executeUpdate(query);
                    
                    conn.s.executeUpdate("delete from reservation where PRN = '"+prn+"'");
                    
                    JOptionPane.showMessageDialog(null,"Ticket Cnacelled..!");
                    setVisible(false);
                        
                    

                }

                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }

        
    }
    
    public static void main(String [] args)
        {
            new Cancel();
        }
}



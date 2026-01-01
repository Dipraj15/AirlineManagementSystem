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


public class BordingPass extends JFrame implements ActionListener
{
    JTextField tfprn;
    JLabel tfname,tfsrc,tfnationality,lbldest,labelfname,labelfcode,lebeldate;
    JButton bookflight,fetchbutton,flight;
    Choice source,destination;
    JDateChooser dcdate;
    public BordingPass()
    {
        getContentPane().setBackground(new Color(225,182,239));
        setLayout(null);
        setSize(1000,450);
        setLocation(300,150);
        setVisible(true);
        
        JLabel heading = new JLabel("AIR INDIA");
        heading.setBounds(380,0,450,35);
        heading.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        heading.setForeground(Color.blue);
        add(heading);
        
        JLabel subheading = new JLabel("Bording Pass");
        subheading.setBounds(400,45,300,28);
        subheading.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        subheading.setForeground(Color.blue);
        add(subheading);
        
        
        JLabel lblaadhar = new JLabel("PRN DETAILS :");
        lblaadhar.setBounds(60,100,150,25);
        lblaadhar.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
        lblaadhar.setForeground(Color.black);
        add(lblaadhar);
        
        tfprn = new JTextField();
        tfprn.setBounds(220,100,150,25);
        add(tfprn);
        
        fetchbutton = new JButton("Fetch");
        fetchbutton.setBackground(Color.YELLOW);
        fetchbutton.setForeground(Color.BLACK);
        fetchbutton.setBounds(380,100,120,25);
        fetchbutton.addActionListener(this);
        add(fetchbutton);
        
        JLabel lblname = new JLabel("Name :");
        lblname.setBounds(60,140,150,25);
        lblname.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
        lblname.setForeground(Color.black);
        add(lblname);
        
        tfname = new JLabel();
        tfname.setBounds(220,140,150,25);  // This matches the 'Name :' label y-position
        add(tfname);
        
        
        JLabel lblnationality = new JLabel("Nationality :");
        lblnationality.setBounds(60,180,150,25);
        lblnationality.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
        lblnationality.setForeground(Color.black);
        add(lblnationality);
        
        tfnationality = new JLabel();
        tfnationality.setBounds(220,180,150,25);
        add(tfnationality);
        
        
        
        
        JLabel lbladdress = new JLabel("Source :");
        lbladdress.setBounds(60,220,150,25);
        lbladdress.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
        lbladdress.setForeground(Color.black);
        add(lbladdress);
        
        tfsrc = new JLabel();
        tfsrc.setBounds(220,220,150,25);
        add(tfsrc);
        
        JLabel lblgender = new JLabel("Destination :");
        lblgender.setBounds(380,220,150,25);
        lblgender.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
        lblgender.setForeground(Color.black);
        add(lblgender);
        
       
        
        
        
        lbldest = new JLabel();
        lbldest.setBounds(550,220,150,25);
        lbldest.setForeground(Color.black);
        add(lbldest);
        
        
        
        JLabel lblfname = new JLabel("Flight Name :");
        lblfname.setBounds(60,260,150,25);
        lblfname.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
        lblfname.setForeground(Color.black);
        add(lblfname);
        
        labelfname = new JLabel();
        labelfname.setBounds(220,260,150,25);
        add(labelfname);
        
        
        JLabel lblfcode = new JLabel("Flight Code :");
        lblfcode.setBounds(380,260,150,25);
        lblfcode.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
        lblfcode.setForeground(Color.black);
        add(lblfcode);
        
        labelfcode = new JLabel();
        labelfcode.setBounds(550,260,150,25);
        add(labelfcode);
        
        JLabel lbldate = new JLabel("Date :");
        lbldate.setBounds(60,300,150,25);
        lbldate.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
        lbldate.setForeground(Color.black);
        add(lbldate);
        
        lebeldate = new JLabel();
        lebeldate.setBounds(220,300,150,25);
        add(lebeldate);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/bord.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(600,50,300,300);
        add(lblimage);
            
        

    }
    
    
    public void actionPerformed(ActionEvent ae)
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
                        tfnationality.setText(rs.getString("nationality"));
                        tfsrc.setText(rs.getString("src"));
                        lbldest.setText(rs.getString("des"));
                        labelfname.setText(rs.getString("flightname"));
                        labelfcode.setText(rs.getString("flightcode"));
                        lebeldate.setText(rs.getString("ddate"));
                        
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
            
        // FECHING THE SOURCE AND DEST OF FLIGHT
    }
    
    
    public static void main(String [] args)
        {
            new BordingPass();
        }
}


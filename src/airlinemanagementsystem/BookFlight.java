
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

//skjhfehkjfhskjfjhsfhskjhfkj
public class BookFlight extends JFrame implements ActionListener
{
    JTextField tfaadhar;
    JLabel tfname,tfaddress,tfnationality,labelgender,labelfname,labelfcode;
    JButton bookflight,fetchbutton,flight;
    Choice source,destination;
    JDateChooser dcdate;
    public BookFlight()
    {
        getContentPane().setBackground(new Color(225,182,239));
        setLayout(null);
        setSize(1100,700);
        setLocation(200,50);
        setVisible(true);
        
        JLabel heading = new JLabel("Book Flight");
        heading.setBounds(420,20,500,35);
        heading.setFont(new Font("Comic Sans MS", Font.PLAIN, 27));
        heading.setForeground(Color.blue);
        add(heading);
        
        JLabel lblaadhar = new JLabel("Aadhar No :");
        lblaadhar.setBounds(60,80,150,25);
        lblaadhar.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
        lblaadhar.setForeground(Color.black);
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(220,80,150,25);
        add(tfaadhar);
        
        fetchbutton = new JButton("Fetch");
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
        tfname.setBounds(220,130,150,25); 
        add(tfname);
        
        
        JLabel lblnationality = new JLabel("Nationality :");
        lblnationality.setBounds(60,180,150,25);
        lblnationality.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
        lblnationality.setForeground(Color.black);
        add(lblnationality);
        
        tfnationality = new JLabel();
        tfnationality.setBounds(220,180,150,25);
        add(tfnationality);
        
        
        
        
        JLabel lbladdress = new JLabel("Address :");
        lbladdress.setBounds(60,230,150,25);
        lbladdress.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
        lbladdress.setForeground(Color.black);
        add(lbladdress);
        
        tfaddress = new JLabel();
        tfaddress.setBounds(220,230,150,25);
        add(tfaddress);
        
        JLabel lblgender = new JLabel("Gender :");
        lblgender.setBounds(60,280,150,25);
        lblgender.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
        lblgender.setForeground(Color.black);
        add(lblgender);
        

        labelgender = new JLabel();
        labelgender.setBounds(220,280,150,25);
        labelgender.setForeground(Color.black);
        add(labelgender);
        
        JLabel lblsource = new JLabel("Source :");
        lblsource.setBounds(60,330,150,25);
        lblsource.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
        lblsource.setForeground(Color.black);
        add(lblsource);
        
        source = new Choice();
        source.setBounds(220,330,120,25);
        add(source);
        
        
        
        JLabel lbldest = new JLabel("Destination :");
        lbldest.setBounds(60,380,150,25);
        lbldest.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
        lbldest.setForeground(Color.black);
        add(lbldest);
        
        destination = new Choice();
        destination.setBounds(220,380,120,25);
        add(destination);
        
         try
         {
             Conn c = new Conn();
             String query = "select * from flight";
             ResultSet rs = c.s.executeQuery(query);
             
             while(rs.next())
             {
                 source.add(rs.getString("source"));
                  destination.add(rs.getString("dest"));
             }
         }
         
         catch(Exception e)
         {
             e.printStackTrace();
         }
        
        
        
        flight = new JButton("Fetch Flights");
        flight.setBackground(Color.GREEN);
        flight.setForeground(Color.BLACK);
        flight.setBounds(380,380,120,25);
        flight.setFont(new Font("Rockwell", Font.PLAIN, 12));
        flight.addActionListener(this);
        add(flight);
        
        JLabel lblfname = new JLabel("Flight Name :");
        lblfname.setBounds(60,430,150,25);
        lblfname.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
        lblfname.setForeground(Color.black);
        add(lblfname);
        
        labelfname = new JLabel();
        labelfname.setBounds(220,430,150,25);
        add(labelfname);
        
        
        JLabel lblfcode = new JLabel("Flight Code :");
        lblfcode.setBounds(60,480,150,25);
        lblfcode.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
        lblfcode.setForeground(Color.black);
        add(lblfcode);
        
        labelfcode = new JLabel();
        labelfcode.setBounds(220,480,150,25);
        add(labelfcode);
        
        JLabel lbldate = new JLabel("Date of Travel :");
        lbldate.setBounds(60,530,150,25);
        lbldate.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
        lbldate.setForeground(Color.black);
        add(lbldate);
        
        dcdate = new JDateChooser();
        dcdate.setBounds(220,530,150,25);
        add(dcdate);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/booking.png"));
        Image i2 = i1.getImage().getScaledInstance(450, 400, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(550,80,500,410);
        add(lblimage);
            
        
        bookflight = new JButton("Book Flight");
        bookflight.setBackground(Color.YELLOW);
        bookflight.setForeground(Color.BLACK);
        bookflight.setBounds(220,580,150,25);
        bookflight.addActionListener(this);
        add(bookflight);
    }
    
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == fetchbutton)
            {

                String aadhar = tfaadhar.getText();
                
                try
                {
                    Conn conn = new Conn();

                    String query = "select * from passanger where aadhar = '"+aadhar+"'";

                    ResultSet rs = conn.s.executeQuery(query);
                    
                    if(rs.next())
                    {
                        tfname.setText(rs.getString("name"));
                        tfaddress.setText(rs.getString("address"));
                        tfnationality.setText(rs.getString("nationality"));
                        labelgender.setText(rs.getString("gender"));
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

                String src = source.getSelectedItem();
                String dest = destination.getSelectedItem();
                try
                {
                    Conn conn = new Conn();

                    String query = "select * from flight where source = '"+src+"'  and dest = '"+dest+"'";

                    ResultSet rs = conn.s.executeQuery(query);
                    
                    if(rs.next())
                    {
                        labelfname.setText(rs.getString("f_name"));
                        labelfcode.setText(rs.getString("f_code"));
                        
                    }
                    
                    else
                    {
                        JOptionPane.showMessageDialog(null,"OOPs.. ,No Flight Founds..!");
                    }

                }

                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        // BOOKING THE FLIGHT
        else
            {
                Random random = new Random();
                String aadhar = tfaadhar.getText();
               String name = tfname.getText();
               String address = tfaddress.getText();
               String nationality = tfnationality.getText();
               String gender =  labelgender.getText();
               String flightname = labelfname.getText();
               String flightcode =  labelfcode.getText();
               String src = source.getSelectedItem();
               String dest = destination.getSelectedItem();
               String ddate = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
       
               
               try
                {
                    Conn conn = new Conn();

                    String query = "insert into reservation values('PRN-"+random.nextInt(1000000)+"','TIC-"+random.nextInt(10000)
                            +"','"+aadhar+"','"+name+"','"+nationality+"','"+flightname+"','"+flightcode+"','"+src+"','"+dest+"','"+ddate+"')";

                    conn.s.executeUpdate(query);
                    
                     AudioInputStream audio = AudioSystem.getAudioInputStream(
                    ClassLoader.getSystemResource("airlinemanagementsystem/audio/bookaudio.wav"));

                    Clip clip = AudioSystem.getClip();
                    clip.open(audio);
                    clip.start();
                    
                    JOptionPane.showMessageDialog(null,"Ticket Booked Successfully..!");
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
            new BookFlight();
        }
}


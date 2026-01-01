
package airlinemanagementsystem;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Home extends JFrame implements ActionListener
{
    public Home()
    {
        setLayout(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/home33.jpg"));
        Image imageLoaded = i1.getImage(); // force image to load fully
        //ImageIcon finalIcon = new ImageIcon(imageLoaded);
        Image img = i1.getImage();
        ImageIcon finalIcon = new ImageIcon(img);
        //JLabel image = new JLabel(finalIcon);
        //image.setBounds(0,0,1600,800);
        //add(image);
        
         JLabel imageLabel = new JLabel(finalIcon);
        imageLabel.setBounds(0, 0, 1600, 800);
        add(imageLabel);
        
        
        //JLabel heading = new JLabel("AIR INDIA WELCOME YOU");
        //heading.setBounds(500,80,800,60);
        //heading.setBackground(Color.WHITE);
        //heading.setForeground(Color.red);
        //heading.setFont(new Font("Comic Sans MS", Font.BOLD, 50));
        //imageLabel.add(heading);
        
        
        JMenuBar menubar = new JMenuBar();
        setJMenuBar(menubar);
        
        JMenu details = new JMenu("Details");
        menubar.add(details);
        
        JMenuItem flightdetails = new JMenuItem("Flight Details");
        flightdetails.addActionListener(this);
        details.add(flightdetails);
        
        JMenuItem custmerdetails = new JMenuItem("Add Custmer Details");
        custmerdetails.addActionListener(this);
        details.add(custmerdetails);
        
        JMenuItem bookflight = new JMenuItem("Book Flight");
        bookflight.addActionListener(this);
        details.add(bookflight);
        
        JMenuItem journydetails = new JMenuItem("Journy Details");
        journydetails.addActionListener(this);
        details.add(journydetails);
        
        JMenuItem ticketcancellation = new JMenuItem("Cancel Ticket");
        ticketcancellation.addActionListener(this);
        details.add(ticketcancellation);
        
        JMenu ticket = new JMenu("Ticket");
        menubar.add(ticket);
        
        JMenuItem boardingpass = new JMenuItem("Boarding Pass");
        boardingpass.addActionListener(this);
        ticket.add(boardingpass);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        String text = ae.getActionCommand();
        
        if(text.equals("Add Custmer Details"))
        {
            new AddCustomer();
        }
        else if(text.equals("Flight Details"))
        {
            new FlightInfo();
        }
        else if(text.equals("Book Flight"))
        {
            new BookFlight();   
        }
        else if(text.equals("Journy Details"))
        {
            new JourneyDetails();
        }
        else if(text.equals("Cancel Ticket"))
        {
            new Cancel();
        }
        else if(text.equals("Boarding Pass"))
        {
            new BordingPass();
        }
    }
    
    public static void main(String [] args)
    {
        new Home();
    }
}

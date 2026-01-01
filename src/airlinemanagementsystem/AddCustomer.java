
package airlinemanagementsystem;
import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class AddCustomer extends JFrame implements ActionListener
{
    JTextField tfname,tfnationality,tfaadhar,tfaddress,tfphone;
    JRadioButton rbmale,rbfemale;
    public AddCustomer()
    {
        getContentPane().setBackground(new Color(225,182,239));
        setLayout(null);
        setSize(900,600);
        setLocation(300,150);
        setVisible(true);
        
        JLabel heading = new JLabel("Add Customer Details");
        heading.setBounds(300,20,500,35);
        heading.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        heading.setForeground(Color.blue);
        add(heading);
        
        
        JLabel lblname = new JLabel("Name :");
        lblname.setBounds(60,80,150,25);
        lblname.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
        lblname.setForeground(Color.black);
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(220,80,150,25);
        add(tfname);
        
        
        JLabel lblnationality = new JLabel("Nationality :");
        lblnationality.setBounds(60,130,150,25);
        lblnationality.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
        lblnationality.setForeground(Color.black);
        add(lblnationality);
        
        tfnationality = new JTextField();
        tfnationality.setBounds(220,130,150,25);
        add(tfnationality);
        
        
        JLabel lblaadhar = new JLabel("Aadhar No :");
        lblaadhar.setBounds(60,180,150,25);
        lblaadhar.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
        lblaadhar.setForeground(Color.black);
        add(lblaadhar);
        
        tfaadhar = new JTextField();
        tfaadhar.setBounds(220,180,150,25);
        add(tfaadhar);
        
        
        JLabel lbladdress = new JLabel("Address :");
        lbladdress.setBounds(60,230,150,25);
        lbladdress.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
        lbladdress.setForeground(Color.black);
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(220,230,150,25);
        add(tfaddress);
        
        JLabel lblgender = new JLabel("Gender :");
        lblgender.setBounds(60,280,150,25);
        lblgender.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
        lblgender.setForeground(Color.black);
        add(lblgender);
        
        ButtonGroup gendergroup = new ButtonGroup(); 
        
        
        rbmale = new JRadioButton("Male");
        rbmale.setBounds(220,280,70,25);
        rbmale.setBackground(new Color(225,182,239));
        add(rbmale);
        gendergroup.add(rbmale);
        
        rbfemale = new JRadioButton("Female");
        rbfemale.setBounds(300,280,70,25);
        rbfemale.setBackground(new Color(225,182,239));
        add(rbfemale);
        gendergroup.add(rbfemale);
        
        
        JLabel lblphone = new JLabel("Phone No :");
        lblphone.setBounds(60,330,150,25);
        lblphone.setFont(new Font("Copperplate Gothic Light", Font.PLAIN, 16));
        lblphone.setForeground(Color.black);
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(220,330,150,25);
        add(tfphone);
        
        JButton save = new JButton("SAVE");
        save.setBackground(Color.GREEN);
        save.setForeground(Color.BLACK);
        save.setBounds(220,380,150,30);
        save.setFont(new Font("Rockwell", Font.PLAIN, 15));
        save.addActionListener(this);
        add(save);
        
        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("airlinemanagementsystem/icons/add44.png"));
        JLabel lblimage = new JLabel(image);
        lblimage.setBounds(450,80,400,400);  
        add(lblimage);
            
    }
    
    
    public void actionPerformed(ActionEvent ae)
    {
        String name = tfname.getText();
        String nationality = tfnationality.getText();
        String phone = tfphone.getText();
        String aadhar = tfaadhar.getText();
        String address = tfaddress.getText();
        String gender = null;
        
        if(rbmale.isSelected())
        {
            gender = "Male";
        }
        
        else
        {
            gender = "Female";
        }
        try
        {
            Conn conn = new Conn();
            
            String query = "insert into passanger values('"+name+"', '"+nationality+"', '"+phone+"', '"+address+"', '"+aadhar+"','"+gender+"')";
            
            conn.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null,"Customer Details Added Successfully..!");
            setVisible(false);
        }
        
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public static void main(String [] args)
        {
            new AddCustomer();
        }
}

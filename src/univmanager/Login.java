/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package univmanager;

/**
 *
 * @author Metalhead
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    
    JButton login,cancel;
    JTextField tfusername,tfpassword;
    Login()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername= new JLabel("Username");
        lblusername.setBounds(40,20,100,20);
        add(lblusername);
        
        tfusername =new JTextField();
        tfusername.setBounds(150,20,150,20);
        add(tfusername);
        
        JLabel lblpassword= new JLabel("Password");
        lblpassword.setBounds(40,70,100,20);
        add(lblpassword);
        
        tfpassword =new JPasswordField();
        tfpassword.setBounds(150,70,150,20);
        add(tfpassword);
        
        login=new JButton("Login");
        login.setBounds(40,140,120,30);
        add(login);
        login.setBackground(Color.LIGHT_GRAY);
        login.setForeground(Color.BLACK);
        login.setFont(new Font("Tahoma",Font.BOLD,15));
        login.addActionListener(this);
        
        
        cancel=new JButton("Cancel");
        cancel.setBounds(180,140,120,30);
        add(cancel);
        cancel.setBackground(Color.LIGHT_GRAY); 
        cancel.setForeground(Color.BLACK);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        cancel.addActionListener(this);
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image1=new JLabel(i3);
        image1.setBounds(350,0,200,200);
        add(image1);
        
        setSize(600,300);
        setLocation(500,250);
        
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==login)
        {
            String username=tfusername.getText();
            String password=tfpassword.getText();
            
            String query="select * from login where username= '"+username+"' and password= '"+password+"'";
            
            try
            {Conn c=new Conn();
            ResultSet rs=c.s.executeQuery(query);
            
            if(rs.next())
            {
                setVisible(false);
                new Project();
            }else{
                JOptionPane.showMessageDialog(null,"Invalid Username or password");
                
            }
            }
            catch(Exception e)
            {e.printStackTrace();
                    }
        }
        else if(ae.getSource()==cancel)
        {
            setVisible(false);
        }
    }
    
    public static void main(String args[])
    {
        new Login();
    }
    
}

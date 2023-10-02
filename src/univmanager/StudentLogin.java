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

public class StudentLogin extends JFrame implements ActionListener {
    
    JButton login,cancel,adminlogin,newuser;
    JTextField tfusername,tfpassword;
    StudentLogin()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername= new JLabel("Student Userid");
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
        
        
         newuser=new JButton("New User?");
        newuser.setBounds(40,200,120,30);
        add(newuser);
        newuser.setBackground(Color.LIGHT_GRAY); 
        newuser.setForeground(Color.BLACK);
        newuser.setFont(new Font("Tahoma",Font.BOLD,15));
        newuser.addActionListener(this);
        
        adminlogin=new JButton("Admin?");
        adminlogin.setBounds(180,200,120,30);
        add(adminlogin);
        adminlogin.setBackground(Color.BLUE); 
        adminlogin.setForeground(Color.WHITE);
        adminlogin.setFont(new Font("Tahoma",Font.BOLD,15));
        adminlogin.addActionListener(this);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/student.png"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image1=new JLabel(i3);
        image1.setBounds(350,40,200,200);
        add(image1);
        
        setSize(600,350);
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
            
            String query="select * from studentlogin where suser= '"+username+"' and spass= '"+password+"'";
            
            try
            {Conn c=new Conn();
            ResultSet rs=c.s.executeQuery(query);
            
            if(rs.next())
            {
                setVisible(false);
                new StudentProject();
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
        
        else if(ae.getSource()==adminlogin)
        {
            setVisible(false);
            new Login();
            
        }
        else if(ae.getSource()==newuser)
        {
            setVisible(false);
            new NewUser();
            
        }
        
    }
    
    public static void main(String args[])
    {
        new StudentLogin();
    }
    
}

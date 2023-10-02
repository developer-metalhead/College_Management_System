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

public class NewUser extends JFrame implements ActionListener {
    
    JButton create,cancel;
    JTextField tfusername,tfpassword;
    NewUser()
    {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel lblusername= new JLabel("Set Userid");
        lblusername.setBounds(40,20,100,20);
        add(lblusername);
        
        tfusername =new JTextField();
        tfusername.setBounds(150,20,150,20);
        add(tfusername);
        
        JLabel lblpassword= new JLabel("Set Password");
        lblpassword.setBounds(40,70,100,20);
        add(lblpassword);
        
        tfpassword =new JTextField();
        tfpassword.setBounds(150,70,150,20);
        add(tfpassword);
        
        create=new JButton("Create User");
        create.setBounds(40,140,160,30);
        add(create);
        create.setBackground(Color.LIGHT_GRAY);
        create.setForeground(Color.BLACK);
        create.setFont(new Font("Tahoma",Font.BOLD,15));
        create.addActionListener(this);
        
        cancel=new JButton("Cancel");
        cancel.setBounds(210,140,160,30);
        add(cancel);
        cancel.setBackground(Color.LIGHT_GRAY); 
        cancel.setForeground(Color.BLACK);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        cancel.addActionListener(this);
        
        
        
        
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/student.png"));
        Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image1=new JLabel(i3);
        image1.setBounds(390,0,200,200);
        add(image1);
        
        setSize(610,300);
        setLocation(500,250);
        
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==create)
        {
            String username=tfusername.getText();
            String password=tfpassword.getText();
            
            
            
            try
            {
                String query="insert into studentlogin values('"+username+"','"+password+"')";
                Conn c=new Conn();
                //"insert into teacher values('"+name+"', '"+fname+"', '"+rollno+"', '"+dob+"', '"+address+"', '"+phone+"', '"+email+"', '"+x+"', '"+xii+"', '"+aadhar+"', '"+course+"', '"+branch+"')";
            
            
             c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "User Created Successfully");
                setVisible(false);
                new StudentLogin();
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
        new NewUser();
    }
    
}

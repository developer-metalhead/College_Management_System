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


public class Splash extends JFrame implements Runnable{
    

    Thread t;
    Splash() //creating constructor
    {
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/Uni.png"));
        Image i2=i1.getImage().getScaledInstance(1000,700,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image1=new JLabel(i3);
        add(image1);
        
        t = new Thread(this);
        t.start();
        
        setUndecorated(true);
        setVisible(true);
         
        
        

        
        
        setLocation(300,80);
        setSize(1000,700);
        
        
        
    }
    
     public void run() {
        try {
            Thread.sleep(5000);
            setVisible(false);
            
            // Next Frame
            new StudentLogin();
        } catch (Exception e) {
            
        }
    }
    
    public static void main(String args[])
    {
        new Splash(); //anonymous object
    }
}
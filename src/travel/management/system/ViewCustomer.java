package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewCustomer extends JFrame implements ActionListener{
    
    String username1;
    JButton btnBack;
    
    ViewCustomer(String username){
        this.username1 = username;
        
        setBounds(450, 180, 870, 450);
        getContentPane().setBackground(new Color(231, 188, 222));
        setLayout(null);
        
        JLabel lblHeading = new JLabel("User Personal Details");
        lblHeading.setBounds(300, 10, 300, 45);
        lblHeading.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(lblHeading);
        
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(80, 80, 150, 25);
        add(lblUsername);
        
        JLabel labelUsername = new JLabel("GIGIG");
        labelUsername.setBounds(240, 80, 150, 25);
        labelUsername.setForeground(new Color(22, 72, 99));
        add(labelUsername);
        
        JLabel lblId = new JLabel("Id");
        lblId.setBounds(80, 140, 150, 25);
        add(lblId);
        
        JLabel labelId = new JLabel();
        labelId.setBounds(240, 140, 150, 25);
        labelId.setForeground(new Color(22, 72, 99));
        add(labelId);
        
        JLabel lblNumber = new JLabel("Number");
        lblNumber.setBounds(80, 200, 150, 25);
        add(lblNumber);
        
        JLabel labelNumber = new JLabel();
        labelNumber.setBounds(240, 200, 150, 25);
        labelNumber.setForeground(new Color(22, 72, 99));
        add(labelNumber);
        
        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(80, 260, 150, 25);
        add(lblGender);
        
        JLabel labelGender = new JLabel();
        labelGender.setBounds(240, 260, 150, 25);
        labelGender.setForeground(new Color(22, 72, 99));
        add(labelGender);
        
        JLabel lblCountry = new JLabel("Country");
        lblCountry.setBounds(550, 80, 150, 25);
        add(lblCountry);
        
        JLabel labelCountry = new JLabel("Hiii");
        labelCountry.setBounds(700, 80, 150, 25);
        labelCountry.setForeground(new Color(22, 72, 99));
        add(labelCountry);
        
        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(550, 140, 150, 25);
        add(lblAddress);
        
        JLabel labelAddress = new JLabel();
        labelAddress.setBounds(700, 140, 150, 25);
        labelAddress.setForeground(new Color(22, 72, 99));
        add(labelAddress);
        
        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(550, 200, 150, 25);
        add(lblEmail);
        
        JLabel labelEmail = new JLabel();
        labelEmail.setBounds(700, 200, 150, 25);
        labelEmail.setForeground(new Color(22, 72, 99));
        add(labelEmail);
        
        JLabel lblPhoneNo = new JLabel("PhoneNo");
        lblPhoneNo.setBounds(550, 260, 150, 25);
        add(lblPhoneNo);
        
        JLabel labelPhoneNo = new JLabel();
        labelPhoneNo.setBounds(700, 260, 150, 25);
        labelPhoneNo.setForeground(new Color(22, 72, 99));
        add(labelPhoneNo);
        
        btnBack = new JButton("Back");
        btnBack.setBounds(350, 350, 160, 30);
        btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnBack.addActionListener(this);
        add(btnBack);
        
        try {
            DbConnection d = new DbConnection();
            ResultSet rs = d.s.executeQuery("select * from customer where username = '"+username1+"'");
            
            while(rs.next()){
                labelUsername.setText(rs.getString("username"));
                labelId.setText(rs.getString("id"));
                labelNumber.setText(rs.getString("number"));
                labelGender.setText(rs.getString("gender"));
                labelCountry.setText(rs.getString("country"));
                labelAddress.setText(rs.getString("address"));
                labelEmail.setText(rs.getString("email"));
                labelPhoneNo.setText(rs.getString("phoneNo"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == btnBack){
            setVisible(false);
        }
    } 
    
    public static void main(String[] args){
        new ViewCustomer("");
    }
}

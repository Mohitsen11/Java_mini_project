package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateCustomer extends JFrame implements ActionListener{
    
    JLabel labelUsername;
    JTextField txtNumber, txtCountry, txtAddress, txtEmail, txtPhoneNo,txtId, txtGender;
    JButton btnUpdate, btnBack;
    
    String username1;
    
    UpdateCustomer(String username){
        this.username1 = username;
        
        setBounds(450, 200, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel lblHeading = new JLabel("Update user details");
        lblHeading.setBounds(310,20,200,25);
        lblHeading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblHeading);
        
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(30,70,150,25);
        add(lblUsername);
        
        labelUsername = new JLabel();
        labelUsername.setBounds(220,70,150,25);
        add(labelUsername);
        
        JLabel lblId = new JLabel("Id");
        lblId.setBounds(30,110,150,25);
        add(lblId);
        
        txtId = new JTextField();
        txtId.setBounds(220,110,150,25);
        add(txtId);
        
        JLabel lblNumber = new JLabel("Number");
        lblNumber.setBounds(30,150,150,25);
        add(lblNumber);
        
        txtNumber = new JTextField();
        txtNumber.setBounds(220,150,150,25);
        add(txtNumber);
        
        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(30,190,150,25);
        add(lblGender);
        
        txtGender = new JTextField();
        txtGender.setBounds(220,190,150,25);
        add(txtGender);
        
        JLabel lblCountry = new JLabel("Country");
        lblCountry.setBounds(30,230,150,25);
        add(lblCountry);
        
        txtCountry = new JTextField();
        txtCountry.setBounds(220,230,150,25);
        add(txtCountry);
        
        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(30,270,150,25);
        add(lblAddress);
        
        txtAddress = new JTextField();
        txtAddress.setBounds(220,270,150,25);
        add(txtAddress);
        
        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(30,310,150,25);
        add(lblEmail);
        
        txtEmail = new JTextField();
        txtEmail.setBounds(220,310,150,25);
        add(txtEmail);
        
        JLabel lblPhoneNo = new JLabel("Phone No.");
        lblPhoneNo.setBounds(30,350,150,25);
        add(lblPhoneNo);
        
        txtPhoneNo = new JTextField();
        txtPhoneNo.setBounds(220,350,150,25);
        add(txtPhoneNo);
        
        btnUpdate = new JButton("Update");
        btnUpdate.setBackground(Color.black);
        btnUpdate.setForeground(Color.white);
        btnUpdate.setBounds(70, 430, 100, 25);
        btnUpdate.addActionListener(this);
        add(btnUpdate);
        
        btnBack = new JButton("Back");
        btnBack.setBackground(Color.black);
        btnBack.setForeground(Color.white);
        btnBack.setBounds(200, 430, 100, 25);
        btnBack.addActionListener(this);
        add(btnBack);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/update.png"));
        Image i2 = i1.getImage().getScaledInstance(400,300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,100, 450,300);
        add(image);
        
        try {
            DbConnection d = new DbConnection();
            ResultSet rs = d.s.executeQuery("select * from customer where username = '"+username1+"'");
            
            while(rs.next()){
                labelUsername.setText(rs.getString("username"));
                txtId.setText(rs.getString("id"));
                txtNumber.setText(rs.getString("number"));
                txtGender.setText(rs.getString("gender"));
                txtCountry.setText(rs.getString("country"));
                txtAddress.setText(rs.getString("address"));
                txtEmail.setText(rs.getString("email"));
                txtPhoneNo.setText(rs.getString("phoneNo"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == btnUpdate){
            
                String username = labelUsername.getText();
                String id = txtId.getText();
                String number = txtNumber.getText();
                String gender = txtGender.getText();
                String country = txtCountry.getText();
                String address = txtAddress.getText();
                String email = txtEmail.getText();
                String phoneNo = txtPhoneNo.getText();
            try {
                
                DbConnection d = new DbConnection();
                String query = "update customer set username = '"+username+"', id = '"+id+"', number = '"+number+"', gender = '"+gender+"', country =  '"+country+"', address = '"+address+"', email = '"+email+"', phoneNo = '"+phoneNo+"'";

                d.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Customer details updated successfully");
                
                setVisible(false);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new UpdateCustomer("Rohit");
    }
}

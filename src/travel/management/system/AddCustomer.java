package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AddCustomer extends JFrame implements ActionListener{
    
    JLabel labelUsername;
    JComboBox comboId;
    JTextField txtNumber, txtCountry, txtAddress, txtEmail, txtPhoneNo;
    JRadioButton rBtnMale , rBtnFemale;
    JButton btnAdd, btnBack;
    
    String username1;
    
    AddCustomer(String username){
        this.username1 = username;
        
        setBounds(450, 200, 850, 550);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        
        JLabel lblHeading = new JLabel("Add user details");
        lblHeading.setBounds(345,10,200,25);
        lblHeading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(lblHeading);
        
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(30,50,150,25);
        add(lblUsername);
        
        labelUsername = new JLabel();
        labelUsername.setBounds(220,50,150,25);
        add(labelUsername);
        
        JLabel lblId = new JLabel("Id");
        lblId.setBounds(30,90,150,25);
        add(lblId);
        
        comboId = new JComboBox(new String[] {"Passport", "Aadhar Card" , "Pan Card"});
        comboId.setBounds(220,90,150,25);
        comboId.setBackground(Color.white);
        add(comboId);
        
        JLabel lblNumber = new JLabel("Number");
        lblNumber.setBounds(30,130,150,25);
        add(lblNumber);
        
        txtNumber = new JTextField();
        txtNumber.setBounds(220,130,150,25);
        add(txtNumber);
        
        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(30,170,150,25);
        add(lblGender);
        
        rBtnMale = new JRadioButton("Male");
        rBtnMale.setBackground(Color.white);
        rBtnMale.setBounds(220, 170, 70, 25);
        add(rBtnMale);
        
        rBtnFemale = new JRadioButton("Female");
        rBtnFemale.setBackground(Color.white);
        rBtnFemale.setBounds(300, 170, 70, 25);
        add(rBtnFemale);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rBtnMale);
        bg.add(rBtnFemale);
        
        JLabel lblCountry = new JLabel("Country");
        lblCountry.setBounds(30,210,150,25);
        add(lblCountry);
        
        txtCountry = new JTextField();
        txtCountry.setBounds(220,210,150,25);
        add(txtCountry);
        
        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(30,250,150,25);
        add(lblAddress);
        
        txtAddress = new JTextField();
        txtAddress.setBounds(220,250,150,25);
        add(txtAddress);
        
        JLabel lblEmail = new JLabel("Email");
        lblEmail.setBounds(30,290,150,25);
        add(lblEmail);
        
        txtEmail = new JTextField();
        txtEmail.setBounds(220,290,150,25);
        add(txtEmail);
        
        JLabel lblPhoneNo = new JLabel("Phone No.");
        lblPhoneNo.setBounds(30,330,150,25);
        add(lblPhoneNo);
        
        txtPhoneNo = new JTextField();
        txtPhoneNo.setBounds(220,330,150,25);
        add(txtPhoneNo);
        
        btnAdd = new JButton("Add");
        btnAdd.setBackground(Color.black);
        btnAdd.setForeground(Color.white);
        btnAdd.setBounds(70, 430, 100, 25);
        btnAdd.addActionListener(this);
        add(btnAdd);
        
        btnBack = new JButton("Back");
        btnBack.setBackground(Color.black);
        btnBack.setForeground(Color.white);
        btnBack.setBounds(200, 430, 100, 25);
        btnBack.addActionListener(this);
        add(btnBack);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/newcustomer.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400,500,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,40, 450,520);
        add(image);
        
        try {
            DbConnection d = new DbConnection();
            
            ResultSet rs = d.s.executeQuery("select * from account where username = '"+username1+"'");
            while(rs.next()){
                labelUsername.setText(rs.getString("username"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == btnAdd){
            try {
                String username = labelUsername.getText();
                String id = (String) comboId.getSelectedItem();
                String number = txtNumber.getText();
                String gender = null;
                if(rBtnMale.isSelected()){
                    gender = "Male";
                }else{
                    gender = "Female";
                }
                String country = txtCountry.getText();
                String address = txtAddress.getText();
                String email = txtEmail.getText();
                String phoneNo = txtPhoneNo.getText();
                
                String query = "insert into customer values('"+username+"','"+id+"', '"+number+"', '"+gender+"', '"+country+"', '"+address+"', '"+email+"', '"+phoneNo+"')";
                
                DbConnection d = new DbConnection();
                
                d.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Customer details added successfully");
                
                setVisible(false);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            setVisible(false);
        }
    }
    
    public static void main(String[] args){
        new AddCustomer("");
    }
}

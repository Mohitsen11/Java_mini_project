package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class ForgotPassword extends JFrame implements ActionListener{
    
    // make global variables
    JTextField txtUsername, txtSecurity, txtAnswer, txtPassword;
    JButton btnSearch, btnRetrieve, btnBack;
    
    ForgotPassword(){
        setBounds(350, 200, 900, 400);
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/forgotpassword.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(630, 75, 200, 200);
        add(image);
        
        JPanel p1 = new JPanel();
        p1.setBounds(30, 30, 550, 300);
        p1.setLayout(null);
        add(p1);
        
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblUsername.setBounds(50, 20, 100, 25);
        p1.add(lblUsername);
        
        txtUsername = new JTextField();
        txtUsername.setBounds(200, 20, 150, 25);
        txtUsername.setBorder(BorderFactory.createBevelBorder(4));
        p1.add(txtUsername);
        
        btnSearch = new JButton("Search");
        btnSearch.setBounds(360, 20, 100,25);
        btnSearch.setBackground(Color.GRAY);
        btnSearch.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnSearch.setBorder(BorderFactory.createBevelBorder(4));
        btnSearch.setForeground(Color.white);
        btnSearch.addActionListener(this);
        p1.add(btnSearch);
        
        JLabel lblSecurity = new JLabel("Security question");
        lblSecurity.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblSecurity.setBounds(50, 80, 150, 25);
        p1.add(lblSecurity);
        
        txtSecurity = new JTextField();
        txtSecurity.setBounds(200, 80, 150, 25);
        txtSecurity.setBorder(BorderFactory.createBevelBorder(4));
        p1.add(txtSecurity);
        
        JLabel lblAnswer = new JLabel("Answer");
        lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAnswer.setBounds(50, 140, 150, 25);
        p1.add(lblAnswer);
        
        txtAnswer = new JTextField();
        txtAnswer.setBounds(200, 140, 150, 25);
        txtAnswer.setBorder(BorderFactory.createBevelBorder(4));
        p1.add(txtAnswer);
        
        btnRetrieve = new JButton("Retrieve");
        btnRetrieve.setBounds(360, 140, 100,25);
        btnRetrieve.setBackground(Color.GRAY);
        btnRetrieve.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnRetrieve.setBorder(BorderFactory.createBevelBorder(4));
        btnRetrieve.setForeground(Color.white);
        btnRetrieve.addActionListener(this);
        p1.add(btnRetrieve);
        
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPassword.setBounds(50, 200, 150, 25);
        p1.add(lblPassword);
        
        txtPassword = new JTextField();
        txtPassword.setBounds(200, 200, 150, 25);
        txtPassword.setBorder(BorderFactory.createBevelBorder(4));
        p1.add(txtPassword);
        
        btnBack = new JButton("Back");
        btnBack.setBounds(220, 260, 100,25);
        btnBack.setBackground(Color.GRAY);
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnBack.setBorder(BorderFactory.createBevelBorder(4));
        btnBack.setForeground(Color.white);
        btnBack.addActionListener(this);
        p1.add(btnBack);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == btnSearch){
            try {
                String query = "select * from account where username = '"+txtUsername.getText()+"'";
                
                DbConnection d = new DbConnection();
                ResultSet rs = d.s.executeQuery(query);
                
                while(rs.next()){
                    txtSecurity.setText(rs.getString("security"));
                }
                
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(ae.getSource() == btnRetrieve){
             try {
                String query = "select * from account where answer = '"+txtAnswer.getText()+"' AND username = '"+txtUsername.getText()+"'";
                
                DbConnection d = new DbConnection();
                ResultSet rs = d.s.executeQuery(query);
                
                while(rs.next()){
                    txtPassword.setText(rs.getString("password"));
                }
                 
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            setVisible(false);
            new Login();
        }
    }
    
    public static void main(String[] args){
        new ForgotPassword();
    }
}

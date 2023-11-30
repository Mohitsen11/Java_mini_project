package travel.management.system;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    // make buttons global
    JButton btnSignUp, btnForgotPass, btnLogin;
    JTextField txtUsername, txtPassword; 
    Login(){
        setSize(900, 400);
        setLocation(350, 200);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(116, 100, 188));
        p1.setLayout(null);
        p1.setBounds(0, 0, 400, 400);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/login.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(100, 80, 200, 200);
        p1.add(image);
        
        JPanel p2 = new JPanel();
        p2.setBackground(new Color(222, 217, 238));
        p2.setLayout(null);
        p2.setBounds(400, 0, 500, 400);
        add(p2);
        
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBounds(60, 20, 100, 25);
        lblUsername.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        p2.add(lblUsername);
        
        txtUsername = new JTextField();
        txtUsername.setBounds(60, 60, 300, 30);
        txtUsername.setBorder(BorderFactory.createBevelBorder(4));
        p2.add(txtUsername);
        
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setBounds(60, 110, 100, 25);
        lblPassword.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
        p2.add(lblPassword);
        
        txtPassword = new JTextField();
        txtPassword.setBounds(60, 150, 300, 30);
        txtPassword.setBorder(BorderFactory.createBevelBorder(4));
        p2.add(txtPassword);
        
        btnLogin = new JButton("Login");
        btnLogin.setBounds(60, 210, 300,30);
        btnLogin.setBackground(new Color(116, 100, 188));
        btnLogin.setBorder(BorderFactory.createBevelBorder(4));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.addActionListener(this);
        p2.add(btnLogin);
        
        JLabel txtSignUp = new JLabel("New Registration");
        txtSignUp.setBounds(100, 260, 100, 30);
        txtSignUp.setFont(new Font("SAN_SERIF", Font.BOLD, 12));
        p2.add(txtSignUp);
        
        
        btnSignUp = new JButton("Register here");
        btnSignUp.setBounds(200, 260, 130,30);
        btnSignUp.setBackground(new Color(116, 100, 188));
        btnSignUp.setBorder(BorderFactory.createBevelBorder(4));
        btnSignUp.setForeground(Color.WHITE);
        btnSignUp.addActionListener(this);
        p2.add(btnSignUp);
        
        JLabel txtForgotPass = new JLabel("Forgotten Pass ?");
        txtForgotPass.setBounds(100, 310, 100, 30);
        txtForgotPass.setFont(new Font("SAN_SERIF", Font.BOLD, 12));
        p2.add(txtForgotPass);
        
        btnForgotPass = new JButton("Forgot Password");
        btnForgotPass.setBounds(200, 310, 130,30);
        btnForgotPass.setBackground(new Color(116, 100, 188));
        btnForgotPass.setBorder(BorderFactory.createBevelBorder(4));
        btnForgotPass.setForeground(Color.WHITE);
        btnForgotPass.addActionListener(this);
        p2.add(btnForgotPass);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == btnLogin){
            try{
                String username = txtUsername.getText();
                String password = txtPassword.getText();
                
                String query = "select * from account where username = '"+username+"' AND password = '"+password+"'";
                
                DbConnection d = new DbConnection();
                
                ResultSet rs = d.s.executeQuery(query);
                
                if(rs.next()){
                    setVisible(false);
                    new Loading(username);
                } else{
                    JOptionPane.showMessageDialog(null, "Incorrect username or password");
                }
            } catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == btnSignUp){
           setVisible(false);
            new Signup();
        }else{
             setVisible(false);
            new ForgotPassword();
        }
    }
    
    public static void main(String[] args){
        new Login();
    }
}

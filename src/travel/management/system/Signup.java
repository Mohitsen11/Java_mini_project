package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Signup extends JFrame implements ActionListener{
    
    // make buttons global 
    JButton btnCreate, btnBack;
    JTextField txtUsername, txtPassword, txtAnswer;
    Choice security;
    
    Signup(){
        setBounds(350, 200, 900, 400);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBounds(0, 0, 500, 400);
        p1.setBackground(new Color(116, 100, 188));
        p1.setLayout(null);
        add(p1);
        
        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblUsername.setForeground(new Color(222, 217, 238));
        lblUsername.setBounds(70, 50, 125, 25);
        p1.add(lblUsername);
        
        txtUsername = new JTextField();
        txtUsername.setBounds(200, 50, 180, 25);
        txtUsername.setBorder(BorderFactory.createBevelBorder(4));
        p1.add(txtUsername);
        
        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblPassword.setForeground(new Color(222, 217, 238));
        lblPassword.setBounds(70, 100, 125, 25);
        p1.add(lblPassword);
        
        txtPassword = new JTextField();
        txtPassword.setBounds(200, 100, 180, 25);
        txtPassword.setBorder(BorderFactory.createBevelBorder(4));
        p1.add(txtPassword);
        
        JLabel lblSecurity = new JLabel("Security Ques");
        lblSecurity.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblSecurity.setForeground(new Color(222, 217, 238));
        lblSecurity.setBounds(70, 150, 125, 25);
        p1.add(lblSecurity);
        
        security = new Choice();
        security.add("What is your favorite movie?");
        security.add("What is your favorite color?");
        security.add("Your favorite City?");
        security.setBounds(200, 153, 180, 30);
        p1.add(security);
        
        JLabel lblAnswer = new JLabel("Answer");
        lblAnswer.setFont(new Font("Tahoma", Font.BOLD, 14));
        lblAnswer.setForeground(new Color(222, 217, 238));
        lblAnswer.setBounds(70, 200, 125, 25);
        p1.add(lblAnswer);
        
        txtAnswer = new JTextField();
        txtAnswer.setBounds(200, 200, 180, 25);
        txtAnswer.setBorder(BorderFactory.createBevelBorder(4));
        p1.add(txtAnswer);
        
        btnCreate = new JButton("Register");
        btnCreate.setBounds(100, 270, 100,30);
        btnCreate.setBackground(new Color(164, 92, 252));
        btnCreate.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnCreate.setBorder(BorderFactory.createBevelBorder(4));
        btnCreate.setForeground(Color.WHITE);
        btnCreate.addActionListener(this);
        p1.add(btnCreate);
        
        btnBack = new JButton("Back");
        btnBack.setBounds(250, 270, 100,30);
        btnBack.setBackground(new Color(164, 92, 252));
        btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnBack.setBorder(BorderFactory.createBevelBorder(4));
        btnBack.setForeground(Color.WHITE);
        btnBack.addActionListener(this);
        p1.add(btnBack);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/signup.png"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(595, 75, 200, 200);
        add(image);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == btnCreate){
            String username = txtUsername.getText();
            String password = txtPassword.getText();
            String securityQuestion = security.getSelectedItem();
            String answer = txtAnswer.getText();
            
            String query = "insert into account values('"+username+"', '"+password+"', '"+securityQuestion+"', '"+answer+"')";
            
            try {
                DbConnection d = new DbConnection();
                d.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Account created successfully");
                
                setVisible(false);
                new Login();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(ae.getSource() == btnBack){
            setVisible(false);
            new Login();
        }
        
    }
    
    public static void main(String[] args){
        new Signup();
    }
}

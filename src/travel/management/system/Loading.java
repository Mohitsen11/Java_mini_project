package travel.management.system;

import java.awt.*;
import javax.swing.*;

public class Loading extends JFrame implements Runnable{
    Thread t;
    JProgressBar progrsBar;
    String username;
    
    public void run(){
        try{
            for(int i=1; i<=101; i++){
                int max = progrsBar.getMaximum(); // 100
                int value = progrsBar.getValue();
                
                if(value < max){
                    progrsBar.setValue(progrsBar.getValue()+1);
                }else{
                    setVisible(false);
                    new Dashboard(username);
                }
                Thread.sleep(20);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    Loading(String username){
        t = new Thread(this);
        this.username = username;
        
        setBounds(500, 200, 650, 400);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel txtHeading = new JLabel("Travel and Tourism Application");
        txtHeading.setBounds(50, 20, 600, 40);
        txtHeading.setForeground(new Color(116, 100, 188));
        txtHeading.setFont(new Font("Raleway", Font.BOLD, 35));
        add(txtHeading);
        
        progrsBar = new JProgressBar();
        progrsBar.setBounds(170, 100, 300, 35);
        progrsBar.setStringPainted(true);
        add(progrsBar);
        
        JLabel txtLoadingSlogan = new JLabel("Loading, please wait..");
        txtLoadingSlogan.setBounds(220, 140, 200, 30);
        txtLoadingSlogan.setForeground(new Color(116, 100, 188));
        txtLoadingSlogan.setFont(new Font("Raleway", Font.BOLD, 18));
        add(txtLoadingSlogan);
        
        JLabel txtUsername = new JLabel("Welcome " + username);
        txtUsername.setBounds(20, 310, 400, 40);
        txtUsername.setForeground(new Color(9,1,13));
        txtUsername.setFont(new Font("Raleway", Font.BOLD, 16));
        add(txtUsername);
        
        t.start();
        setVisible(true);
    }
    
    public static void main(String[] args){
        new Loading("");
    }
}

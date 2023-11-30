package travel.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dashboard extends JFrame implements ActionListener{
    
    String username;
    JButton btnAddDetails,btnUpdateDetails, btnViewDetails, btnDeleteDetails, btnCheckPackages, btnBookPackages, 
            btnViewPackages, btnViewHotels,btnDestinations,btnBookHotel,btnViewBookedHotel,btnAbout;
    
    Dashboard(String username){
        this.username = username;
        
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(116, 100, 188));
        p1.setBounds(0, 0, 1600, 65);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard1.png"));
        Image i2 = i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);
        icon.setBounds(5,0, 70,70);
        p1.add(icon);
        
        JLabel lblHeading = new JLabel("Dashboard");
        lblHeading.setBounds(80,15,300,40);
        lblHeading.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblHeading.setForeground(Color.white);
        p1.add(lblHeading);
        
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(116, 100, 188));
        p2.setBounds(0, 65, 300, 900);
        add(p2);
        
        btnAddDetails = new JButton("Add Personal Details");
        btnAddDetails.setBounds(0, 0, 300, 50);
        btnAddDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnAddDetails.setBackground(new Color(90, 24, 154));
        btnAddDetails.setForeground(Color.white);
        btnAddDetails.setMargin(new Insets(0,0,0,60));
        btnAddDetails.addActionListener(this);
        p2.add(btnAddDetails);
        
        btnUpdateDetails = new JButton("Update Personal Details");
        btnUpdateDetails.setBounds(0, 50, 300, 50);
        btnUpdateDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnUpdateDetails.setBackground(new Color(90, 24, 154));
        btnUpdateDetails.setForeground(Color.white);
        btnUpdateDetails.setMargin(new Insets(0,0,0,35));
        btnUpdateDetails.addActionListener(this);
        p2.add(btnUpdateDetails);
        
        btnViewDetails = new JButton("View Personal Details");
        btnViewDetails.setBounds(0, 100, 300, 50);
        btnViewDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnViewDetails.setBackground(new Color(90, 24, 154));
        btnViewDetails.setForeground(Color.white);
        btnViewDetails.setMargin(new Insets(0,0,0,53));
        btnViewDetails.addActionListener(this);
        p2.add(btnViewDetails);
        
        btnDeleteDetails = new JButton("Delete Personal Details");
        btnDeleteDetails.setBounds(0, 150, 300, 50);
        btnDeleteDetails.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnDeleteDetails.setBackground(new Color(90, 24, 154));
        btnDeleteDetails.setForeground(Color.white);
        btnDeleteDetails.setMargin(new Insets(0,0,0,40));
        btnDeleteDetails.addActionListener(this);
        p2.add(btnDeleteDetails);
        
        btnCheckPackages = new JButton("Check Packages");
        btnCheckPackages.setBounds(0, 200, 300, 50);
        btnCheckPackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnCheckPackages.setBackground(new Color(90, 24, 154));
        btnCheckPackages.setForeground(Color.white);
        btnCheckPackages.setMargin(new Insets(0,0,0,102));
        btnCheckPackages.addActionListener(this);
        p2.add(btnCheckPackages);
        
        btnBookPackages = new JButton("Book Packages");
        btnBookPackages.setBounds(0, 250, 300, 50);
        btnBookPackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnBookPackages.setBackground(new Color(90, 24, 154));
        btnBookPackages.setForeground(Color.white);
        btnBookPackages.setMargin(new Insets(0,0,0,110));
        btnBookPackages.addActionListener(this);
        p2.add(btnBookPackages);
        
        btnViewPackages = new JButton("View Packages");
        btnViewPackages.setBounds(0, 300, 300, 50);
        btnViewPackages.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnViewPackages.setBackground(new Color(90, 24, 154));
        btnViewPackages.setForeground(Color.white);
        btnViewPackages.setMargin(new Insets(0,0,0,110));
        btnViewPackages.addActionListener(this);
        p2.add(btnViewPackages);
        
        btnViewHotels = new JButton("View Hotels");
        btnViewHotels.setBounds(0, 350, 300, 50);
        btnViewHotels.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnViewHotels.setBackground(new Color(90, 24, 154));
        btnViewHotels.setForeground(Color.white);
        btnViewHotels.setMargin(new Insets(0,0,0,135));
        btnViewHotels.addActionListener(this);
        p2.add(btnViewHotels);
        
        btnBookHotel = new JButton("Book Hotel");
        btnBookHotel.setBounds(0, 400, 300, 50);
        btnBookHotel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnBookHotel.setBackground(new Color(90, 24, 154));
        btnBookHotel.setForeground(Color.white);
        btnBookHotel.setMargin(new Insets(0,0,0,145));
        btnBookHotel.addActionListener(this);
        p2.add(btnBookHotel);
        
        btnViewBookedHotel = new JButton("View Booked Hotel");
        btnViewBookedHotel.setBounds(0, 450, 300, 50);
        btnViewBookedHotel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnViewBookedHotel.setBackground(new Color(90, 24, 154));
        btnViewBookedHotel.setForeground(Color.white);
        btnViewBookedHotel.setMargin(new Insets(0,0,0,75));
        btnViewBookedHotel.addActionListener(this);
        p2.add(btnViewBookedHotel);
        
        btnDestinations = new JButton("Destinations");
        btnDestinations.setBounds(0, 500, 300, 50);
        btnDestinations.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnDestinations.setBackground(new Color(90, 24, 154));
        btnDestinations.setForeground(Color.white);
        btnDestinations.setMargin(new Insets(0,0,0,135));
        btnDestinations.addActionListener(this);
        p2.add(btnDestinations);
        
        btnAbout = new JButton("About");
        btnAbout.setBounds(0, 550, 300, 50);
        btnAbout.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnAbout.setBackground(new Color(90, 24, 154));
        btnAbout.setForeground(Color.white);
        btnAbout.setMargin(new Insets(0,0,0,190));
        btnAbout.addActionListener(this);
        p2.add(btnAbout);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650,1000,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);
        image.setBounds(0,0, 1650,1000);
        add(image);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == btnAddDetails){
            new AddCustomer(username);
        }else if(ae.getSource() == btnViewDetails){
            new ViewCustomer(username);
        }else if(ae.getSource() == btnDeleteDetails){
            new DeleteCustomer(username);
        }else if(ae.getSource() == btnUpdateDetails){
            new UpdateCustomer(username);
        }else if(ae.getSource() == btnCheckPackages){
            new CheckPackage();
        }else if(ae.getSource() == btnBookPackages){
            new BookPackage(username);
        }else if(ae.getSource() == btnViewPackages){
            new ViewPackage(username);
        }else if(ae.getSource() == btnViewHotels){
            new CheckHotels();
        }else if(ae.getSource() == btnDestinations){
            new Destination();
        }else if(ae.getSource() == btnBookHotel){
            new BookHotel(username);
        }else if(ae.getSource() == btnViewBookedHotel){
            new ViewBookedHotel(username);
        }else{
            new About();
        }
            
    }
    
    public static void main(String[] args){
        new Dashboard("");
    }

}

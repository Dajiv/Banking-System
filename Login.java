import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class Login extends JFrame{
  JPanel jP1,jP2,jP3;
  JLabel jL1;
  JTextField jT1,jT2;
  JPasswordField jPF1;
  JButton jB1,jB2;
  

    Login(){
      setSize(300, 250);
      setLayout(new BorderLayout());

      toolset();

      add(jP1, BorderLayout.NORTH);
      add(jP2, BorderLayout.CENTER);
      add(jP3, BorderLayout.SOUTH);
   
      setVisible(true);
    }


    public void toolset(){

     jP1 = new JPanel(); jP1.setBackground(new Color(30,30,40));
     jP2 = new JPanel(); jP2.setBackground(new Color(30,30,40));
     jP3 = new JPanel(); jP3.setBackground(new Color(30,30,40));

     jP1.add(jL1 = new JLabel("Staff Login Form"));
     jL1.setFont(new Font("Segoe UI",Font.BOLD,20));
     jL1.setForeground(new Color(100,180,255));
     
     jP2.setLayout(new GridLayout(3,2,10,10));

     jP2.add(new JLabel(" Staff ID"));
     jP2.add(jT1 = new JTextField());
     

     jP2.add(new JLabel(" Password"));
     jP2.add(jPF1 = new JPasswordField());
     

     jP2.add(new JLabel(" NIC Number"));
     jP2.add(jT2 = new JTextField());
     
     jT1.setBorder(new LineBorder(Color.WHITE,2));
     jPF1.setBorder(new LineBorder(Color.WHITE,2));
     jT2.setBorder(new LineBorder(Color.WHITE,2));

  
     jP3.add(jB1 = new JButton("SUBMIT")); 
     jB1.setBackground(new Color(46,204,113));
     jB1.setForeground(Color.WHITE);
     jB1.setFont(new Font("Segoe UI", Font.BOLD, 14));
     jB1.setFocusPainted(false);
     jB1.setBorderPainted(false);
     jB1.putClientProperty("JButton.buttonType", "roundRect");

     jP3.add(jB2 = new JButton("CLEAR")); 
     jB2.setBackground(new Color(231,76,60));
     jB2.setForeground(Color.WHITE);
     jB2.setFont(new Font("Segoe UI", Font.BOLD, 14));
     jB2.setFocusPainted(false);
     jB2.setBorderPainted(false);
     jB2.putClientProperty("JButton.buttonType", "roundRect");

     String[] Staff_ID = {"111","222","333"};
     String[] NIC_crt = {"200701900902","200801900902","200901900902"};
     char[][] Password = {
                       {'!','!','!'} ,
                       {'@','@','@'} ,
                       {'#','#','#'}
     };
      
      int size = Staff_ID.length;

      jB1.addActionListener(submit->{
       String Enterd_ID = jT1.getText(); 
       char[] Entered_Password = jPF1.getPassword();
       String stored_Password = new String(Entered_Password);
       String Enterd_NIC = jT2.getText(); 


       try{
         Connection con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/staff_logindb",
          "root",
          "Ud1902!"
        );

          String query = "Insert into staff(staff_ID,Password,NIC) values(?,?,?)";
          PreparedStatement ps = con.prepareStatement(query);

          ps.setString(1,Enterd_ID);
          ps.setString(2,stored_Password);
          ps.setString(3,Enterd_NIC);

          ps.executeUpdate();
          System.out.println("Success!");
          con.close();

       }
        catch(Exception e){
          System.out.println(e);
        }
      
       int i=0;
       
       while ( i<size) {
        String pass = new String(Password[i]);

        if(Enterd_ID.equals(Staff_ID[i]) && stored_Password.equals(pass) && Enterd_NIC.equals(NIC_crt[i])){
          this.dispose();
          new Account();
          
        }
        
       i=i+1;
       }

     });

     jB2.addActionListener(clear->{
        jT1.setText(" ");
        jPF1.setText(" ");
        jT2.setText(" ");
     });

    }
}

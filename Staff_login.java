import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Staff_login extends JFrame{
  JPanel jP1,jP2,jP3;
  JTextField jT1,jT2;
  JPasswordField jPF1;
  JButton jB1,jB2;
  

    Staff_login(){
      setSize(300, 250);
      setLayout(new BorderLayout());

      toolset();

      add(jP1, BorderLayout.NORTH);
      add(jP2, BorderLayout.CENTER);
      add(jP3, BorderLayout.SOUTH);
   
      setVisible(true);
    }


    public void toolset(){

     jP1 = new JPanel(); jP1.setBackground(Color.CYAN);
     jP2 = new JPanel(); jP2.setBackground(Color.CYAN);
     jP3 = new JPanel(); jP3.setBackground(Color.CYAN);

     jP1.add(new JLabel("Staff Login Form"));
     
     jP2.setLayout(new GridLayout(3,2,10,10));

     jP2.add(new JLabel(" Staff ID"));
     jP2.add(jT1 = new JTextField());
     jP2.add(new JLabel(" Password"));
     jP2.add(jPF1 = new JPasswordField());
     jP2.add(new JLabel(" NIC Number"));
     jP2.add(jT2 = new JTextField());

     jP3.add(jB1 = new JButton("SUBMIT")); jB1.setBackground(Color.GREEN);
     jP3.add(jB2 = new JButton("CLEAR")); jB2.setBackground(Color.RED);

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
      
       int i=0;
       
       while ( i<size) {
        String pass = new String(Password[i]);

        if(Enterd_ID.equals(Staff_ID[i]) && stored_Password.equals(pass) && Enterd_NIC.equals(NIC_crt[i])){
          this.dispose();
          new account();
          
        }
        
       i=i+1;
       }

     });

     jB2.addActionListener(clear->{
        jT1.setText(" ");
        jPF1.setText("");
        jT2.setText(" ");
     });

    }
}

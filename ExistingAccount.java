import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExistingAccount extends JFrame{
 JPanel jP1,jP2,bgL,jP3;
 JTextField jT1,jT2,jT3,jT4;
 JRadioButton jR1,jR2;
 ButtonGroup bg;
 JButton jB1;

    ExistingAccount(){
      setSize(400,300);
      setLayout(new BorderLayout());
      toolset();

      add(jP1,BorderLayout.NORTH);
      add(jP2,BorderLayout.CENTER);
      add(jP3,BorderLayout.SOUTH);

      setVisible(true);
    }
    public void toolset(){
      jP1 = new JPanel();
      jP2 = new JPanel();
      jP3 = new JPanel();

      jP1.add(new JLabel("Old Account"));

      bgL = new JPanel();
      bg = new ButtonGroup();
      bgL.setLayout(new FlowLayout(FlowLayout.LEFT));
    

      jP2.setLayout(new GridLayout(6,2,10,10));

      jP2.add(new JLabel("Staff_ID"));
      jP2.add(jT1 = new JTextField());
      jP2.add(new JLabel("Account No"));
      jP2.add(jT2 = new JTextField());
      jP2.add(new JLabel("Date"));
      jP2.add(jT3 = new JTextField());
      jP2.add(new JLabel("Time"));
      jP2.add(jT3 = new JTextField());
      jP2.add(new JLabel("Activity Type"));
      bg.add(jR1 = new JRadioButton("Deposit"));
      bgL.add(jR1);
      bg.add(jR2 = new JRadioButton("Withdrawal"));
      bgL.add(jR2);
      jP2.add(bgL);
      jP2.add(new JLabel("Amount"));
      jP2.add(jT4 = new JTextField());
      jP3.add(jB1 = new JButton("SUBMIT"));  jB1.setBackground(Color.GREEN);

      String[] Staff_ID = {"111","222","333"};
      String[] Acc_No = {"1111111111","222222222","3333333333"};


      int size = Staff_ID.length;

      jB1.addActionListener(e->{
        
        String Enterd_ID = jT1.getText(); 
        String Enterd_No = jT2.getText();
        

    
       int i = 0;
       
       while ( i<size) {
        

        if(Enterd_ID.equals(Staff_ID[i])&&Enterd_No.equals(Acc_No[i])){
          System.out.println("Success");
          if(jR1.isSelected()){
            System.out.println("Deposite");
          }else if(jR2.isSelected()){
            System.out.println("Withdrawel");
          }
          
          
        }
        
       i=i+1;
       }
      });
      
    

     
     
    }
}

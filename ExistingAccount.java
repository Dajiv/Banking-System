import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.border.LineBorder;

public class ExistingAccount extends JFrame{
 JPanel jP1,jP2,bgL,jP3;
 JTextField jT1,jT2,jT3,jT4,jT5;
 JRadioButton jR1,jR2;
 ButtonGroup bg;
 JButton jB1,jB2;

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
      
      LocalDateTime now =LocalDateTime.now();
      DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
      jT3.setText(now.format(dtf));
      jT3.setEditable(false);

      jP2.add(new JLabel("Time"));
      jP2.add(jT4 = new JTextField());

      DateTimeFormatter tf = DateTimeFormatter.ofPattern("HH:mm:ss");
      jT4.setText(now.format(tf));
      jT4.setEditable(false);

      jP2.add(new JLabel("Activity Type"));
      bg.add(jR1 = new JRadioButton("Deposit"));
      bgL.add(jR1);
      bg.add(jR2 = new JRadioButton("Withdrawal"));
      bgL.add(jR2);
      jP2.add(bgL);
      jP2.add(new JLabel("Amount"));
      jP2.add(jT5 = new JTextField());

      jT1.setBorder(new LineBorder(Color.WHITE,2));
      jT2.setBorder(new LineBorder(Color.WHITE,2));
      jT3.setBorder(new LineBorder(Color.WHITE,2));
      jT4.setBorder(new LineBorder(Color.WHITE,2));
      jT5.setBorder(new LineBorder(Color.WHITE,2));

      jP3.add(jB1 = new JButton("SUBMIT"));  
      jB1.setBackground(Color.GREEN);
      jB1.setForeground(Color.WHITE);
      jP3.add(jB2 = new JButton("EXIT"));
       jB2.setBackground(Color.RED);
       jB2.setForeground(Color.WHITE);

      String[] Staff_ID = {"111","222","333"};
      String[] Acc_No = {"1111111111","222222222","3333333333"};


      int size = Staff_ID.length;

      jB1.addActionListener(B1->{
        
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

      jB2.addActionListener(jB2->{
        this.dispose();
        new Account();
      });
      
    

     
     
    }
}

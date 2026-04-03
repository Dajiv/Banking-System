import javax.swing.*;
import java.awt.*;

class Account extends JFrame{
  JPanel jP1;
  JButton jB1,jB2;

    Account(){
       setSize(250,300);
       setLayout(new BorderLayout());
       toolset();
       add(jP1);
       
       
       setVisible(true);
    }
    public void toolset(){
        jP1 = new JPanel(); 
        jP1.setLayout(new GridLayout(2,0,10,10));
        jP1.add(jB1 = new JButton("New account")); 
        jB1.setBackground(new Color(46,204,113));
        jB1.setForeground(Color.WHITE);

        jP1.add(jB2 = new JButton("Existing account"));
        jB2.setBackground(new Color(46,204,113));
        jB2.setForeground(Color.WHITE);

        jB1.addActionListener(b1->{
            this.dispose();
            new NewAccount();
        });

        jB2.addActionListener(b2->{
            this.dispose();
            new ExistingAccount();
        });
    }
}

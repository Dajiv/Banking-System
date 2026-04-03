import javax.swing.*;
import java.awt.*;

class account extends JFrame{
  JPanel jP1;
  JButton jB1,jB2;

    account(){
       setSize(250,300);
       setLayout(new BorderLayout());
       toolset();
       add(jP1);
       
       
       setVisible(true);
    }
    public void toolset(){
        jP1 = new JPanel(); jP1.setBackground(Color.CYAN);
        jP1.setLayout(new GridLayout(2,0,10,10));
        jP1.add(jB1 = new JButton("New account")); jB1.setBackground(Color.GREEN);
        jP1.add(jB2 = new JButton("Existing account")); jB2.setBackground(Color.GREEN);
        
        jB1.addActionListener(b1->{
            this.dispose();
            new new_acc();
        });

        jB2.addActionListener(b2->{
            this.dispose();
            new Existing_acc();
        });
    }
}

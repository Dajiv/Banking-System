import javax.swing.*;
import java.awt.*;
import java.beans.JavaBean;

class NewAccount extends JFrame{
 JPanel jP1,jP2,jP3;
 JTextField jT1,jT2,jT3,jT4;
 JComboBox jCB1;
 JButton jB1,jB2;

    NewAccount(){
     setSize(250,300);
     setLayout(new BorderLayout());
     toolset();

     add(jP1, BorderLayout.NORTH);
     add(jP2,BorderLayout.CENTER);
     add(jP3,BorderLayout.SOUTH);

     setVisible(true);
    }
    public void toolset(){
      jP1 = new JPanel();
      jP2 = new JPanel();
      jP3 = new JPanel();

      jP1.add(new JLabel("New account"));

      String acc_type[] = {"Saving account","Current account"};

      jP2.setLayout(new GridLayout(0,2,10,10));

      jP2.add(new JLabel("Holder Name"));
      jP2.add(jT1 = new JTextField());
      jP2.add(new JLabel("Postal Address"));
      jP2.add(jT2 = new JTextField());
      jP2.add(new JLabel("Phone Number"));
      jP2.add(jT3 = new JTextField(10));
      jP2.add(new JLabel("NIC"));
      jP2.add(jT4 = new JTextField());
      jP2.add(new JLabel("Account Type"));
      jP2.add(jCB1 = new JComboBox<>(acc_type));

      jP3.add(jB1 = new JButton("SUBMIT"));
      jP3.add(jB2 = new JButton("EXIT")); jB2.setBackground(Color.RED);

      jB1.addActionListener(jB1->{

        String Holder_Name = jT1.getText();
        String Postal_Address = jT2.getText();
        String Phone_Number = jT3.getText();
        String NIC = jT4.getText();
        String account_type = (String) jCB1.getSelectedItem();

        JOptionPane.showMessageDialog(null, Holder_Name+"\n"+Postal_Address+"\n"+ Phone_Number+"\n"+NIC+"\n"+account_type);
      });

      jB2.addActionListener(jB2->{
        this.dispose();
        new Account();

      });
    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Withdrawal extends JFrame implements ActionListener {

    JButton withdrawal,back;
    JTextField amount;
    String pinnumber;

    Withdrawal(String pinnumber){
        this.pinnumber = pinnumber;

        setSize(800,800);
        setLocation(300,0);
        setLayout(null);

        ImageIcon i1 = new ImageIcon("D:\\Bank management system\\icons\\atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(800,800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to Withdraw");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,14));
        text.setBounds(150,300,300,20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway",Font.BOLD,22));
        amount.setBounds(150,340,300,25);
        image.add(amount);

        withdrawal = new JButton("Withdraw");
        withdrawal.setBounds(350,460,100,25);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        back = new JButton("Back");
        back.setBounds(350,490,100,25);
        back.addActionListener(this);
        image.add(back);

        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == withdrawal){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount you want to withdraw");
            }else{
                try{
                    Conn conn = new Conn();
                    String query = "insert into bank values('"+pinnumber+"' ,'"+date+"', 'Withdraw' ,'"+number+"')";

                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs "+number+" Withdraw Successfully");
                    setVisible(false);
                    new Transcations(pinnumber).setVisible(true);
                } catch (Exception e){
                    System.out.println(e);
                }
            }

        } else if(ae.getSource() == back){
            setVisible(false);
            new Transcations((pinnumber)).setVisible(true);
        }
    }
    public static void main(String [] args){
        new Withdrawal("");
    }
}
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JButton back;
    String pinnumber;
    BalanceEnquiry(String pinnumber){
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

        back = new JButton("Back");
        back.setBounds(350,490,100,25);
        back.addActionListener(this);
        image.add(back);

        Conn c = new Conn();
        int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pinnumber + "'");

            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
        } catch (Exception e){
            System.out.println(e);
        }

        JLabel text = new JLabel("Your Current Account balance is Rs "+balance);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway",Font.BOLD,12));
        text.setBounds(150,300,300,25);
        image.add(text);

        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transcations(pinnumber).setVisible(true);
    }
    public static void main(String [] args){
        new BalanceEnquiry("");
    }
}

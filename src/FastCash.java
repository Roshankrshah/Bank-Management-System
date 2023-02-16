import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton deposit, withdrawl,ministatement,pinchange,exit,fastcash,balanceenquiry;
    String pinnumber;
    FastCash(String pinnumber){
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

        JLabel text = new JLabel("Select Withdrawal Amount");
        text.setBounds(200,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        deposit = new JButton("Rs 100");
        deposit.setBounds(145,395,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("Rs 500");
        withdrawl.setBounds(305,395,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash = new JButton("Rs 1000");
        fastcash.setBounds(145,428,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Rs 2000");
        ministatement.setBounds(305,428,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("Rs 5000");
        pinchange.setBounds(145,461,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquiry = new JButton("Rs 10000");
        balanceenquiry.setBounds(305,461,150,30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        exit = new JButton("Back");
        exit.setBounds(305,495,150,30);
        exit.addActionListener(this);
        image.add(exit);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== exit){
            setVisible(false);
            new Transcations(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource() !=exit && balance <Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"','"+date+"','Withdraw', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+ amount+" Debited Succesfully");

                setVisible(false);
                new Transcations(pinnumber).setVisible(true);
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String [] args){
        new FastCash("");
    }
}

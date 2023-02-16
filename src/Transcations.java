import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transcations extends JFrame implements ActionListener {

    JButton deposit, withdrawl,ministatement,pinchange,exit,fastcash,balanceenquiry;
    String pinnumber;
    Transcations(String pinnumber){
        this.pinnumber = pinnumber;
        setSize(800,830);
        setLocation(300,0);
        setLayout(null);

        ImageIcon i1 = new ImageIcon("D:\\Bank management system\\icons\\atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(800,800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);

        JLabel text = new JLabel("Please select your Transcation");
        text.setBounds(180,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        deposit = new JButton("Deposit");
        deposit.setBounds(145,395,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("Cash Withdrawl");
        withdrawl.setBounds(305,395,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(145,428,150,30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(305,428,150,30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        pinchange = new JButton("Pin Change");
        pinchange.setBounds(145,461,150,30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquiry = new JButton("Balance Enquiry");
        balanceenquiry.setBounds(305,461,150,30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        exit = new JButton("Exit");
        exit.setBounds(305,495,150,30);
        exit.addActionListener(this);
        image.add(exit);
        //setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== exit){
            System.exit(0);
        }
    }

    public static void main(String [] args){
        new Transcations("");
    }
}

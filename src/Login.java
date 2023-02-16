import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Objects;

public class Login extends JFrame implements ActionListener {

    JButton login,clear,signup;
    JTextField cardtext;
    JPasswordField pintext;
    Login(){
        setTitle("Automated Teller Machine");
        setBounds(500,200,800,480);
        setLayout(null);

        ImageIcon i1 = new ImageIcon("D:\\Bank management system\\icons\\logo.jpg");
        Image i2 = i1.getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);

        JLabel  label  = new JLabel(i3);
        label.setBounds(50,40,80,80);
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(150,60,500,50);
        add(text);

        JLabel card_no = new JLabel("Card No.:");
        card_no.setFont(new Font("Raleway", Font.BOLD,28));
        card_no.setBounds(100,150,200,30);
        add(card_no);

        cardtext = new JTextField();
        cardtext.setBounds(300,150,200,30);
        cardtext.setFont(new Font("Arial",Font.BOLD,14));
        add(cardtext);

        JLabel pin = new JLabel("Pin:");
        pin.setFont(new Font("Raleway", Font.BOLD,28));
        pin.setBounds(100,200,50,30);
        add(pin);

        pintext = new JPasswordField();
        pintext.setBounds(300,200,200,30);
        pintext.setFont(new Font("Arial",Font.BOLD,14));
        add(pintext);

        login = new JButton("SIGN IN");
        login.setBounds(300,250,90,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(410,250,90,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("SIGN UP");
        signup.setBounds(300,300,200,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.white);

        //setSize(700,500);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == clear){
            cardtext.setText("");
            pintext.setText("");
        }
        else if(ae.getSource()== login){
            Conn conn = new Conn();
            String cardnumber = cardtext.getText();
            String pinnumber = pintext.getText();
            String query = "select * from login where cardnumber = '"+cardnumber+"' and pin ='"+pinnumber+"'";

            try{
                ResultSet rs = conn.s.executeQuery(query);

                if(rs.next()){
                    setVisible(false);
                    new Transcations(pinnumber).setVisible(true);
                } else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card number of PIN");
                }

            }catch(Exception e){
                System.out.println(e);
            }
        }
        else if(ae.getSource() == signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    public static void main(String[] args){
        new Login();
    }
}

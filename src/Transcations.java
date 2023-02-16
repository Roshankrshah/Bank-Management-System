import javax.swing.*;
import java.awt.*;

public class Transcations extends JFrame {
    Transcations(){
        setSize(800,800);
        setLocation(300,0);
        setVisible(true);

        ImageIcon i1 = new ImageIcon("D:\\Bank management system\\icons\\atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(800,870, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image =new JLabel(i3);
        image.setBounds(0,0,800,800);
        add(image);
    }
    public static void main(String [] args){
        new Transcations();
    }
}

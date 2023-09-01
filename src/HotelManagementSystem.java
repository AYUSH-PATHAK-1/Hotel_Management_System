import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelManagementSystem extends JFrame implements ActionListener {

    HotelManagementSystem(){
        setTitle("Hotel Management System");
        setSize(1366,565);
        setLocation(100,100);
//        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/splashh.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(0,0,720,1080);
        add(image);


        JLabel text=new JLabel("Hotel Management System");
        text.setBounds(260,120,1000,90);
        text.setForeground(Color.white);
        text.setFont(new Font("serif",Font.BOLD,75));
        image.add(text);

        JButton next=new JButton("Next");
        next.setBounds(1150,450,150,50);
        next.setBackground(Color.white);
        next.setForeground(Color.black);
        next.addActionListener(this);
        next.setFont(new Font("serif",Font.PLAIN,18));
        image.add(next);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
       setVisible(true);


       while (true){
           text.setVisible(false);
           try{
               Thread.sleep(700);
           }catch (Exception e){
                e.printStackTrace();
           }
           text.setVisible(true);
           try{
               Thread.sleep(700);
           }catch (Exception e){
               e.printStackTrace();
           }
       }

    }

    public void actionPerformed(ActionEvent ae){
            setVisible(false);
            new Login();
    }

    public static void main(String[] args) {
        new HotelManagementSystem();
    }
}

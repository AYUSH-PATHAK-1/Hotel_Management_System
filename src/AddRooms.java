import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRooms extends JFrame  implements ActionListener {
Color lavender;
JButton add,cancle;
JTextField tfroom,tfprice;
JComboBox typecombo,availablecombo,cleanOption;
    AddRooms(){

        setTitle("Add Rooms");
        lavender=new Color(230, 230, 250);
        getContentPane().setBackground(lavender);
        setLayout(null);

        JLabel heading = new JLabel( "ADD ROOMS");
        heading.setFont(new Font("Sans Serif",Font.BOLD,18));
        heading.setBounds(150,29,200,20);
        add(heading);

        JLabel lblroomno = new JLabel( "Room Number");
        lblroomno.setFont(new Font("Sans Serif",Font.PLAIN,14));
        lblroomno.setBounds(60,80,120,30);
        add(lblroomno);

        tfroom=new JTextField();
        tfroom.setBounds(200,80,150,30);
        add(tfroom);

        JLabel lblavailable = new JLabel( "Available");
        lblavailable.setFont(new Font("Sans Serif",Font.PLAIN,14));
        lblavailable.setBounds(60,130,120,30);
        add(lblavailable);

        String availableOptions[]={"Available","Occupied"};
        availablecombo=new JComboBox(availableOptions);
        availablecombo.setBounds(200,130,150,30);
        availablecombo.setBackground(Color.white);
        availablecombo.setFont(new Font("Sans Serif",Font.BOLD,14));
        add(availablecombo);

        JLabel lbltype = new JLabel( "Bed Type");
        lbltype.setFont(new Font("Sans Serif",Font.PLAIN,14));
        lbltype.setBounds(60,180,120,30);
        add(lbltype);

        String typeOptions[]={"Double Bed","Single Bed"};
        typecombo=new JComboBox(typeOptions);
        typecombo.setBounds(200,180,150,30);
        typecombo.setBackground(Color.white);
        typecombo.setFont(new Font("Sans Serif",Font.BOLD,14));
        add(typecombo);


        JLabel lblclean = new JLabel( "Cleaning Status");
        lblclean.setFont(new Font("Sans Serif",Font.PLAIN,14));
        lblclean.setBounds(60,230,120,30);
        add(lblclean);

        String cleanOptions[]={"Clean","Dirty"};
        cleanOption=new JComboBox(cleanOptions);
        cleanOption.setBounds(200,230,150,30);
        cleanOption.setBackground(Color.white);
        cleanOption.setFont(new Font("Sans Serif",Font.BOLD,14));
        add(cleanOption);

        JLabel lblprice = new JLabel( "Room Price");
        lblprice.setFont(new Font("Sans Serif",Font.PLAIN,14));
        lblprice.setBounds(60,290,120,30);
        add(lblprice);

        tfprice=new JTextField();
        tfprice.setBounds(200,290,150,30);
        add(tfprice);


        add=new JButton("ADD ROOM");
        add.setBounds(60,350,130,30);
        add.setForeground(Color.white);
        add.setBackground(Color.blue);
        add.addActionListener(this);
        add(add);

        cancle=new JButton("CANCEL");
        cancle.setBounds(220 ,350,130,30);
        cancle.setForeground(Color.white);
        cancle.setBackground(Color.blue);
        cancle.addActionListener(this);
        add(cancle);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/rooms.jpg"));
        Image i2=i1.getImage().getScaledInstance(800,500,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,70,500,300);
        add(image);

        setBounds(330,200,940,470);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public  void  actionPerformed(ActionEvent ae){
         if(ae.getSource() == add){
             String roomnumber=tfroom.getText();
             String availabilty=(String)availablecombo.getSelectedItem();
             String status=(String) cleanOption.getSelectedItem();
             String price=tfprice.getText();
             String type=(String) typecombo.getSelectedItem();


             try{
                Conn conn=new Conn();
                String str="INSERT INTO room VALUES ('"+roomnumber+"','"+availabilty+"','"+status+"','"+price+"','"+type+"')";
                conn.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Room Added Successfully !!");

                setVisible(false);
             }catch (Exception e){
                 e.printStackTrace();
             }

         }else {
             setVisible(false);
         }
    }

    public static void main(String[] args) {
        new AddRooms();
    }
}

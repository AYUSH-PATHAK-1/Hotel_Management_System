import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDrivers extends JFrame  implements ActionListener {
    Color lavender;
    JButton add,cancle;
    JTextField tfname,tfprice,tfage,tflocation;
    JComboBox typecombo,cleanOption,carOption,avaiblityoption;
    JRadioButton rbmale,rbfemale;
    AddDrivers(){

        setTitle("Add Drivers");
        lavender=new Color(230, 230, 250);
        getContentPane().setBackground(lavender);
        setLayout(null);

        JLabel heading = new JLabel( "ADD DRIVERS");
        heading.setFont(new Font("Sans Serif",Font.BOLD,18));
        heading.setBounds(150,20,200,20);
        add(heading);

        JLabel lblroomno = new JLabel( "Name");
        lblroomno.setFont(new Font("Sans Serif",Font.PLAIN,14));
        lblroomno.setBounds(60,70,120,30);
        add(lblroomno);

        tfname=new JTextField();
        tfname.setBounds(200,70,150,30);
        add(tfname);

        JLabel lblage = new JLabel( "Age");
        lblage.setFont(new Font("Sans Serif",Font.PLAIN,14));
        lblage.setBounds(60,120,120,30);
        add(lblage);

        tfage = new JTextField();
        tfage.setBounds(200,120,150,30);
        add(tfage);

        JLabel lbltype = new JLabel( "Gender");
        lbltype.setFont(new Font("Sans Serif",Font.PLAIN,14));
        lbltype.setBounds(60,170,120,30);
        add(lbltype);

        rbmale= new JRadioButton("Male");
        rbmale.setBounds(200,170,70 ,30);
        rbmale.setFont(new Font("Sens Serif",Font.PLAIN,14));
        rbmale.setBackground(lavender);
        add(rbmale);

        rbfemale= new JRadioButton("Female");
        rbfemale.setBounds(280,170,85,30);
        rbfemale.setFont(new Font("Sens Serif",Font.PLAIN,14));
        rbfemale.setBackground(lavender);
        add(rbfemale);

        ButtonGroup bg=new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);


        JLabel lblcname = new JLabel( "Car Name");
        lblcname.setFont(new Font("Sans Serif",Font.PLAIN,14));
        lblcname.setBounds(60,220,120,30);
        add(lblcname);

        String carOptions[]={"Honda CR-V","BMW X5","Mahindra Bolero","BMW X3","Audi Q3","Bentayga","Maruti Suzuki Brezza","Cadillac Escalade","Hyundai Exter","Tata Nexon","Land Rover Range Rover","Hyundai Creta","Toyota Fortuner","\n" +
                "Kia Seltos"};
        carOption=new JComboBox(carOptions);
        carOption.setBounds(200,220,150,30);
        carOption.setBackground(Color.white);
        carOption.setFont(new Font("Sans Serif",Font.BOLD,14));
        add(carOption);

        JLabel lblavailable = new JLabel( "Available");
        lblavailable.setFont(new Font("Sans Serif",Font.PLAIN,14));
        lblavailable.setBounds(60,280,120,30);
        add(lblavailable);

        String avaiblityoptions[]={"Available","Busy"};
        avaiblityoption=new JComboBox(avaiblityoptions);
        avaiblityoption.setBounds(200,280,150,30);
        avaiblityoption.setBackground(Color.white);
        avaiblityoption.setFont(new Font("Sans Serif",Font.BOLD,14));
        add(avaiblityoption);


        JLabel lbllocation = new JLabel( "Location");
        lbllocation.setFont(new Font("Sans Serif",Font.PLAIN,14));
        lbllocation.setBounds(60,330,120,30);
        add(lbllocation);

        tflocation = new JTextField();
        tflocation.setBounds(200,330,150,30);
        add(tflocation);


        add=new JButton("ADD ROOM");
        add.setBounds(60,380,130,30);
        add.setForeground(Color.white);
        add.setBackground(Color.blue);
        add.addActionListener(this);
        add(add);

        cancle=new JButton("CANCEL");
        cancle.setBounds(220 ,380,130,30);
        cancle.setForeground(Color.white);
        cancle.setBackground(Color.blue);
        cancle.addActionListener(this);
        add(cancle);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/diver.jpg"));
        Image i2=i1.getImage().getScaledInstance(800,500,Image.SCALE_DEFAULT);
        ImageIcon i3 =new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(400,70,500,300);
        add(image);

        setBounds(300,220,980,470);
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }

    public  void  actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            String name=tfname.getText();
            String age=tfage.getText();
            String cname=(String) carOption.getSelectedItem();
            String available=(String) avaiblityoption.getSelectedItem();
            String location=tflocation.getText();
            String gender=null;


            if (rbmale.isSelected()){
                gender ="Male";
            }else if (rbfemale.isSelected()){
                gender = "Female";
            }


            try{
                Conn conn=new Conn();
                String str="INSERT INTO drivers VALUES ('"+name+"','"+age+"','"+cname+"','"+available+"','"+location+"','"+gender+"')";
                conn.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"Driver Added Successfully !!");

                setVisible(false);
            }catch (Exception e){
                e.printStackTrace();
            }

        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {


        new AddDrivers();
    }
}

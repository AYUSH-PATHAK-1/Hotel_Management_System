import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;

public class AddCustomer  extends JFrame implements ActionListener {

    JComboBox comboid;
    JTextField tfnumber,tfname,tfdeposite,tfcountry;
    JRadioButton rbmale,rbfemale;
    Choice croom;
    JLabel checkintime;
    JButton add,back;
    Color lavender=new Color(230, 230, 250);


    AddCustomer(){
        setTitle("New Customer");
        getContentPane().setBackground(lavender);
        setLayout(null);

        JLabel text= new JLabel("New Customer Form");
        text.setBounds(100,20,300,30);
        text.setFont(new Font("Century Gothic",Font.BOLD,20));
        add(text);

        JLabel lblid= new JLabel("ID");
        lblid.setBounds(65,80,100,20);
        lblid.setFont(new Font("Century Gothic",Font.PLAIN,20));
        add(lblid);

        String options[]={"Aadhar Card","Passport","Driving Licence","Voter-Id Card"};
        comboid =new JComboBox(options);
        comboid.setBounds(205,80,165,25);
        comboid.setFont(new Font("Century Gothic",Font.PLAIN,20));
        comboid.setBackground(lavender);
        comboid.setForeground(Color.BLACK);
        add(comboid);

        JLabel Nummber= new JLabel("Number");
        Nummber.setBounds(65,135,100,20);
        Nummber.setFont(new Font("Century Gothic",Font.PLAIN,20));
        add(Nummber);

        tfnumber=new JTextField();
        tfnumber.setBounds(205,135,150,25);
        tfnumber.setFont(new Font("Century Gothic",Font.PLAIN,20));
        tfnumber.setBackground(Color.white);
        tfnumber.setForeground(Color.BLACK);
        add(tfnumber);

        JLabel Name= new JLabel("Name");
        Name.setBounds(65,190,100,20);
        Name.setFont(new Font("Century Gothic",Font.PLAIN,20));
        add(Name);

        tfname=new JTextField();
        tfname.setBounds(205,190,150,25);
        tfname.setFont(new Font("Century Gothic",Font.PLAIN,20));
        tfname.setBackground(Color.white);
        tfname.setForeground(Color.BLACK);
        add(tfname);

        JLabel gender= new JLabel("Gender");
        gender.setBounds(65,245,100,20);
        gender.setFont(new Font("Century Gothic",Font.PLAIN,20));
        add(gender);

        rbmale=new JRadioButton("Male");
        rbmale.setBounds(195,245,75,20);
        rbmale.setFont(new Font("Century Gothic",Font.PLAIN,16));
        rbmale.setBackground(lavender);
        rbmale.setForeground(Color.BLACK);
        add(rbmale);

        rbfemale=new JRadioButton("Female");
        rbfemale.setBounds(285,245,95,20);
        rbfemale.setFont(new Font("Century Gothic",Font.PLAIN,16));
        rbfemale.setBackground(lavender);
        rbfemale.setForeground(Color.BLACK);
        add(rbfemale);

        ButtonGroup bg=new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);

        JLabel country= new JLabel("Country");
        country.setBounds(65,300,100,20);
        country.setFont(new Font("Century Gothic",Font.PLAIN,20));
        add(country);

        tfcountry=new JTextField();
        tfcountry.setBounds(205,300,150,25);
        tfcountry.setFont(new Font("Century Gothic",Font.PLAIN,20));
        tfcountry.setBackground(Color.white);
        tfcountry.setForeground(Color.BLACK);
        add(tfcountry);

        JLabel aroom= new JLabel("Room Number");
        aroom.setBounds(65,355,135,20);
        aroom.setFont(new Font("Century Gothic",Font.PLAIN,16));
        add(aroom);

        croom=new Choice();
        try {
            Conn conn=new Conn();
            String query="SELECT * FROM room WHERE availability='Available'" ;
            ResultSet rs=conn.s.executeQuery(query);
            while (rs.next()){
                croom.add(rs.getString("room_number"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }





        croom.setBounds(205,355,150,25);
        croom.setFont(new Font("Century Gothic",Font.PLAIN,16));
        croom.setBackground(Color.white);
        croom.setForeground(Color.BLACK);
        add(croom);

        JLabel lbltime= new JLabel("Check-In");
        lbltime.setBounds(65,405,100,20);
        lbltime.setFont(new Font("Century Gothic",Font.PLAIN,20));
        add(lbltime);

        Date date=new Date(System.currentTimeMillis());

        checkintime= new JLabel(""+date);
        checkintime.setBounds(205,405,100,20);
        checkintime.setFont(new Font("Century Gothic",Font.PLAIN,16));
        add(checkintime);

        JLabel lbldeposite= new JLabel("Deposit");
        lbldeposite.setBounds(65,460,100,20);
        lbldeposite.setFont(new Font("Century Gothic",Font.PLAIN,20));
        add(lbldeposite);

        tfdeposite=new JTextField();
        tfdeposite.setBounds(205,460,150,25);
        tfdeposite.setFont(new Font("Century Gothic",Font.PLAIN,20));
        tfdeposite.setBackground(Color.white);
        tfdeposite.setForeground(Color.BLACK);
        add(tfdeposite);

        add=new JButton("ADD");
        add.setBackground(Color.GREEN);
        add.setForeground(Color.black);
        add.setFont(new Font("Century Gothic",Font.BOLD,20));
        add.setBounds(65,510,125,35);
        add.addActionListener(this);
        add(add);

        back=new JButton("Cancel");
        back.setBackground(Color.red);
        back.setForeground(Color.black);
        back.setFont(new Font("Century Gothic",Font.BOLD,20));
        back.setBounds(228,510,125,35);
        back.addActionListener(this);
        add(back);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/customer.jpg"));
        Image i2=i1.getImage().getScaledInstance(375,375,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(320,35,525,490);
        add(image);


        setBounds(350,150,800,599);
        setVisible(true);

    }


    public void actionPerformed(ActionEvent ae){

        if (ae.getSource()==add){
            String document=(String) comboid.getSelectedItem();
            String number=tfnumber.getText();
            String name=tfname.getText();
            String gender=null;
            if(rbmale.isSelected()){
                gender="Male";
            }else if(rbfemale.isSelected()){
                gender="Female";
            }

            String country=tfcountry.getText();
            String room=croom.getSelectedItem();
            String checkin=checkintime.getText();
            String deposite=tfdeposite.getText();

            try {
                    String query="INSERT INTO customer VALUES('"+document+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+checkin+"','"+deposite+"')";
                    String query2="UPDATE room SET availability = 'Occupied' WHERE room_number='"+room+"'";

                    Conn conn=new Conn();
                    conn.s.executeUpdate(query);
                    conn.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null,"New Customer Added Successfully!!");

                    setVisible(false);
                    new Reception();




            }catch (Exception e){
                e.printStackTrace();
            }
        }else if (ae.getSource()==back){
                setVisible(false);
                new Reception();
        }


    }

    public static void main(String[] args) {
        new AddCustomer();
    }

}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployee extends JFrame implements ActionListener {
Color lavender;
JTextField tfname,tfemail,tfphone,tfage,tfsalary,tfaadhar;
JButton submit;
JComboBox cbjob;
JRadioButton rbmale,rbfemale;
    AddEmployee(){
        setTitle("Add Employee");
        setLayout(null);


        JLabel lblname=new JLabel("NAME");
        lblname.setBounds(60,30,120,30);
        lblname.setFont(new Font("Sens Serif",Font.PLAIN,17));
        add(lblname);

        tfname=new JTextField();
        tfname.setBounds(200,30,150,30);
        add(tfname);


        JLabel lblage=new JLabel("AGE");
        lblage.setBounds(60,80,120,30);
        lblage.setFont(new Font("Sens Serif",Font.PLAIN,17));
        add(lblage);

        tfage=new JTextField();
        tfage.setBounds(200,80,150,30);
        add(tfage);

        JLabel lblgender=new JLabel("GENDER");
        lblgender.setBounds(60,130,120,30);
        lblgender.setFont(new Font("Sens Serif",Font.PLAIN,17));
        add(lblgender);

        rbmale= new JRadioButton("Male");
        rbmale.setBounds(200,130,70,30);
        rbmale.setFont(new Font("Sens Serif",Font.PLAIN,14));
        rbmale.setBackground(lavender);
        add(rbmale);

        rbfemale= new JRadioButton("Female");
        rbfemale.setBounds(280,130,90,30);
        rbfemale.setFont(new Font("Sens Serif",Font.PLAIN,14));
        rbfemale.setBackground(lavender);
        add(rbfemale);


        ButtonGroup bg=new ButtonGroup();
        bg.add(rbmale);
        bg.add(rbfemale);

        JLabel lbljob=new JLabel("JOB");
        lbljob.setBounds(60,180,120,30);
        lbljob.setFont(new Font("Sens Serif",Font.PLAIN,17));
        add(lbljob);

        String str[] = {"Front Desk Clerks","Porters","HouseKeeping","Kitchen Staff","Room Service","Chefs","Waiter/Witress","Manager","Driver"};
        cbjob=new JComboBox(str);
        cbjob.setBounds(200,180,150,30);
        cbjob.setBackground(Color.white);
        cbjob.setFont(new Font("Sans Serif",Font.PLAIN,14));
        add(cbjob);

        JLabel lblsalary=new JLabel("SALARY");
        lblsalary.setBounds(60,230,120,30);
        lblsalary.setFont(new Font("Sens Serif",Font.PLAIN,17));
        add(lblsalary);

        tfsalary=new JTextField();
        tfsalary.setBounds(200,230,150,30);
        add(tfsalary);

        JLabel lblphone=new JLabel("PHONE");
        lblphone.setBounds(60,280,120,30);
        lblphone.setFont(new Font("Sens Serif",Font.PLAIN,17));
        add(lblphone);

        tfphone=new JTextField();
        tfphone.setBounds(200,280,150,30);
        add(tfphone);

        JLabel lblemail=new JLabel("EMAIL");
        lblemail.setBounds(60,330,120,30);
        lblemail.setFont(new Font("Sens Serif",Font.PLAIN,17));
        add(lblemail);

        tfemail=new JTextField();
        tfemail.setBounds(200,330,150,30);
        add(tfemail);

        JLabel lbladdhar=new JLabel("ADDHARCARD NUMBER");
        lbladdhar.setBounds(60,380,120,30);
        lbladdhar.setFont(new Font("Sens Serif",Font.PLAIN,17));
        add(lbladdhar);

        tfaadhar=new JTextField();
        tfaadhar.setBounds(200,380,150,30);
        add(tfaadhar);

        submit=new JButton("SUBMIT");
        submit.setBackground(Color.blue);
        submit.setForeground(Color.white);
        submit.setBounds(200,430,150,30);
        submit.addActionListener(this);
        add(submit);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/addemp.png"));
        Image i2=i1.getImage().getScaledInstance(440,450,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(380,60,450,450);
        add(image);

        lavender=new Color(230, 230, 250);
        getContentPane().setBackground(lavender);
        setBounds(350,200,850, 540  );
//        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String name= tfname.getText();
        String age= tfage.getText();
        String salary= tfsalary.getText();
        String phone= tfphone.getText();
        String email= tfemail.getText();
        String aadhar= tfaadhar.getText();
        String gender=null;

        if (name.equals("")){
             JOptionPane.showMessageDialog(null,"Name Should Not Be Empty");
             return;
        }


        if (rbmale.isSelected()){
            gender ="Male";
        }else if (rbfemale.isSelected()){
            gender = "Female";
        }

        String job=(String) cbjob.getSelectedItem();

        try{
            Conn conn=new Conn();

            String query="INSERT INTO employee VALUES ('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+email+"','"+aadhar+"')";
            conn.s.executeUpdate(query);

            JOptionPane.showMessageDialog(null,"Employee Added Successfully!");
            setVisible(false);

        }catch (Exception e){
              e.printStackTrace();
        }


    }


    public static void main(String[] args) {
        new AddEmployee();
    }

}

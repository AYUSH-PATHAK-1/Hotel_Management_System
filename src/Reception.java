import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reception  extends JFrame implements ActionListener {

    Color yellow=new Color(255,255,205);
    Color lavender=new Color(230, 230, 250);
    JButton newcustomer,rooms,department,allEmployee,customer,managerinfo,checkout,update,roomStatus,pickup,searchRoom,logout;
    Reception(){

        setTitle("Reception");
        getContentPane().setBackground(yellow);
        setLayout(null);


        newcustomer =new JButton("New Customer Form");
        newcustomer.setBounds(10,30,200,30);
        newcustomer.setBackground(lavender);
        newcustomer.setForeground(Color.BLACK);
        newcustomer.setFont(new Font("Century Gothic",Font.BOLD,12));
        newcustomer.addActionListener(this);
        add(newcustomer);

        rooms =new JButton("Rooms");
        rooms.setBounds(10,70,200,30);
        rooms.setBackground(lavender);
        rooms.setForeground(Color.BLACK);
        rooms.setFont(new Font("Century Gothic",Font.BOLD,12));
        rooms.addActionListener(this);
        add(rooms);

        department =new JButton("Department");
        department.setBounds(10,110,200,30);
        department.setBackground(lavender);
        department.setForeground(Color.BLACK);
        department.setFont(new Font("Century Gothic",Font.BOLD,12));
        department.addActionListener(this);
        add(department);

        allEmployee =new JButton("All Employee");
        allEmployee.setBounds(10,150,200,30);
        allEmployee.setBackground(lavender);
        allEmployee.setForeground(Color.BLACK);
        allEmployee.setFont(new Font("Century Gothic",Font.BOLD,12));
        allEmployee.addActionListener(this);
        add(allEmployee);

        customer =new JButton("Customer Info");
        customer.setBounds(10,190,200,30);
        customer.setBackground(lavender);
        customer.setForeground(Color.BLACK);
        customer.setFont(new Font("Century Gothic",Font.BOLD,12));
        customer.addActionListener(this);
        add(customer);

        managerinfo =new JButton("Managers");
        managerinfo.setBounds(10,230,200,30);
        managerinfo.setBackground(lavender);
        managerinfo.setForeground(Color.BLACK);
        managerinfo.setFont(new Font("Century Gothic",Font.BOLD,12));
        managerinfo.addActionListener(this);
        add(managerinfo);

        checkout =new JButton("Checkout");
        checkout.setBounds(10,270,200,30);
        checkout.setBackground(lavender);
        checkout.setForeground(Color.BLACK);
        checkout.setFont(new Font("Century Gothic",Font.BOLD,12));
        checkout.addActionListener(this);
        add(checkout);

        update =new JButton("Update Status");
        update.setBounds(10,310,200,30);
        update.setBackground(lavender);
        update.setForeground(Color.BLACK);
        update.setFont(new Font("Century Gothic",Font.BOLD,12));
        update.addActionListener(this);
        add(update);

        roomStatus =new JButton("Update Room Status");
        roomStatus.setBounds(10,350,200,30);
        roomStatus.setBackground(lavender);
        roomStatus.setForeground(Color.BLACK);
        roomStatus.setFont(new Font("Century Gothic",Font.BOLD,12));
        roomStatus.addActionListener(this);
        add(roomStatus);

        pickup =new JButton("Pick Up Service");
        pickup.setBounds(10,390,200,30);
        pickup.setBackground(lavender);
        pickup.setForeground(Color.BLACK);
        pickup.setFont(new Font("Century Gothic",Font.BOLD,12));
        pickup.addActionListener(this);
        add(pickup);

        searchRoom =new JButton("Search Room");
        searchRoom.setBounds(10,430,200,30);
        searchRoom.setBackground(lavender);
        searchRoom.setForeground(Color.BLACK);
        searchRoom.setFont(new Font("Century Gothic",Font.BOLD,12));
        searchRoom.addActionListener(this);
        add(searchRoom);

        logout =new JButton("Logout");
        logout.setBounds(10,470,200,30);
        logout.setBackground(Color.RED);
        logout.setForeground(Color.BLACK);
        logout.setFont(new Font("Aharon",Font.BOLD,12));
        logout.addActionListener(this);
        add(logout);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("images/reception.jpg"));
        Image i2=i1.getImage().getScaledInstance(575,475,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(250,28,500,470);
        add(image);







        setBounds(380,200,800,570);
        setVisible(true);

    }


    public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==newcustomer){
                setVisible(false);
                new AddCustomer();
            } else if (ae.getSource()==rooms) {
                setVisible(false);
                new Room();
            } else if (ae.getSource()==department) {
                setVisible(false);
                new Department();
            } else if (ae.getSource()==allEmployee) {
                setVisible(false);
                new AddEmployee();
            } else if (ae.getSource()==customer) {
                setVisible(false);
                new AddCustomer();
            } else if (ae.getSource()==managerinfo) {
                setVisible(false);
                new AddCustomer();
            } else if (ae.getSource()==checkout) {
                setVisible(false);
                new CheckOut();
            } else if (ae.getSource()==update) {
                setVisible(false);
                new UpdateRoom();
            } else if (ae.getSource()==update) {
                setVisible(false);
                new UpdateCheck();
            } else if (ae.getSource()==pickup) {
                setVisible(false);
                new Pickup();
            } else if (ae.getSource()==searchRoom) {
                setVisible(false);
                new SearchRoom();
            } else if (ae.getSource()==logout) {
                setVisible(false);
                new AddCustomer();
            }
    }

    public static void main(String[] args) {
        new Reception();
    }
}

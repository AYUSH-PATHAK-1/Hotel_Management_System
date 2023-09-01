import java.awt.*;

import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pickup extends JFrame {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private JPanel contentPane;
    private JTable table;
    Choice c1;


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Pickup frame = new Pickup();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    public void close()
    {
        this.dispose();
    }

    public Pickup() throws SQLException {
        setTitle("Pick Up Service");
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(530, 200, 800, 600);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblPickupService = new JLabel("Pick Up Service");
        lblPickupService.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPickupService.setBounds(325, 11, 158, 25);
        contentPane.add(lblPickupService);

        JLabel lblTypeOfCar = new JLabel("Type of Car");
        lblTypeOfCar.setBounds(32, 97, 89, 14);
        contentPane.add(lblTypeOfCar);


        c1 = new Choice();
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from drivers");
            while(rs.next()){
                c1.add(rs.getString("cname"));
            }
        }catch(Exception e){ }
        c1.setBounds(123, 94, 150, 25);
        contentPane.add(c1);



        JLabel lblInfo = new JLabel("Name");
        lblInfo.setBounds(24, 208, 46, 14);
        contentPane.add(lblInfo);

        JButton btnRegister = new JButton("Display");
        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String SQL = "select * from drivers where cname = '"+c1.getSelectedItem()+"'";
                try{

                    Conn c = new Conn();
                    rs = c.s.executeQuery(SQL);
                    table.setModel(DbUtils.resultSetToTableModel(rs));



                }catch (SQLException ss)
                {
                    ss.printStackTrace();
                }


            }
        });
        btnRegister.setBounds(200, 500, 120, 30);
        btnRegister.setBackground(Color.BLACK);
        btnRegister.setForeground(Color.WHITE);
        contentPane.add(btnRegister);

        JButton btnExit = new JButton("Back");
        btnExit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                new Reception().setVisible(true);
                setVisible(false);
            }
        });
        btnExit.setBounds(420, 500, 120, 30);
        btnExit.setBackground(Color.BLACK);
        btnExit.setForeground(Color.WHITE);
        contentPane.add(btnExit);

        table = new JTable();
        table.setBounds(0, 233, 800, 250);
        contentPane.add(table);

        JLabel lblNewLabel = new JLabel("Age");
        lblNewLabel.setBounds(165, 208, 46, 14);
        contentPane.add(lblNewLabel);

        JLabel lblGender = new JLabel("Car Name");
        lblGender.setBounds(284, 208, 55, 14);
        contentPane.add(lblGender);

        JLabel lblTypeOfDriver = new JLabel("Available");
        lblTypeOfDriver.setBounds(426, 208, 80, 14);
        contentPane.add(lblTypeOfDriver);

        JLabel lblAirport = new JLabel("Location");
        lblAirport.setBounds(570, 208, 86, 14);
        contentPane.add(lblAirport);

        JLabel lblAvailable = new JLabel("Gender");
        lblAvailable.setBounds(710, 208, 73, 14);
        contentPane.add(lblAvailable);



        getContentPane().setBackground(Color.WHITE);
    }
}
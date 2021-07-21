package harbour.management.system;

import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Ship_Info extends JFrame{  //Second Frame

    private JTable table;
    private JTextField textField;
    
    public static void main(String[] args){		 
	new Ship_Info().setVisible(true);    
    }
    
    public Ship_Info(){
        
        getContentPane().setBackground(Color.WHITE);
        getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
		
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(860,523);
	setLayout(null);
	setVisible(true);
		
	JLabel Scode = new JLabel("SHIP CODE");
	Scode.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Scode.setBounds(50, 100, 200, 30);
	add(Scode);
	
		
	JLabel ShipDetails = new JLabel("SHIP INFORMATION");
	ShipDetails.setFont(new Font("Tahoma", Font.PLAIN, 31));
	ShipDetails.setForeground(new Color(100, 149, 237));
	ShipDetails.setBounds(50, 20, 570, 35);
	add(ShipDetails);
		
	JButton btnShow = new JButton("SHOW");
	btnShow.setFont(new Font("Tahoma", Font.PLAIN, 20));
	
        btnShow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
	
                String code = textField.getText();
                
                try {
                    conn c = new conn();
                    String str = "select s_code,s_name,src,dst,capacity,class_code,class_name from ship ,sector where s_code = '"+code+"'";
      
                    ResultSet rs = c.s.executeQuery(str);
                    table.setModel(DbUtils.resultSetToTableModel(rs));	
                    
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        });

        btnShow.setBounds(220, 150, 120, 30);
	add(btnShow);
		
        table = new JTable();
        table.setBackground(Color.WHITE);
	table.setBounds(23, 250, 800, 300);
        
        JScrollPane pane = new JScrollPane(table);
	pane.setBounds(23, 250, 800, 300);
        pane.setBackground(Color.WHITE);
        add(pane);
		
	textField = new JTextField();
        textField.setBounds(220, 100, 200, 30);
	add(textField);
		
	JLabel FlightCode = new JLabel("SHIP CODE");
	FlightCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
        FlightCode.setBounds(23, 220, 126, 14);
	add(FlightCode);
		
	JLabel FlightName = new JLabel("SHIP NAME");
        FlightName.setFont(new Font("Tahoma", Font.PLAIN, 13));
	FlightName.setBounds(145, 220, 120, 14);
	add(FlightName);
		
	JLabel Source = new JLabel("SOURCE");
	Source.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Source.setBounds(275, 220, 104, 14);
	add(Source);
		
	JLabel Destination = new JLabel("DESTINATION");
	Destination.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Destination.setBounds(367, 220, 120, 14);
	add(Destination);
		
		
	JLabel Capacity = new JLabel("CAPACITY");
	Capacity.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Capacity.setBounds(497, 220, 111, 14);
	add(Capacity);
		
	JLabel ClassCode = new JLabel("CLASS CODE");
	ClassCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
	ClassCode.setBounds(587, 220, 120, 14);
	add(ClassCode);
		
	JLabel ClassName = new JLabel("CLASS NAME");
	ClassName.setFont(new Font("Tahoma", Font.PLAIN, 13));
	ClassName.setBounds(700, 220, 111, 14);
	add(ClassName);
		
	
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	setSize(900,650);
        setVisible(true);
        setLocation(400,200);
		
    }
}
package harbour.management.system;

import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class see extends JFrame{  //Second Frame

    private JTable table;
    private JTextField textField;
    
    public static void main(String[] args){		 
	new Ship_Info().setVisible(true);    
    }
    
    public see(){
        
        getContentPane().setBackground(Color.WHITE);
        getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
		
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setSize(860,523);
	setLayout(null);
	setVisible(true);
		
	JLabel Scode = new JLabel("PNR NO");
	Scode.setFont(new Font("Tahoma", Font.PLAIN, 17));
        Scode.setBounds(30, 100, 200, 30);
	add(Scode);
        
	
		
	JLabel ShipDetails = new JLabel("BOOKINGS");
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
                    String str = "select pnr_no,ticket_id,s_code,jny_date,jny_time,src,dst from reservation  where pnr_no = '"+code+"'";
      
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
		
	JLabel ShipCode = new JLabel("");
	ShipCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
        ShipCode.setBounds(23, 220, 126, 14);
	add(ShipCode);
		
	JLabel ShipName = new JLabel("");
        ShipName.setFont(new Font("Tahoma", Font.PLAIN, 13));
	ShipName.setBounds(145, 220, 120, 14);
	add(ShipName);
		
	JLabel Source = new JLabel("");
	Source.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Source.setBounds(275, 220, 104, 14);
	add(Source);
		
	JLabel Destination = new JLabel("");
	Destination.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Destination.setBounds(367, 220, 120, 14);
	add(Destination);
		
		
	JLabel Capacity = new JLabel("");
	Capacity.setFont(new Font("Tahoma", Font.PLAIN, 13));
	Capacity.setBounds(497, 220, 111, 14);
	add(Capacity);
		

		
	
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	setSize(900,650);
        setVisible(true);
        setLocation(400,200);
		
    }
}
package harbour.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Mainframe extends JFrame{

    public static void main(String[] args) {
        new Mainframe().setVisible(true);
    }
    
    public Mainframe() {
        super("HARBOUR MANAGEMENT");
        initialize();
    }

 
    private void initialize() {
	
        setForeground(Color.CYAN);
        setLayout(null); 

        JLabel NewLabel = new JLabel("");
	NewLabel.setIcon(new ImageIcon(ClassLoader.getSystemResource("harbour/management/system/icon/front.jpg")));
	NewLabel.setBounds(300, 0, 1920, 990); 
	add(NewLabel); 
        
        JLabel HarbourManagementSystem = new JLabel("WELCOME");
	HarbourManagementSystem.setForeground(Color.BLACK);
        HarbourManagementSystem.setFont(new Font("Tahoma", Font.PLAIN, 36));
	HarbourManagementSystem.setBounds(300, 60, 1000, 55);
	NewLabel.add(HarbourManagementSystem);
		
		
        JMenuBar menuBar = new JMenuBar();
	setJMenuBar(menuBar);
		
        JMenu HarbourSystem = new JMenu("HARBOUR SYSTEM");
        HarbourSystem.setForeground(Color.BLACK);
	menuBar.add(HarbourSystem);
		
        JMenuItem ShipDetails = new JMenuItem("SHIP_INFO");
	HarbourSystem.add(ShipDetails);
		
	JMenuItem ReservationDetails = new JMenuItem("ADD_CUSTOMER_DETAILS");
	HarbourSystem.add(ReservationDetails);
		
	JMenuItem PassengerDetails = new JMenuItem("JOURNEY_DETAILS");
	HarbourSystem.add(PassengerDetails);
        
        JMenuItem see = new JMenuItem("BOOKINGS");
	HarbourSystem.add(see);
		
	JMenuItem SectorDetails_1 = new JMenuItem("PAYMENT_DETAILS");
	HarbourSystem.add(SectorDetails_1);
		
	JMenuItem Cancellation = new JMenuItem("CANCELLATION");
	HarbourSystem.add(Cancellation);
        
        JMenuItem show = new JMenuItem("CANCELLED BOOKINGS");
	HarbourSystem.add(show);
        
		
	/*JMenu Ticket = new JMenu("TICKET");
        Ticket.setForeground(Color.RED);
	menuBar.add(Ticket);
		
        JMenu List = new JMenu("LIST");
        List.setForeground(Color.BLUE);
	menuBar.add(List);
		
	JMenu Misc = new JMenu("MISC");
        Misc.setForeground(Color.RED);
	menuBar.add(Misc);*/
        
		
	ShipDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Ship_Info();
            }
	});
        
        see.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new see();
            }
	});
        
        show.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Show();
            }
	});
        
	ReservationDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    new Add_Customer();
		} catch (Exception e) {
                    e.printStackTrace();
		} 
            }
	});
		
        PassengerDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    new Journey_Details();
                } catch (Exception e) {
                    e.printStackTrace();
		}
            }
	});
		
        SectorDetails_1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    new Payment_Details();
		} catch (Exception e) {
                    e.printStackTrace();
		}
            }
	});
		
        Cancellation.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Cancel();
            }
	});
		
        setSize(1950,1090);
	setVisible(true);
    }
}

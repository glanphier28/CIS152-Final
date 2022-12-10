package contents;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SortBySpotFrame {
	JFrame frame = new JFrame();
	
	public SortBySpotFrame() {
		JPanel panel = new JPanel();
		JLabel complexParking = new JLabel("Complex Parking", SwingConstants.CENTER);
		JLabel report = new JLabel("Sort By Spot", SwingConstants.CENTER);
		JLabel whiteSpace = new JLabel(" ", SwingConstants.CENTER);
		JButton backButton = new JButton("Back");
		
		int reportRowAmount = 35;

		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		panel.setLayout(new GridLayout(reportRowAmount, 2));
		panel.add(complexParking);
		panel.add(report);
		panel.add(whiteSpace);
		
		ParkingPass[] arr = matchPassBySpot();
		System.out.println(arr[0] + " l");
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr.length + "Aa");
			System.out.println("ID: " + arr[i].getPassID() + ", NAME: " + arr[i].getTenantFName()  + " " + arr[i].getTenantLName() + ", SELL PASS: " + arr[i].isSellPass());
			JLabel reportContents = new JLabel("ID: " + arr[i].getPassID() + ", NAME: " + arr[i].getTenantFName()  + " " + arr[i].getTenantLName() + ", SELL PASS: " + arr[i].isSellPass() + ", SPOT: " + arr[i].getSpotNumber());
			panel.add(reportContents);
			reportRowAmount ++;
		}
		
		BackButtonListener backButtonListener = new BackButtonListener();
		backButton.addActionListener(backButtonListener);
		panel.add(backButton);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Complex Parking");
		frame.pack();
		frame.setVisible(true);
		
	}
	
	public ParkingPass[] matchPassBySpot() {
		InsertionSort is = new InsertionSort();
		int[] arr = is.sort(ComplexParkingDriver.complexQueue.createArrayBySpot());
		
		ParkingPass[] passArray = new ParkingPass[ComplexParkingDriver.complexQueue.getSize() ];
		
		int i2 = 0;
		int i3 = 0;
		for (int i = 0; i <= 500; i ++) {
			for(int i4 = 0; i4 < ComplexParkingDriver.complexQueue.getSize(); i4++) {
			if(ComplexParkingDriver.complexQueue.getParkingPass(i4).getSpotNumber() == i) {
				passArray[i2] = ComplexParkingDriver.complexQueue.getParkingPass(i4);
				i2 ++;
				System.out.println("Spot [" + ComplexParkingDriver.complexQueue.getParkingPass(i4).getSpotNumber() + "] matched.");
			}
			}
		}
		System.out.println(passArray.length + " a ");
	
		return passArray;
}
	
	class BackButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			new ReportFrame();
			
		}
		
	}
}

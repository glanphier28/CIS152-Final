package contents;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class EnterUserFrame {
	JFrame frame = new JFrame();
	JTextField fNameField = new JTextField(10);
	JTextField lNameField = new JTextField(10);
	JTextField preferredSpotField = new JTextField(3);
	String[] sellPassChoices = {"No", "Yes"};
	JComboBox<String> sellPassCombo = new JComboBox<String>(sellPassChoices);
	
	public EnterUserFrame() {
		JButton submitButton = new JButton("Submit");
		JButton backButton = new JButton("Back");
		JLabel complexParking = new JLabel("Complex Parking", SwingConstants.CENTER);
		JLabel admin = new JLabel("Admin", SwingConstants.CENTER);
		JLabel enterUser = new JLabel("Enter New User", SwingConstants.CENTER);
		JLabel whiteSpace = new JLabel(" ", SwingConstants.CENTER);
		
		JLabel fName = new JLabel("First Name: ");
		JLabel lName = new JLabel("Last Name: ");
		JLabel prefferedSpot = new JLabel("Preferred Spot: ");
		
		JLabel sellPass = new JLabel("Sell Pass: ");
		

		
		JPanel panel = new JPanel();
		
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		panel.setLayout(new GridLayout(14, 1));
		panel.add(complexParking);
		panel.add(admin);
		panel.add(enterUser);
		panel.add(whiteSpace);
		panel.add(fName);
		panel.add(fNameField);
		panel.add(lName);
		panel.add(lNameField);
		panel.add(whiteSpace);
		panel.add(prefferedSpot);
		panel.add(preferredSpotField);
		panel.add(sellPass);
		panel.add(sellPassCombo);
		panel.add(whiteSpace);
		panel.add(submitButton);
		panel.add(backButton);
		
		BackButtonListener bckBttnLstnr = new BackButtonListener();
		backButton.addActionListener(bckBttnLstnr);
		
		SubmitButtonListener sbmtBttnLstnr = new SubmitButtonListener();
		submitButton.addActionListener(sbmtBttnLstnr);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Complex Parking");
		frame.pack();
		frame.setVisible(true);
	}
	
	public static boolean validateSpot(int spot) {
		boolean returnValue = true;
		for(int i = 0; i < ComplexParkingDriver.complexQueue.size(); i ++) {
			if(spot == ComplexParkingDriver.complexQueue.getParkingPass(i).getSpotNumber()) {
				returnValue = false;
			} 
		}
		return returnValue;
	}
	
	
	
	
	/* WIP
	 
	   public static int findClosestSpot(int spot) {
		System.out.println("Spot " + spot + " was taken. Finding nearest spot.");
		int availableSpots[] = new int[ComplexParkingDriver.complexQueue.getMaxSize() + 1]; //array size is queue max size
		int nonavailableSpots[] = new int[ComplexParkingDriver.complexQueue.size()];

		for(int i = 0 ; i < ComplexParkingDriver.complexQueue.size(); i++) {
		  nonavailableSpots[i] = ComplexParkingDriver.complexQueue.getParkingPass(i).getSpotNumber();
		  }
		  for(int i = 1; i < 500; i++) {
		    for(int x = 0; x < nonavailableSpots.length; x++) {
		      if(i != nonavailableSpots[x]) {
		        availableSpots[i] = i;
		        System.out.println("Spot " + i + " added to availableSpots[]");
		      }
		    }

		  }
	
		int closestSpotUp = spot;
		int closestSpotDown = spot;
		int downIndex = spot;
		int upIndex = spot;
		for(int i1 = 0; i1 < availableSpots.length; i1 ++) {
			
			if (i1 < spot) {
				downIndex --;
				while(downIndex > 0) {
				if(downIndex == availableSpots[i1]) {
					closestSpotDown = downIndex;
					System.out.println("Closest Spot Down is " + closestSpotDown);
				}
			  }
			}
			if (i1 > spot) {
				upIndex ++;
				while(upIndex <= 500) {
				if(upIndex == availableSpots[i1]) {
					closestSpotUp = upIndex;
					System.out.println("Closest Spot Up is " + closestSpotUp);
				}
				}
			}
		}
		
		downIndex = spot - closestSpotDown;
		upIndex = closestSpotUp - spot;
		
		if(upIndex <= downIndex) {
			spot = closestSpotUp;
		} else {
			spot = closestSpotDown;
		}
		return spot;
	}*/
	
	class SubmitButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String fName = fNameField.getText();
			String lName = lNameField.getText();
			String pSpot = preferredSpotField.getText();
			Boolean sellPass;
			
			if (sellPassCombo.getSelectedItem().toString().equals("Yes")) {
				sellPass = true;
			} else { 
				sellPass = false;
			}
			
			try {
				int pSpotInt = 0;
				if(pSpot.equals("")) {
					
				} else {
				pSpotInt = Integer.parseInt(pSpot);
				}
				
				if(!validateSpot(pSpotInt)) { 
					System.out.println("Error: Spot entered is already taken.");
					new SpotTakenAdminFrame();
				} else {
					ParkingPass parkingPass = new ParkingPass(fName, lName, sellPass, pSpotInt);
					ComplexParkingDriver.complexQueue.enqueue(parkingPass);
					System.out.println("Created ParkingPass: [ID=" + parkingPass.getPassID() + ", tenantFName=" + parkingPass.getTenantFName() + ", tenantLName=" + parkingPass.getTenantLName() + ", spotNumber=" + parkingPass.getSpotNumber() + "]");
					new AdminFrame();
				} 
				}
				catch(Exception exc) {
					System.out.println(exc);
				}
				
				
			
			frame.dispose();
		
			
			
		}
		
	}
	
	class BackButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			new AdminFrame();
			
		}
		
	}
}

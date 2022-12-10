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

import contents.EnterUserFrame.BackButtonListener;
import contents.EnterUserFrame.SubmitButtonListener;

public class UserFrame {
	
	JFrame frame = new JFrame();
	JTextField fNameField = new JTextField(10);
	JTextField lNameField = new JTextField(10);
	JTextField preferredSpotField = new JTextField(3);
	String[] sellPassChoices = {"No", "Yes"};
	JComboBox<String> sellPassCombo = new JComboBox<String>(sellPassChoices);
	
	public UserFrame() {
		JButton submitButton = new JButton("Submit");
		JButton backButton = new JButton("Back");
		JLabel complexParking = new JLabel("Complex Parking", SwingConstants.CENTER);
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
				int pSpotInt = Integer.parseInt(pSpot);
				
				if(!EnterUserFrame.validateSpot(pSpotInt)) { 
					System.out.println("Error: Spot entered is already taken.");
					new SpotTakenUserFrame();
				} else {
					ParkingPass parkingPass = new ParkingPass(fName, lName, sellPass, pSpotInt);
					ComplexParkingDriver.complexQueue.enqueue(parkingPass);
					System.out.println("Created ParkingPass: [ID=" + parkingPass.getPassID() + ", tenantFName=" + parkingPass.getTenantFName() + ", tenantLName=" + parkingPass.getTenantLName() + ", spotNumber=" + parkingPass.getSpotNumber() + "]");
					new HomeFrame();
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
			new HomeFrame();
			
		}
		
	}
}

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

import contents.HomeFrame.AdminButtonListener;

public class AdminFrame {
	
	JFrame frame = new JFrame();
	
	public AdminFrame() {
		JButton enterUserButton = new JButton("Enter User");
		//JButton removeUserButton = new JButton("Remove User");
		JButton backButton = new JButton("Back");
		JButton generateReportButton = new JButton("Generate Report");
		JLabel complexParking = new JLabel("Complex Parking", SwingConstants.CENTER);
		JLabel admin = new JLabel("Admin", SwingConstants.CENTER);
		JLabel whiteSpace = new JLabel("<html><br></html>", SwingConstants.CENTER);
		
		JPanel panel = new JPanel();
		
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		panel.setLayout(new GridLayout(7, 1));
		panel.add(complexParking);
		panel.add(admin);
		panel.add(whiteSpace);
		
		EnterUserButtonListener entrBttn = new EnterUserButtonListener();
		enterUserButton.addActionListener(entrBttn);
		panel.add(enterUserButton);
		
		
		GenerateReportButtonListener genReportLstnr = new GenerateReportButtonListener();
		generateReportButton.addActionListener(genReportLstnr);
		panel.add(generateReportButton);
		
		BackButtonListener bckBttnLstnr = new BackButtonListener();
		backButton.addActionListener(bckBttnLstnr);
		panel.add(backButton);

		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Complex Parking");
		frame.pack();
		frame.setVisible(true);
	}
	
	class EnterUserButtonListener implements ActionListener {
		
	    @Override
	    public void actionPerformed(ActionEvent e) {
		    frame.dispose();
		    new EnterUserFrame();
		
	  }
	
	}
	
	class GenerateReportButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			new ReportFrame();
			
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

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

public class ReportFrame {
	JFrame frame = new JFrame();
	
	public ReportFrame() {
		JPanel panel = new JPanel();
		JLabel complexParking = new JLabel("Complex Parking", SwingConstants.CENTER);
		JLabel report = new JLabel("Generate Report", SwingConstants.CENTER);
		JButton sortByID = new JButton("Sort By ID");
		JButton sortBySpot = new JButton("Sort By Spot");
		JButton backButton = new JButton("Back");
		JLabel whiteSpace = new JLabel(" ", SwingConstants.CENTER);
		
		
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		panel.setLayout(new GridLayout(7, 2));
		panel.add(complexParking);
		panel.add(report);
		panel.add(whiteSpace);
		
		SortByIDListener sortByIDListener = new SortByIDListener();
		sortByID.addActionListener(sortByIDListener);
		
		panel.add(sortByID);
		
		SortBySpotListener sortBySpotListener = new SortBySpotListener();
		sortBySpot.addActionListener(sortBySpotListener);
		panel.add(sortBySpot);
		
		BackButtonListener backButtonListener = new BackButtonListener();
		backButton.addActionListener(backButtonListener);
		
		panel.add(backButton);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Complex Parking");
		frame.pack();
		frame.setVisible(true);
		
		
	}
	
	class SortByIDListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			new GenerateReportFrame();
			
		}
		
	}
	
	class SortBySpotListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			new SortBySpotFrame();
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

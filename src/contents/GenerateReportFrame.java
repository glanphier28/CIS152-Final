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


public class GenerateReportFrame {
	JFrame frame = new JFrame();
	
	public GenerateReportFrame() {

		JLabel complexParkingReport = new JLabel("Complex Parking Report");
		JButton backButton = new JButton("Back");
		
		ComplexParkingDriver.complexQueue.printQueue();
		
		//JLabel report = new JLabel(ComplexParkingDriver.complexQueue.printedText.toString());
		
	
	
		JLabel whiteSpace = new JLabel("<html><br></html>", SwingConstants.CENTER);
	
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		panel.setLayout(new GridLayout(35, 1));
		panel.add(complexParkingReport, SwingConstants.CENTER);
		panel.add(whiteSpace);
		for(int i = 0; i < ComplexParkingDriver.complexQueue.size(); i++) {
			JLabel label = new JLabel(ComplexParkingDriver.complexQueue.print(i));
			panel.add(label);
		}
		
		BackButtonListener bckBttn = new BackButtonListener();
		backButton.addActionListener(bckBttn);
		panel.add(backButton);

		
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Complex Parking");
		frame.pack();
		frame.setVisible(true);
	}
	
	class BackButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			new ReportFrame();
			
		}
		
	}
	}


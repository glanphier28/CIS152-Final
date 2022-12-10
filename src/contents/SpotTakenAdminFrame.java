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

public class SpotTakenAdminFrame {
	JFrame frame = new JFrame();
			
	public SpotTakenAdminFrame() {
		JPanel panel = new JPanel();
		JLabel error = new JLabel("ERROR: SPOT ALREADY TAKEN", SwingConstants.CENTER);
		JLabel please = new JLabel("PLEASE ENTER A NEW SPOT", SwingConstants.CENTER);
		JButton okButton = new JButton("OK");
		
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		panel.setLayout(new GridLayout(7, 2));
		panel.add(error);
		panel.add(please);
		
		OkButtonListener okButtonListener = new OkButtonListener();
		okButton.addActionListener(okButtonListener);
		panel.add(okButton);
		
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Complex Parking");
		frame.pack();
		frame.setVisible(true);
	}
	
	class OkButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			new EnterUserFrame();
			
		}
		
	}
	
}

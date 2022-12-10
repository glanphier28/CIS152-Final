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

public class HomeFrame {
	
	JFrame frame = new JFrame();
	
	public HomeFrame() {
		
		
		JButton userButton = new JButton("User");
		JButton adminButton = new JButton("Admin");
		JLabel complexParking = new JLabel("Complex Parking", SwingConstants.CENTER);
		JLabel home = new JLabel("Home", SwingConstants.CENTER);
		JLabel whiteSpace = new JLabel(" ", SwingConstants.CENTER);
		
		JPanel panel = new JPanel();
		
		panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		panel.setLayout(new GridLayout(5, 2));
		panel.add(complexParking);
		panel.add(home );
		panel.add(whiteSpace);
		panel.add(userButton);
		
		UserButtonListener userBtnLstnr = new UserButtonListener();
		userButton.addActionListener(userBtnLstnr);
		
		panel.add(adminButton);
		
		AdminButtonListener admnBtnLstnr = new AdminButtonListener();
		adminButton.addActionListener(admnBtnLstnr);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Complex Parking");
		frame.pack();
		frame.setVisible(true);
	}
	
	class AdminButtonListener implements ActionListener {
		
	    @Override
	    public void actionPerformed(ActionEvent e) {
		    frame.dispose();
		    new AdminFrame();
	    }
	}
	
	class UserButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
			new UserFrame();
			
		}
		
	}
	
}

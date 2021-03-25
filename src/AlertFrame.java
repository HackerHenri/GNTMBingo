import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AlertFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JButton okButton;
	private JLabel label;
	private JLabel pic;
	
	public AlertFrame() {
		super("BINGO!");
		
		panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		setContentPane(panel);
		
		okButton = new JButton();
		okButton.setText("OK");
		
		Font schrift = new Font("SansSerif", Font.BOLD, 36); // I am short sighted
		
		label = new JLabel();
		label.setFont(schrift);
		label.setText("Nice Bingo!");
		
//		ImageIcon icon = new ImageIcon("/images/klatschen.png");
//		pic.setIcon(createImageIcon("images/bodybuilderme.jpg","random"));
		
		c.gridx=0;
		c.gridy=0;
		c.gridwidth=3;
		c.gridheight=2;
		c.weightx = 1;
		c.weighty = 1;
		panel.add(label,c);
		
//		c.gridx=0;
//		c.gridy=2;
//		c.gridwidth=3;
//		c.gridheight=3;
//		c.weightx = 1;
//		c.weighty = 1;
//		panel.add(pic,c);
		
		c.gridx=1;
		c.gridy=5;
		c.gridwidth=1;
		c.gridheight=1;
		panel.add(okButton,c);
		
		setMinimumSize(new Dimension(200,200)); // not smaller than this		
		setDefaultCloseOperation(EXIT_ON_CLOSE); // close-button behaviour
		setSize(300, 200); // start with this
		setVisible(true);
	}
	
	/** Returns an ImageIcon, or null if the path was invalid. */
	protected ImageIcon createImageIcon(String path,
	                                           String description) {
	    java.net.URL imgURL = getClass().getResource(path);
	    if (imgURL != null) {
	        return new ImageIcon(imgURL, description);
	    } else {
	        System.err.println("Couldn't find file: " + path);
	        return null;
	    }
	}
	
	
}

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BingoFrame extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private BingoPanel panel ;
	private JPanel contentPane ;
	private JLabel message ;
	
	private int size = 6;
	private int counter = 0;
	
	private JButton[][] fieldButtons; 
	private BingoCtrl ctrl;
	private JButton newGameButton;
	
	private Brett brett;

	public BingoFrame (BingoCtrl ctrl) {
		super("GNTM Bingo"); // Title of the window
		this.ctrl=ctrl;
		


		// construction of the window
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // distances in all directions
		contentPane.setLayout(new GridBagLayout()); // Layout-Style defined
		GridBagConstraints c = new GridBagConstraints(); // Positioning constraints of elements
		setContentPane(contentPane); 

		// we need size*size
		fieldButtons = new JButton[size][size];


		c.gridwidth=1; // 1 column
		c.gridheight=1;
		c.weightx=1; // if window resizes -> resize width
		c.weighty=1	; // but don't resize height
		c.fill=GridBagConstraints.BOTH; // fill whole space given
		for(int i=0; i<size; i++) {
			c.gridx = i;
			for(int j=0; j<size; j++) {
				
				c.gridy = j;
				fieldButtons[i][j] = new JButton("leer");
				fieldButtons[i][j].setMinimumSize(new Dimension(100,50));
				fieldButtons[i][j].addActionListener((ActionListener) this);
				contentPane.add(fieldButtons[i][j],c); //add to panel
				counter++;
			}
		}


		message = new JLabel("--"); // message below board
		message.setMinimumSize(new Dimension(500,50));
		Font schrift = new Font("SansSerif", Font.BOLD, 36); // I am short sighted
		message.setFont(schrift);

		c.gridx=0; 
		c.gridy=7; // last row
		c.gridwidth=5; // 5 columns
		c.gridheight=1;
		c.weightx=1; // resizing -> only width changes
		c.weighty=0;
		contentPane.add(message, c);
		
		newGameButton = new JButton("Neues Spiel"); // restart button
		newGameButton.setMinimumSize(new Dimension(200,50));
		newGameButton.addActionListener((ActionListener) this); // we listen to actions
		c.gridx=5; // right bottom corner 
		c.gridy=7;
		c.gridwidth=2; // 2 columns
		c.gridheight=1;
		c.weightx=1; // resizing -> only width changes
		c.weighty=0;
		contentPane.add(newGameButton,c);
		newGameButton.setEnabled(true); // initially not enabled!


		setMinimumSize(new Dimension(700,700)); // not smaller than this		
		setDefaultCloseOperation(EXIT_ON_CLOSE); // close-button behaviour
		setSize(1600, 700); // start with this
		setButtonColor();
		setVisible(true);

	}
	
	// changes the message in the left bottom corner
	public void setMeldung(String text) {
		//panel.setBoard((BingoBoard) ctrl.getBoard());
		message.setText(text);
		revalidate(); // repaint the whole window
		repaint();

	
	}
	
	public void setButtonText(int x, int y, String s) {
		fieldButtons[x][y].setText(s);
	}
	
	public void setButtonColor() {
		brett = ctrl.getBoard();
		for (int i=0; i<6; i++) {
			for (int j=0; j<6; j++) {
				if(brett.getFeld(i, j) == 1) {
					fieldButtons[i][j].setBackground(Color.green);
					fieldButtons[i][j].setOpaque(true);
				}
				else {
					fieldButtons[i][j].setBackground(Color.WHITE);
					fieldButtons[i][j].setOpaque(true);
				}
			}
		}

	}
	public void winMode() {

	}
	
	public void setSingleButtonColor(int x, int y, Color f) {
		fieldButtons[x][y].setBackground(f);
	}
	/*
	// change the board that is shown
	public void setBrett(VierGewinntBrett board) {
		panel.setBrett(board);
		revalidate();// repaint the whole window
		repaint();
	}
*/
	// here we define what happens if a button is pressed
	// In this case this methods is called since we are
	// an "actionListener" and listen to button actions
	@Override
	public void actionPerformed(ActionEvent e) {
//		setButtonColor();
		// find out which button was pressed
		for (int i=0; i<6; i++) {
			for (int j = 0; j<6; j++)
			if( e.getSource()== fieldButtons[i][j]) {
				ctrl.fieldSelected(i, j); // ok, it was field i,j
			}	
		}
		if (e.getSource() == newGameButton) {	
			ctrl.newGame(); // Ok, User wants new game
//			for (int i=0; i<=5; i++) {
//				for (int j=0; j<=5; j++) {
//					fieldButtons[i][j].setEnabled(true); 
//				}
//			}
		}
		
//		if (ctrl.isFinished()) { // if it is over
//			for (int i=0; i<=5; i++) {
//				for (int j=0; j<=5; j++) {
//					fieldButtons[i][j].setEnabled(false); 
//				}
//			}
//		}

	}


}

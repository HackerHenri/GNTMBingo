
public interface BingoCtrl {

	// method to inform the Ctrl that button "i, j" has been pressed
	void fieldSelected(int i, int j);
	// ask Ctrl whether game is finished
	boolean isFinished();
	// method to inform the Ctrl that a new game shall be started
	public void newGame();
	// retrieve the current board from Ctrl
	public Brett getBoard(); 
}

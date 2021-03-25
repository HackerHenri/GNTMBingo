
public class Bingo extends Spiel implements BingoCtrl{

	
	private BingoFrame fenster;
	private int size = 5;
	int x = 0;
	int y = 0;
	
	public Bingo() {
		
	}
	
	public Brett brett;
	
	public Brett neuesBrett() {
		brett = new Brett();
		return brett;
	}
	
	public void neuesSpiel(Brett brett) {
		int counter = 0;
		fenster.setMeldung("Abfahrt!");
		fenster.setButtonColor();
		brett.shuffleBoard();
		for (int i=0; i<=size; i++) {
			for(int j =0; j<=size; j++) {
				brett.setFeld(i, j, 0);
				fenster.setButtonText(i, j, brett.getFeldString(counter));
				counter++;
			}	
		}    
	}
	
	public void macheZug(Brett b) {
		
		
		if(b.getFeld(x,y) == 0) {
			b.setFeld(x, y, 1);
			System.out.println(x);
		}
		if(b.getFeld(x,y) == 1) {
			b.setFeld(x, y, 0);
		}
		fenster.setButtonColor();
		
	}
	
	public boolean istBeendet(Brett b) {
		
		for (int i=size; i>=0; i--) {
			if(b.getFeld(i, 0) == 1) {
				if(b.getFeld(i, 1) == 1) {
					if(b.getFeld(i, 2) == 1) {
						if(b.getFeld(i, 3) == 1) {
							if(b.getFeld(i, 4) == 1) {
								if(b.getFeld(i, 5) == 1) {
									return true;
								}
							}
						}
					}
				}
			}
		}
		for (int j=size; j>=0; j--) {
			if(b.getFeld(0, j) == 1) {
				if(b.getFeld(1, j) == 1) {
					if(b.getFeld(2, j) == 1) {
						if(b.getFeld(3, j) == 1) {
							if(b.getFeld(4, j) == 1) {
								if(b.getFeld(5, j) == 1) {
									return true;
								}
							}
						}
					}
				}
			}
		}
		if(b.getFeld(0, 0) == 1) {
			if(b.getFeld(1, 1) == 1) {
				if(b.getFeld(2, 2) == 1) {
					if(b.getFeld(3, 3) == 1) {
						if(b.getFeld(4, 4) == 1) {
							if(b.getFeld(5, 5) == 1) {
								return true;
							}
						}
					}
				}
			}
		}
		if(b.getFeld(0, 5) == 1) {
			if(b.getFeld(1, 4) == 1) {
				if(b.getFeld(2, 3) == 1) {
					if(b.getFeld(3, 2) == 1) {
						if(b.getFeld(4, 1) == 1) {
							if(b.getFeld(5, 0) == 1) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Bingo bingpot = new Bingo();
		bingpot.spielen();
		
	}
	
	//--------------------------------------------------------------------------//

	@Override
	public void fieldSelected(int i, int j) {
		x = i;
		y = j;
		if(x<6 && x>=0 && y<6 && y>=0) {
			if(brett.getFeld(x, y) == 0) {
				brett.setFeld(x, y, 1);
				fenster.setMeldung("nice");
				fenster.setButtonColor();
			}
			else {
				brett.setFeld(x, y, 0); 
				fenster.setMeldung("oof");
				fenster.setButtonColor();
			}
				
		}
		if(istBeendet(brett) == true) {
			fenster.setMeldung("Bingo!");
//			for (int a=0; a<6; a++) {
//				for (int b=0; b<6; b++) {
//					if(brett.getFeld(a, b) == 1) {
//						fenster.setSingleButtonColor(i, j, Color.pink);
//					}
//				}
//			}
		}

	}
	

	public void spielen() {
		brett = neuesBrett();
		fenster = new BingoFrame(this);
		neuesSpiel(brett);
	}
	
	@Override
	public boolean isFinished() {
		if (istBeendet(brett) == true) {
			fenster.setMeldung("Bingo!");
			return true;
		}
		else return false;
	}
	
	@Override
	public void newGame() {
		neuesSpiel(brett);
		fenster.setButtonColor();
	}
	
	@Override
	public Brett getBoard() {
		return brett;
	}
}

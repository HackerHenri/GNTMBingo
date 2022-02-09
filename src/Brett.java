/* 
 * Autor: Henri Reumschüssel
 * Programm: Bingo
 * Datum: 12.03.2021
 */
import java.util.Random;

public class Brett implements BingoBoard {
    private int[][] feld;

    private String[] begriffe = {"<html>Ein Model weint", "<html>Es wird gekreischt", "<html>Heidi sagt „Meine Mädchen“",
    		"<html>Jemand spricht unnötig Englisch", "<html>„Es kann nur eine GNTM werden“", "<html>„Ich habe heute leider kein Foto für dich“", 
    		"<html>Jemand stolpert oder verliert einen Schuh beim walk", "<html>Heidi benutzt das Plusquamperfekt", 
    		"<html>Attitude", "<html>„Nur eine kommt auf das Cover der deutschen Harpers Bazar“",
    		"<html>Sophie ist in einen Streit verwickelt", "<html>Fotograf/Gastjuror ist unzufrieden",
    		"<html>Jemand sagt was Dummes", "<html>Jemand ist neidisch", "<html>Schuhe oder Kleid unbequem oder passen nicht",
    		"<html>Ein Mädchen wackelt", "<html>Diversity", "<html>Es wird gelästert",
    		"<html>Ein Mädchen vermisst Familie/Freund", "<html>Es wird etwas geblurrt/zensiert",
    		"<html>Schleichwerbung", "<html>Klamotten in denen man nicht laufen kann", "<html>Gastjuror, den keiner kennt",
    		"<html>Jemand hat Beute von einer Großwildjagd an", "<html>Jemand sitzt im Gammellook auf dem Sofa", "<html>Der Fotograf oder Designer ist schwul",
    		"<html>Viola ist super cringy", "<html>Es wird Freund oder Familie gezeigt", "<html>Personality", "<html>Arroganz", 
    		"<html>Heidi sagt dummen Spruch/Sprichwort","<html>Heidi ist giga unlustig", "<html>„Wer ist das?!“", "<html>Werbung vor der Entscheidung", 
    		"<html>Bescheuerte Musik wird eingespielt", "<html>Hässliche Klamotten bei Shoot/Walk", 
    		"<html>Jemand hat eine hässliche Frisur", "<html>Jemand isst was (Gyros Teller)",
    		"<html>Gastjuror stimmt Heidi zu / kriecht ihr in den Arsch"};
    
    public Brett() {
    	feld = new int[6][6];													  // neues Array
    	shuffleBoard();
		
    }
    
  //--------------------------------------------------------------------------// getter und setter
    
    public int getFeld(int posx, int posy) {
    	return feld[posx][posy];
    }
    
    public void setFeld(int posx, int posy, int wert) {
    	feld[posx][posy] = wert;
    }
    
    public String getFeldString(int index) {
    	return begriffe[index];
    }
    
    public void shuffleBoard() {
		Random rand = new Random();

		
		for (int i = 0; i<begriffe.length; i++) {
			int randomIndexToSwap = rand.nextInt(begriffe.length);
			String temp = begriffe[randomIndexToSwap];
			begriffe[randomIndexToSwap] = begriffe[i];
			begriffe[i] = temp;
		}
    }
  //--------------------------------------------------------------------------//

	@Override
	public int getField(int column, int row) {
															
		return this.getFeld(column, row);
	}
}

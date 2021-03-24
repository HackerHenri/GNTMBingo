/* 
 * Autor: Henri Reumschüssel
 * Programm: Bingo
 * Datum: 12.03.2021
 */
import java.util.Arrays;
import java.util.Random;

public class Brett implements BingoBoard {
    private int[][] feld;

    private String[] begriffe = {"Ein Model weint", "Es wird gekreischt", "Heidi sagt „Meine Mädchen“",
    		"Jemand spricht unnötig Englisch", "„Es kann nur eine GNTM werden“", "„Ich habe heute leider kein Foto für dich“", 
    		"Jemand stolpert oder verliert einen Schuh beim walk", "Heidi benutzt das Plusquamperfekt", 
    		"Attitude", "„Nur eine kommt auf das Cover der deutschen Harpers Bazar“", "Die Mädchen werden gefittet", 
    		"Soulin ist in einen Streit verwickelt", "Linda sagt/macht was unsympatisches", "Fotograf ist unzufrieden",
    		"Jemand sagt was Dummes", "Jemand ist neidisch", "Schuhe oder Kleid unbequem oder passen nicht",
    		"Ein Mädchen wackelt", "Es wird auf Corona Maßnahmen hingewiesen", "Diversity", "Es wird gelästert",
    		"Lilliana ist ne Zicke", "Ein Mädchen vermisst Familie/Freund", "Es wird etwas geblurrt/zensiert",
    		"„Das gab es noch nie bei GNTM!“", "„Wer hat das Zeug GNTM zu werden?“", "„Das allein reicht leider nicht“",
    		"Corona Handshake", "Schleichwerbung", "Klamotten in denen man nicht laufen kann", "Gastjuror, den keiner kennt",
    		"Jemand hat Beute von einer Großwildjagd an", "Jemand sitzt im Gammellook auf dem Sofa", "Der Fotograf oder Designer ist schwul",
    		"Ana sagt was religiöses", "Es wird Freund oder Familie gezeigt", "Personality", "Arroganz", "Heidi sagt dummen Spruch/Sprichwort",
    		"Heidi ist giga unlustig", "„Wer ist das?!“", "Werbung vor der Entscheidung"};
    
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

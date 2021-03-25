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
    		"<html>Attitude", "<html>„Nur eine kommt auf das Cover der deutschen Harpers Bazar“", "Die Mädchen werden gefittet", 
    		"<html>Soulin ist in einen Streit verwickelt", "<html>Linda sagt/macht was unsympatisches", "<html>Fotograf ist unzufrieden",
    		"<html>Jemand sagt was Dummes", "<html>Jemand ist neidisch", "<html>Schuhe oder Kleid unbequem oder passen nicht",
    		"<html>Ein Mädchen wackelt", "<html>Es wird auf Corona Maßnahmen hingewiesen", "<html>Diversity", "<html>Es wird gelästert",
    		"<html>Lilliana ist ne Zicke", "<html>Ein Mädchen vermisst Familie/Freund", "<html>Es wird etwas geblurrt/zensiert",
    		"<html>„Das gab es noch nie bei GNTM!“", "<html>„Wer hat das Zeug GNTM zu werden?“", "<html>„Das allein reicht leider nicht“",
    		"<html>Corona Handshake", "<html>Schleichwerbung", "<html>Klamotten in denen man nicht laufen kann", "<html>Gastjuror, den keiner kennt",
    		"<html>Jemand hat Beute von einer Großwildjagd an", "<html>Jemand sitzt im Gammellook auf dem Sofa", "<html>Der Fotograf oder Designer ist schwul",
    		"<html>Ana sagt was religiöses", "<html>Es wird Freund oder Familie gezeigt", "<html>Personality", "Arroganz", "<html>Heidi sagt dummen Spruch/Sprichwort",
    		"<html>Heidi ist giga unlustig", "<html>„Wer ist das?!“", "<html>Werbung vor der Entscheidung"};
    
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

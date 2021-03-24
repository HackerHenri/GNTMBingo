/* 
 * Autor: Henri Reumschüssel
 * Programm: Bingo
 * Datum: 12.03.2021
 */

public abstract class Spiel {
    public Brett brett;
    public abstract Brett neuesBrett();
    public abstract void neuesSpiel(Brett b);
    public abstract void macheZug(Brett b);
    public abstract boolean istBeendet(Brett b);

    												// Jetzt koennen wir schon spielen:
    public void spielen() {
	brett = neuesBrett();  
	neuesSpiel(brett);   							// Grundaufstellung	
	
	do { 											// solange ziehen, bis beendet
	    macheZug(brett); 
	} while (! istBeendet(brett)); 
    }
}


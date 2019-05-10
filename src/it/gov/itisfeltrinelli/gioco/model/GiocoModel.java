package it.gov.itisfeltrinelli.gioco.model;

public class GiocoModel {
	private final int MAXNUMERO=100;
	
	private int numeroSegreto;
	private int tentativi;
	private boolean inGame;
	
	public GiocoModel() {
		inGame=false;
	}
	public void startGame() {
		numeroSegreto=(int)(Math.random()*MAXNUMERO)+1;
		inGame=true;
		tentativi = 0;
	}
	/**
	 * 
	 * @param numero
	 * @return  -2 numero fuori range
	 * 			-1 in caso di errore
	 *           0 se indovinato il numero
	 *    	     1 se troppo piccolo
	 *           2 se troppo grande
	 */
	public int controlla(int numero) {
		if (inGame) {
			/* 
			 * Controllo del range del numero
			 */
			if (numero < 1 || numero > MAXNUMERO) return -2;
			tentativi++;
			if (numero > numeroSegreto) {
				return 2;
			} else if (numero < numeroSegreto) {
				return 1;
			} 
			inGame=false;
			return 0;
		} 
		return -1;
	}
	public String getTentativi() {
		return tentativi + "";
	}
	public boolean isInGame() {
		return inGame;
	}
	public int getMAXNUMERO() {
		return MAXNUMERO;
	}
	
	
}

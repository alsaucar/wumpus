/**
 * 
 */
package text.based.games.htw;

import java.io.IOException;
import java.util.Scanner;

import text.based.games.htw.board.GameBoard;

/**
 * @author Alexis
 *
 */
public class Launcher {
	
	
	static int rows = -1;
	static int cols = -1;
	static int arrows = -1;
	static int holes = -1;
	
	
	/**
	 * M�todo principal que lanza el juego
	 * 
	 */
	public static void main (String [] args) {
		
		String accion;
		
		askParams();
		
		GameBoard board = new GameBoard(rows, cols, arrows, holes);
		board.displayBoard();
		
		while (board.isGameActive()) {
			
			accion = board.askPlayerMove();
			
			board.makeAction(accion);
				
			//Limpiamos la consola
			clrscr();
			
			board.displayBoard();
			
		}
		
		if (board.getHunter().isDead()) {
			System.out.println("�HAS PERDIDO LA PARTIDA...!");
		}else{
			System.out.println("�ENHORABUENA! HAS GANADO LA PARTIDA EN "+board.getMovesCounter()+" MOVIMIENTOS.");
		}
		
	}
	
	/**
	 * M�todo para limpiar la consola y que el tablero parezca est�tico
	 */
	public static void clrscr(){
		
	    try {
	        if (System.getProperty("os.name").contains("Windows"))
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        else
	            Runtime.getRuntime().exec("clear");
	    } catch (IOException | InterruptedException ex) {}
	    
	}
	
	
	/**
	 * M�todo para preguntar al usuario los par�metros del juego
	 * 
	 * @param player
	 */
	public static void askParams () {
		
		Scanner keyboard = new Scanner (System.in);
		
		try {
		
			do{
					
				System.out.println("Seleccione n�mero de filas del tablero: ");
				rows = keyboard.nextInt();
					
				System.out.println("Seleccione n�mero de columnas del tablero: ");
				cols = keyboard.nextInt();
				
				System.out.println("Seleccione n�mero de flechas que dispone el cazador: ");
				arrows = keyboard.nextInt();
				
				System.out.println("Seleccione n�mero de hoyos en el tablero: ");
				holes = keyboard.nextInt();
				
			} while (rows < 0 && cols < 0 && arrows < 0 && holes < 0);
		
		}catch (Exception ex){
			System.out.println("Se cargan par�metros por defecto...");
		}
		
	}
	
}

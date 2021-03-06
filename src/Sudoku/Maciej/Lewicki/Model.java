/**
 * 
 */
package Sudoku.Maciej.Lewicki;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author Maciej Lewicki
 *
 */
public class Model {
	private int [][]actualBoard = new int [9][9];
	private int [][]result = new int [9][9];
	private String whichToSet = "";
	private static final int howManyBoards = 2;
	private int whichBoard = 0;
	
	/**
	 * constructor
	 */
	public Model(){
		newBoard();
	}
	
	/**
	 * create board
	 */
	public void newBoard(){
		FileInputStream in = null;
		int i=0,j=0;
		try{
			in = new FileInputStream("boards.txt");
			int numberOfBoardsToSkip = whichBoard;
			if (whichBoard >= howManyBoards){
				whichBoard = 0;
			}
			for(i = numberOfBoardsToSkip; i>0; i--){
				for(int skipBoards = 162; skipBoards > 0; skipBoards-- ){
					in.read();
				}
			}
			for(i=0;i<9;i++){
				for(j=0;j<9;j++){
					actualBoard[i][j] = in.read();
				}
			}
			for(i=0;i<9;i++){
				for(j=0;j<9;j++){
					result[i][j] = in.read();
				}
			}
			whichBoard++;
		}catch(Exception e){
			System.out.println("Bad file!!!");
			System.exit(555);
		}
		try{
			if (in != null) {
				in.close();
			}
		}catch(IOException e){
			System.out.println("Cannot close file!!!");
			System.exit(555);
		}
	}
	
	/**
	 * 
	 * @param row row of value to get
	 * @param column column of value to get
	 * @return return value which you get
	 */
	public int getActualValue(int row, int column){
		return actualBoard[row][column];
	}
	
	/**
	 * 
	 * @param WchichNumberToSet change variable whichToSet
	 */
	public void numberToSet(String WchichNumberToSet){
		whichToSet = WchichNumberToSet;
	}
	
	/**
	 * 
	 * @return get variable whitchToSet
	 */
	public String getWhichToSet(){
		return whichToSet;
	}
	
	/**
	 * 
	 * @param text value to insert
	 * @return 1 mean "value OK"; return == 0 mean "Bad value"
	 */ 
	public int insertValue(String text){
		int which = Integer.parseInt(whichToSet);
		int numberOfRow = which / 10;
		int numberOfColumn = which % 10;
		int nText;
		try{
			nText = Integer.parseInt(text);
			if (nText > 9 || nText < 1){
				return 0;
			}
			int goodValue = result[numberOfRow][numberOfColumn];
			if(nText == goodValue){
				actualBoard[numberOfRow][numberOfColumn] = nText;
				if(isEnd()){
					return 2;
				}
				return 1;
			}
		} catch(Exception e){
			return 0;
		}
		return 0;
	}
	
	/**
	 * 
	 * @return signal  "this is end"  
	 */
	private boolean isEnd(){
		for(int i =0; i<9; i++){
			for(int j =0; j<9; j++){
				if (actualBoard[i][j] != result[i][j]){
					return false;
				}
			}
		}
		return true;
	}
}

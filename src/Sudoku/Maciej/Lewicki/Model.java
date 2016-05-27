/**
 * 
 */
package Sudoku.Maciej.Lewicki;

/**
 * @author Maciej Lewicki
 *
 */
public class Model {
	private int [][]actualBoard = new int [9][9];
	private int [][]result = new int [9][9];
	private String whichToSet = "";
	
	public Model(){
		/**
		 * TODO initialization of board
		 */
		for(int i =  0; i<9; i++){
			for(int j = 0; j<9; j++){
				actualBoard[i][j] = j;
				result[i][j] = j;
			}
		}
	}
	
	public int getActualValue(int row, int column){
		return actualBoard[row][column];
	}
	
	public void numberToSet(String WchichNumberToSet){
		whichToSet = WchichNumberToSet;
	}
}

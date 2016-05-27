/**
 * 
 */
package Sudoku.Maciej.Lewicki;

/**
 * @author dell
 *
 */
public class Model {
	private int [][]previusBoard = new int [9][9];
	private int [][]actualBoard = new int [9][9];
	private int [][]result = new int [9][9];
	
	public Model(){
		/**
		 * TODO initialization of board
		 */
		for(int i =  0; i<9; i++){
			for(int j = 0; j<9; j++){
				previusBoard[i][j] = 1;
				actualBoard[i][j] = 1;
				result[i][j] = 1;
			}
		}
	}
}

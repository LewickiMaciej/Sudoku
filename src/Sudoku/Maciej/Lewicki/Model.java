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
	
	/*return == 1 mean "value OK"; return == 0 mean "Bad value"*/ 
	public int insertValue(String text){
		int which = Integer.parseInt(whichToSet);
		int numberOfRow = which / 10;
		int numberOfColumn = which % 10;
		int nText;
		try{
			nText = Integer.parseInt(text);
		} catch(Exception e){
			return 0;
		}
		
		if (nText > 9 || nText < 1){
			return 0;
		}
		int goodValue = result[numberOfRow][numberOfColumn];
		if(nText == goodValue){
			actualBoard[numberOfRow][numberOfColumn] = nText;
			return 1;
		}
		return 0;
	}
}

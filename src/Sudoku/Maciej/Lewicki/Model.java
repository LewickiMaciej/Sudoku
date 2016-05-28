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
	
	public Model(){
		FileInputStream in = null;
		int i=0,j=0;
		try{
			in = new FileInputStream("boards.txt");
			
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
	
	public int getActualValue(int row, int column){
		return actualBoard[row][column];
	}
	
	public void numberToSet(String WchichNumberToSet){
		whichToSet = WchichNumberToSet;
	}
	
	public String getWhichToSet(){
		return whichToSet;
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
			if(isEnd()){
				return 2;
			}
			return 1;
		}
		return 0;
	}
	
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

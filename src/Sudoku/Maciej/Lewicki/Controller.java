/**
 * 
 */
package Sudoku.Maciej.Lewicki;

/**
 * @author dell
 *
 */
public class Controller{
	Model model;
	View view;
	
	public Controller(){
		model = new Model();
		view = new View();
		view.createBoard(model);
	}
	
}


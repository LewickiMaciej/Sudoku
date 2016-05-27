/**
 * 
 */
package Sudoku.Maciej.Lewicki;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Maciej Lewicki
 *
 */
public class Controller{
	Model model;
	View view;
	
	public Controller(){
		model = new Model();
		view = new View();
		view.createBoard(model, this);
	}
	
	
	public class MyAction implements ActionListener{
		private String whichNumber;
		
		public MyAction(String xWhichNumber){
			whichNumber = xWhichNumber;
		}
		
		public void actionPerformed(ActionEvent event){
			model.numberToSet(whichNumber);
		}
	}
}


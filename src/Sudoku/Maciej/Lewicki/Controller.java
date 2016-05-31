/**
 * 
 */
package Sudoku.Maciej.Lewicki;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

/**
 * @author Maciej Lewicki
 *
 */
public class Controller{
	Model model;
	View view;
	
	/**
	 * constructor
	 */
	public Controller(){
		model = new Model();
		view = new View();
		view.createBoard(model, this);
	}
	
	/**
	 * create new board
	 */
	private void newBoard(){
		model.newBoard();
		view.fillBoard(model);
	}
	
	/*
	 * Listeners of buttons on boards 
	 */
	public class ButtonAction implements ActionListener{
		private String whichNumber;
		
		/**
		 * 
		 * @param xWhichNumber number to differentiate buttons
		 */
		public ButtonAction(String xWhichNumber){
			whichNumber = xWhichNumber;
		}
		
		/**
		 * 
		 */
		public void actionPerformed(ActionEvent event){
			model.numberToSet(whichNumber);
		}
	}
	
	public class UpdateValue implements ActionListener{
		JTextField textField;
		
		/**
		 * 
		 * @param xTextField - value to update
		 */
		public UpdateValue(JTextField xTextField){
			textField = xTextField;
		}
		
		/**
		 * 
		 */
		public void actionPerformed(ActionEvent event){
			String text = textField.getText();
			int returnValue = model.insertValue(text);
			
			if(returnValue >= 1){
				view.updateView(model, text);
				if(returnValue == 2){
					returnValue = view.endGame();
					if(returnValue == 0)
						newBoard();
					if(returnValue > 0)
						System.exit(0);
				}
			}
		}
	}
}


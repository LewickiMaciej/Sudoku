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
	
	public Controller(){
		model = new Model();
		view = new View();
		view.createBoard(model, this);
	}
	
	
	public class ButtonAction implements ActionListener{
		private String whichNumber;
		
		public ButtonAction(String xWhichNumber){
			whichNumber = xWhichNumber;
		}
		
		public void actionPerformed(ActionEvent event){
			model.numberToSet(whichNumber);
		}
	}
	
	public class UpdateValue implements ActionListener{
		JTextField textField;
		
		public UpdateValue(JTextField xTextField){
			textField = xTextField;
		}
		
		public void actionPerformed(ActionEvent event){
			String text = textField.getText();
			int returnValue = model.insertValue(text);
			System.out.println(returnValue);
			if(returnValue == 1){
				view.updateView(model, text);
			}
		}
	}
}


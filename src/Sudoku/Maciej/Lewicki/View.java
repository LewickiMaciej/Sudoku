/**
 * 
 */
package Sudoku.Maciej.Lewicki;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Maciej Lewicki
 *
 */
public class View {
	private static final int DEFAULT_WIDTH = 500;
	private static final int DEFAULT_HEIGHT = 500;

	public View(){
	}
	
	public void createBoard(Model model, Controller x){
		JFrame frame = new JFrame();
		frame.setTitle("Listeners");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(9,9));
		String labelOfButton = "";
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				labelOfButton = Integer.toString(model.getActualValue(i,j));
				JButton button = new JButton(labelOfButton);
				int wynik = i*10 + j;
				String actionValue = Integer.toString(wynik);  
				Controller.ButtonAction buttonAction = x.new ButtonAction(actionValue);
				button.addActionListener(buttonAction);
				panel.add(button);
			}
		}
		JPanel panelSouth = new JPanel();
		JTextField textField = new JTextField("Tu wprowadz wartosc", 1);
		JButton button = new JButton("Wprowadz wartosc");
		Controller.UpdateValue updateValue= x.new UpdateValue(textField);
		button.addActionListener(updateValue);
		panelSouth.add(textField);
		panelSouth.add(button);
		frame.add(panel);
		frame.add(panelSouth, BorderLayout.SOUTH);
		frame.setVisible(true);
	}
	
}

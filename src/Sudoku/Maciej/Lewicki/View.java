/**
 * 
 */
package Sudoku.Maciej.Lewicki;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Maciej Lewicki
 *
 */
public class View {
	private static final int DEFAULT_WIDTH = 900;
	private static final int DEFAULT_HEIGHT = 600;
	private JButton[][] tableOfButtons= new JButton[9][9];
	private JFrame frame;
	
	public View(){
	}
	
	public void createBoard(Model model, Controller x){
		frame = new JFrame();
		frame.setTitle("Listeners");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		frame.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(11,11));
		String labelOfButton = "";
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				labelOfButton = Integer.toString(model.getActualValue(i,j));
				JButton button = new JButton(labelOfButton);
				tableOfButtons[i][j] = button;
				int wynik = i*10 + j;
				String actionValue = Integer.toString(wynik);  
				Controller.ButtonAction buttonAction = x.new ButtonAction(actionValue);
				button.addActionListener(buttonAction);
				panel.add(button);
				if(j == 2 || j == 5)
					panel.add(Box.createHorizontalStrut(10));
			}
			if(i == 2 || i == 5){
				for(int j=0; j<11; j++){
					JButton button = new JButton("x");
					button.setVisible(false);
					panel.add(button);
				}
			}
			
		}
		JPanel panelSouth = new JPanel();
		JTextField textField = new JTextField("0", 1);
		JButton button = new JButton("Wprowadz wartosc");
		Controller.UpdateValue updateValue= x.new UpdateValue(textField);
		button.addActionListener(updateValue);
		panelSouth.add(textField);
		panelSouth.add(button);
		frame.add(panel);
		frame.add(panelSouth, BorderLayout.SOUTH);
		frame.setVisible(true);
	}
	
	public void updateView(Model model, String text){
		int which = Integer.parseInt(model.getWhichToSet());
		int numberOfRow = which / 10;
		int numberOfColumn = which % 10;
		tableOfButtons[numberOfRow][numberOfColumn].setText(text);
	}
	
	public void endGame(){
		JOptionPane.showMessageDialog(frame,"You won!");
	}
}

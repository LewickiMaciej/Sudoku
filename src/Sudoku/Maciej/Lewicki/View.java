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
		createFrame();
		JPanel panel = createGridLayout(model, x);
		JPanel panelSouth = createSouthPanel(x);
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
	
	public int endGame(){
		int z = JOptionPane.showConfirmDialog(frame, "You won!\nDo you want to play again?");
		return z;
	}
	
	private void createFrame(){
		frame = new JFrame();
		frame.setTitle("Sudoku");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		frame.setVisible(true);
	}
	
	private JPanel createGridLayout(Model model, Controller x){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(11,11));
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				JButton button = addButtonForGridLayout(model, x,panel, i, j);
				tableOfButtons[i][j] = button;
			}
			if(i == 2 || i == 5){
				for(int j=0; j<11; j++){
					addUnvisibleButton(panel);
				}
			}
		}
		return panel;
	}
	
	private JPanel createSouthPanel( Controller x){
		JPanel panel = new JPanel();
		JTextField textField = new JTextField("0", 1);
		JButton button = new JButton("Wprowadz wartosc");
		Controller.UpdateValue updateValue= x.new UpdateValue(textField);
		button.addActionListener(updateValue);
		panel.add(textField);
		panel.add(button);
		return panel;
	}
	
	private JButton addButtonForGridLayout(Model model, Controller x, JPanel panel, int row, int column){
		JButton button = fillButton(model, row, column, new JButton());  //also create new button
		String actionValue = Integer.toString( row*10 + column);  
		Controller.ButtonAction buttonAction = x.new ButtonAction(actionValue);
		button.addActionListener(buttonAction);
		panel.add(button);
		if(column == 2 || column == 5)
			panel.add(Box.createHorizontalStrut(10));
		return button;
	}
	
	private void addUnvisibleButton(JPanel panel){
		JButton button = new JButton("x");
		button.setVisible(false);
		panel.add(button);
	}
	
	public void fillBoard(Model model){
		for(int i =0; i<9; i++){
			for(int j=0;j<9;j++){
				fillButton(model, i, j, tableOfButtons[i][j]);
			}
		}
	}
	
	private JButton fillButton(Model model, int row, int column, JButton button){
		int value = model.getActualValue(row, column);
		String labelOfButton = Integer.toString(value);
		button.setText(labelOfButton);
		if(value == 0){
			button.setText("");
		}
		return button;
	}
}

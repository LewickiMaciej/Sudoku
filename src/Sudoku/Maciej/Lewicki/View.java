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
	
	/**
	 * constructor
	 */
	public View(){
	}
	
	/**
	 * 
	 * @param model  - acces to model 
	 * @param controller - acces to controller
	 */
	public void createBoard(Model model, Controller controller){
		createFrame();
		JPanel panel = createGridLayout(model, controller);
		JPanel panelSouth = createSouthPanel(controller);
		frame.add(panel);
		frame.add(panelSouth, BorderLayout.SOUTH);
		frame.setVisible(true);
	}
	
	/**
	 * 
	 * @param model - acces to model. We must get which value we change from model 
	 * @param text  - new label of button - we change label only this value which model allow
	 */
	public void updateView(Model model, String text){
		int which = Integer.parseInt(model.getWhichToSet());
		int numberOfRow = which / 10;
		int numberOfColumn = which % 10;
		tableOfButtons[numberOfRow][numberOfColumn].setText(text);
	}
	
	/**
	 * 
	 * @return - which option is select 
	 */
	public int endGame(){
		int z = JOptionPane.showConfirmDialog(frame, "You won!\nDo you want to play again?");
		return z;
	}
	
	/**
	 * Create frame
	 */
	
	private void createFrame(){
		frame = new JFrame();
		frame.setTitle("Sudoku");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		frame.setVisible(true);
	}
	
	/**
	 * 
	 * @param model acces to model function and data
	 * @param controller acces to listeners which we add to button
	 * @return return GridLayout(JPanel) which was created 
	 */
	private JPanel createGridLayout(Model model, Controller controller){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(11,11));
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				JButton button = addButtonForGridLayout(model, controller,panel, i, j);
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
	
	/**
	 * 
	 * @param controller acces to listeners which we add to button
	 * @return return SouthPanel(JPanel) which was created 
	 */
	private JPanel createSouthPanel( Controller controller){
		JPanel panel = new JPanel();
		JTextField textField = new JTextField("0", 1);
		JButton button = new JButton("Wprowadz wartosc");
		Controller.UpdateValue updateValue= controller.new UpdateValue(textField);
		button.addActionListener(updateValue);
		panel.add(textField);
		panel.add(button);
		return panel;
	}
	
	/**
	 * 
	 * @param model acces to model function and data
	 * @param controller acces to listeners which we add to button
	 * @param panel add button to this panel 
	 * @param row add button in this row
	 * @param column add button in this column
	 * @return return JButton which was created 
	 */
	private JButton addButtonForGridLayout(Model model, Controller controller, JPanel panel, int row, int column){
		JButton button = fillButton(model, row, column, new JButton());  //also create new button
		String actionValue = Integer.toString( row*10 + column);  
		Controller.ButtonAction buttonAction = controller.new ButtonAction(actionValue);
		button.addActionListener(buttonAction);
		panel.add(button);
		if(column == 2 || column == 5)
			panel.add(Box.createHorizontalStrut(10));
		return button;
	}
	
	/**
	 * 
	 * @param panel add button to this panel
	 */
	private void addUnvisibleButton(JPanel panel){
		JButton button = new JButton("x");
		button.setVisible(false);
		panel.add(button);
	}
	
	/**
	 * 
	 * @param model access to data 
	 */
	public void fillBoard(Model model){
		for(int i =0; i<9; i++){
			for(int j=0;j<9;j++){
				fillButton(model, i, j, tableOfButtons[i][j]);
			}
		}
	}
	
	/**
	 * 
	 * @param model access to data
	 * @param row row of button to access via model
	 * @param column column of button to access via model
	 * @param button which button label set to model.button.label
	 * @return changed button
	 */
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
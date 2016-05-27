/**
 * 
 */
package Sudoku.Maciej.Lewicki;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author dell
 *
 */
public class View {
	private static final int DEFAULT_WIDTH = 500;
	private static final int DEFAULT_HEIGHT = 500;
	
	public View(){
	}
	
	public void createBoard(Model model){
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
				panel.add(button);
				
			}
		}
		frame.add(panel);
		frame.setVisible(true);
	}
	
}

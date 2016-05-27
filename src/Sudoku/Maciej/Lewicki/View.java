/**
 * 
 */
package Sudoku.Maciej.Lewicki;

import javax.swing.JFrame;

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
	}
	
}

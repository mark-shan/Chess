/*
 * Chess piece images retrieved from: https://en.wikipedia.org/wiki/User:Cburnett
 */

package chess;

import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class Main extends JPanel{	
	ChessModel model;
	ChessView chessView;
	
	private class ResizeListener extends ComponentAdapter {
	    public void componentResized(ComponentEvent e) {
	       	// Resize view when window resized
	    	Dimension newSize = e.getComponent().getBounds().getSize(); 
	    	model.setBoard(newSize.getWidth(),newSize.getHeight());
	    	
	    }
	}
	
	Main() {
		
        // Set up MVC
		model = new ChessModel(700,600);
		chessView = new ChessView(model);
				
        // layout the views
        setLayout(new BorderLayout());
        
        //// for getting key events into PlayView
        //playView.requestFocusInWindow();
        
        this.addComponentListener(new ResizeListener());
        this.add(chessView);
        
    }
	
	public static void main(String[] args) {
        // create the window
        JFrame f = new JFrame("Chess"); 
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(700, 600); 
        f.setContentPane(new Main()); 
        f.setVisible(true); 
    }
}

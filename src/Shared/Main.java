package Shared;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main{
	
	public static void main(String args[]) {
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				createBase();
			}
		});	
	}
	private static void createBase() {
		JFrame frame = new JFrame();
		frame.setSize(800, 600);
		JPanel panel = new JPanel(new BorderLayout());
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(panel);
		Base b = new Base();
		panel.add(b);
		b.start();
		
	}

}

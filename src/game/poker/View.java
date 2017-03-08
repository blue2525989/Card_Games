package game.poker;

/**
 * poker view
 */

import javax.swing.*;
import javax.swing.text.*;

import java.awt.*;

public class View {

	// main frame 
	public JFrame main = new JFrame("Five Card Poker");
	
	// j-panel to display text
	private JPanel body = new JPanel();
	// make it scroll-able
	private JScrollPane bodyScroll = new JScrollPane(body);
	// text area to display text
	private JTextArea text = new JTextArea("", 5, 45);
	// caret to auto scroll when text is added
	private DefaultCaret carrot = (DefaultCaret) text.getCaret();
	// point for screen location
	private Point p1 = new Point(200, 100);
	
	// middle j-panel for display
	private JPanel middle = new JPanel();
	// fun header
	private JLabel header = new JLabel("Play Five Card Poker! choose an option,");
	// prompt
	private JTextArea middleText = new JTextArea("",
			10,40);
	
	
	// j-panel for buttons
	private JPanel buttons = new JPanel();
	// deal the cards button
	public JButton deal = new JButton("Deal");
	// take a hit button
	public JButton yes = new JButton("Hit");
	// call button
	public JButton no = new JButton("Call");
	// exit game button
	public JButton exit = new JButton("Exit");
	
	// grid-layout for buttons panel
	GridLayout grd2 = new GridLayout(1, 4);
	// grid-layout for main frame
	GridLayout grd3 = new GridLayout(3, 1);
	
	public void loadView() {
		// allow word wrapping in-case text gets to long
		text.setLineWrap(true);
		// add text area
		body.add(text);
		// change background color
		body.setBackground(Color.DARK_GRAY);
		
		// add buttons
		buttons.add(deal);
		buttons.add(yes);
		buttons.add(no);
		buttons.add(exit);
		// change background color
		buttons.setBackground(Color.DARK_GRAY);
		
		// add header
		middle.add(header);
		// change text color
		header.setForeground(Color.MAGENTA);
		// add text area with prompt text
		middle.add(middleText);
		// change text and background colors
		middleText.setForeground(Color.CYAN);
		middleText.setBackground(Color.DARK_GRAY);
		middle.setBackground(Color.DARK_GRAY);
		
		// add j-panels to main frame
		main.add(bodyScroll);
		main.add(middle);
		main.add(buttons);
		// set main frames layout
		main.setLayout(grd3);
		
		// set location to middle of screen, set visible, set size, and set close operation
		main.setLocation(p1);
		main.setVisible(true);
		main.setSize(550, 650);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	// append new outputs to text area without overwriting previous
	public void setGame(String words) {
		text.append(words + "\n");
		text.setCaret(carrot);
		text.setCaretPosition(text.getDocument().getLength());
	}
	
	// clears text area
	public void clear() {
		text.setText("");
		text.setCaret(carrot);
		text.setCaretPosition(0);		
	}
	
	// sets middle text area
	public void setMiddle(String words) {
		middleText.setText(words);
	}
}
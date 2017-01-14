//////////////////////////////////////////
//(C) Powered by Shellai Developer, 2017//
//////////////////////////////////////////
package ex.cleaner.gui;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import ex.cleaner.logic.CloseProgram;

public class ButtonClose extends JButton{
	private static final long serialVersionUID = -4009297762008368559L;

	public Image exit_btn;
	
	public ButtonClose(){
		setBounds(355, 15, 20, 20);
		setOpaque(false);
		setFocusPainted(false);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		CloseProgram exit = new CloseProgram();
		addActionListener(exit);
		
		CloseProgramMouseEvent changeColor = new CloseProgramMouseEvent();
		addMouseListener(changeColor);
		
	    try {
			exit_btn = ImageIO.read(getClass().getResource("/ex/cleaner/style/exit_icon.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void paintComponent(Graphics ex){
		ex.drawImage(exit_btn, 0, 0, this);
		super.paintComponent(ex);
	}

	  //[EVENT] Change Color of button
private class CloseProgramMouseEvent implements MouseListener{

			@Override
			public void mouseClicked(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
				try{
					 Image EXIT_ICON_CHANGE_COLOR = ImageIO.read(getClass().getResource("/ex/cleaner/style/exit_icon_pressed.png"));
					 setIcon(new ImageIcon(EXIT_ICON_CHANGE_COLOR));
				}catch(Exception ex1){
					ex1.printStackTrace();
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}
		 
		}

}

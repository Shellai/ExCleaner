package ex.cleaner.gui;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

import ex.cleaner.logic.ShowInformation;

public class ButtonInfo extends JButton{
	private Image info_btn;
	private static final long serialVersionUID = 2423423525L;
	
	public ButtonInfo(){
		setBounds(330, 15, 20, 20);
		setOpaque(false);
		setFocusPainted(false);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
	    try {
	    	info_btn = ImageIO.read(getClass().getResource("/ex/cleaner/style/info.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	    
	    ShowInformation showToUser = new ShowInformation();
	    addActionListener(showToUser);
	    
	}
	@Override
	public void paintComponent(Graphics ex){
		ex.drawImage(info_btn, 0, 0, this);
		super.paintComponent(ex);
	}
}

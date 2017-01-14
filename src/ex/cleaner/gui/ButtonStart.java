//////////////////////////////////////////
//(C) Powered by Shellai Developer, 2017//
//////////////////////////////////////////
package ex.cleaner.gui;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import ex.cleaner.logic.DeleteFiles;

public class ButtonStart extends JButton{
	private static final long serialVersionUID = 31231L;
	
	public JButton start_btn;
	public Image start_btn_image;

	ImageIcon rubbish_img;
	
	protected ButtonStart(){
		setBounds(32,345,338,65);
		setOpaque(false);
		setFocusPainted(false);
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFont(new Font("Tahoma", Font.PLAIN, 30));
		setText("DELETE");
		setIcon(new ImageIcon(getClass().getResource("/ex/cleaner/style/rubbish.png")));
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		try {
			start_btn_image = ImageIO.read(getClass().getResource("/ex/cleaner/style/Start.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		DeleteFiles deleting = new DeleteFiles();
		addActionListener(deleting);
	}
	
	@Override
	protected void paintComponent(Graphics startbtn){
		startbtn.drawImage(start_btn_image, 0, 0, this);
		super.paintComponent(startbtn);
	}
}

//////////////////////////////////////////
//(C) Powered by Shellai Developer, 2017//
//////////////////////////////////////////
package ex.cleaner.gui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class WriteExtension {
	
	public static JTextPane extension_fld;
	Image extension_image;
	public static char key_code;
	public void AddExtensionArea(){
		
		try {
			extension_image = ImageIO.read(getClass().getResource("/ex/cleaner/style/Output_btn.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		extension_fld = new JTextPane(){
			private static final long serialVersionUID = 521312L;

			@Override
			protected void paintComponent(Graphics extensionimage){
				extensionimage.drawImage(extension_image, 0, 0, this);
				super.paintComponent(extensionimage);
			}
		};
		extension_fld.setBounds(32, 300, 338, 25);
		extension_fld.setOpaque(false);
		SimpleAttributeSet attributes4 = new SimpleAttributeSet();
		StyleConstants.setAlignment(attributes4 , StyleConstants.ALIGN_CENTER);
		extension_fld.setParagraphAttributes(attributes4,true);
		
		IgnoreKeys ignoring = new IgnoreKeys();
		extension_fld.addKeyListener(ignoring);
		
		Window.frame.add(extension_fld);
		
	}

private static class IgnoreKeys implements KeyListener{

	@Override
	public void keyPressed(KeyEvent getting) {
		key_code = getting.getKeyChar();
		if(key_code == KeyEvent.VK_ENTER || key_code == KeyEvent.VK_SPACE || key_code == KeyEvent.VK_TAB){
			getting.consume();
		}
	}

	@Override
	public void keyReleased(KeyEvent getting) {
		key_code = getting.getKeyChar();
		if(key_code == KeyEvent.VK_ENTER || key_code == KeyEvent.VK_SPACE || key_code == KeyEvent.VK_TAB){
			getting.consume();
		}
	}

	@Override
	public void keyTyped(KeyEvent getting) {
		key_code = getting.getKeyChar();
		if(key_code == KeyEvent.VK_ENTER || key_code == KeyEvent.VK_SPACE || key_code == KeyEvent.VK_TAB){
			getting.consume();
		}
		
	}
	
}
}

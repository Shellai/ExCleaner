//////////////////////////////////////////
//(C) Powered by Shellai Developer, 2017//
//////////////////////////////////////////
package ex.cleaner.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class LogArea{
	public static Image log_image;
	public static JScrollPane scrolling;
	//public static JTextPane logging;
	public static JTextPane logging = new JTextPane(){
		private static final long serialVersionUID = -4010158945263438150L;

		@Override
		public void paintComponent(Graphics l){
			try {
				 log_image = ImageIO.read(getClass().getResource("/ex/cleaner/style/LogArea.png"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			
			l.drawImage(log_image, 0, 0, this);
			super.paintComponent(l);
		}
	};
	
	public static void AddLogArea(){
		logging = new JTextPane();
		logging.setOpaque(false);
		logging.setEditable(false);
		logging.setText("Here you will see a list of deleted files!");
		SimpleAttributeSet attributes2 = new SimpleAttributeSet();
		StyleConstants.setAlignment(attributes2 , StyleConstants.ALIGN_CENTER);
		logging.setParagraphAttributes(attributes2,true);
		scrolling = new JScrollPane(logging);
		scrolling.setBounds(32, 62, 338, 90);
		scrolling.getViewport().setBackground(new Color(217,219,219));
		scrolling.setBorder(BorderFactory.createLineBorder(new Color(144,150,150)));
		
		ClearForm remove = new ClearForm();
		logging.addMouseListener(remove);
		
		Window.frame.add(scrolling);
	}

private static class ClearForm implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		logging.setText("");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
}



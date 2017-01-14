//////////////////////////////////////////
//(C) Powered by Shellai Developer, 2017//
//////////////////////////////////////////
package ex.cleaner.gui;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Window{
	public static JFrame frame = new JFrame();
	public JLabel body = new JLabel();
	public int x, y, xMouse, yMouse;
	public static int width = 388;
	public static int height = 435;

	public Window(){
		background();
		backgroundImage();
		frame.add(new ButtonStart());
		frame.add(new ButtonClose());
		frame.add(new Logotype());
		frame.add(new WriteExtensionLogo());
		frame.add(new ExLicense());
		LogArea.AddLogArea();
		
		ChooseFolderArea splace = new ChooseFolderArea();
		splace.AddChooseFolderArea();
		
		Logotype slogo = new Logotype();
		slogo.setLogo();
		
		WriteExtension sextension = new WriteExtension();
		sextension.AddExtensionArea();
		
		frame.pack();
	}
	
	public static void background(){
		frame = new JFrame("ExCleaner v1.1 by Shellai");
		frame.setSize(width, height);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(new Color(0,0,0,0));			
	}
	
	public void backgroundImage(){
		body.setIcon(new ImageIcon(getClass().getResource("/ex/cleaner/style/window.png")));
		body.setOpaque(false);
		frame.setContentPane(body);
		
		MoveWindow moving = new MoveWindow();
		body.addMouseMotionListener(moving);
	}

//[EVENTS] Drag Window//
private class MoveWindow implements MouseMotionListener{
		public void mouseDragged(MouseEvent dragger) {
		     x = dragger.getXOnScreen();
		     y = dragger.getYOnScreen();
		     frame.setLocation(x - xMouse, y - yMouse);
		}
		public void mouseMoved(MouseEvent coords) {
			xMouse = coords.getX();
			yMouse = coords.getY();
		}
	   }
	
}

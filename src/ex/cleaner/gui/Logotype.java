//////////////////////////////////////////
//(C) Powered by Shellai Developer, 2017//
//////////////////////////////////////////
package ex.cleaner.gui;

import java.awt.Font;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Logotype extends JLabel{
	private static final long serialVersionUID = 1461285413123125L;
	
	public Image logo;
	public JLabel logoimg;
	
	
	public Logotype(){
		setText("ExCleaner 1.1");
		setFont(new Font("Tahoma", Font.BOLD, 15));
		setBounds(150, 18, 105, 15);
		setHorizontalAlignment(SwingConstants.CENTER);
	}
	
	public void setLogo(){
		logoimg = new JLabel();
        logoimg.setBounds(13, 13, 25, 25);
        try {
			logo = ImageIO.read(getClass().getResource("/ex/cleaner/style/rubbish.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
        logoimg.setIcon(new ImageIcon(logo));
        Window.frame.add(logoimg);
	}
}

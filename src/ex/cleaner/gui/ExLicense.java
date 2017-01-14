//////////////////////////////////////////
//(C) Powered by Shellai Developer, 2017//
//////////////////////////////////////////
package ex.cleaner.gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ExLicense extends JLabel{
	private static final long serialVersionUID = 312314L;
	
	public ExLicense(){
		setBounds(132,415, 140, 20);
		setFont(new Font("Tahoma", Font.PLAIN, 10));
		setText("(C) Powered by Shellai, 2017");
		setHorizontalAlignment(SwingConstants.CENTER);
	}
	
}

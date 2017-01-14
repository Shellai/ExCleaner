//////////////////////////////////////////
//(C) Powered by Shellai Developer, 2017//
//////////////////////////////////////////

package ex.cleaner.gui;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class WriteExtensionLogo extends JLabel {
	private static final long serialVersionUID = 7890123L;

	
	public WriteExtensionLogo(){
		setText("Write an extension (Example: .txt)");
		setFont(new Font("Tahoma", Font.PLAIN, 20));
		setBounds(30, 265, 340, 25);
		setHorizontalAlignment(SwingConstants.CENTER);
	}
}

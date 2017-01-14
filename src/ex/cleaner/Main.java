//////////////////////////////////////////
//(C) Powered by Shellai Developer, 2017//
//////////////////////////////////////////
package ex.cleaner;

import javax.swing.SwingUtilities;
import ex.cleaner.gui.Window;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable(){
			@SuppressWarnings("static-access")
			public void run(){
				Window magic = new Window();
				magic.frame.setVisible(true);
				//System.setProperty("", "");
			}
		});
	}

}

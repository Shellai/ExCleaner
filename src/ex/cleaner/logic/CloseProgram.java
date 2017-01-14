//////////////////////////////////////////
//(C) Powered by Shellai Developer, 2017//
//////////////////////////////////////////
package ex.cleaner.logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CloseProgram implements ActionListener{
	
	@Override
	public void actionPerformed(ActionEvent press_btn) {
		System.exit(0);
	}
 }

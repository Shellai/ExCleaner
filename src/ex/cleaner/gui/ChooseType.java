package ex.cleaner.gui;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

public class ChooseType {

	public static JRadioButton selection_without, selection_with;
	
	public static void SetRadioButton(){
		selection_without = new JRadioButton("Only files");
		selection_without.setOpaque(false);
		selection_without.setFont(new Font("Tahoma", Font.PLAIN, 17));
		selection_without.setSelected(true);
		selection_without.setFocusPainted(false);
		selection_without.setBounds(32, 320, 100, 25);
		Window.frame.add(selection_without);
		
		selection_with = new JRadioButton("Files and directories");
		selection_with.setOpaque(false);
		selection_with.setFocusPainted(false);
		selection_with.setFont(new Font("Tahoma", Font.PLAIN, 17));
		selection_with.setBounds(195, 320, 180, 25);
		Window.frame.add(selection_with);
		
		ButtonGroup group = new ButtonGroup();
		group.add(selection_without);
		group.add(selection_with);
	}
	
}

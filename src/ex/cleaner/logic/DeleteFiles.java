//////////////////////////////////////////
//(C) Powered by Shellai Developer, 2017//
//////////////////////////////////////////
package ex.cleaner.logic;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JOptionPane;
import javax.swing.text.StyledDocument;

import ex.cleaner.gui.ChooseFolderArea;
import ex.cleaner.gui.LogArea;
import ex.cleaner.gui.WriteExtension;

public class DeleteFiles implements ActionListener{
	
	public static Component frame;
	public static StyledDocument text;
	public static String list;
	public static int number;
	public static double megabytes, fsize;
	
	@Override
	public void actionPerformed(ActionEvent pressed_btn) {
		
		text = LogArea.logging.getStyledDocument();
		
		LogArea.logging.setText("");
		
		String givenText = WriteExtension.extension_fld.getText();
		//System.out.println("Your extension: " + givenText); //Output extension to console
		
		if(ChooseFolderArea.choose == null){
			JOptionPane.showMessageDialog(frame,"Please, choose folder to delete files!", "Error", 1);
		} else {
			File folder = ChooseFolderArea.choose.getSelectedFile();
			File [] listOfFiles = folder.listFiles();
			if (listOfFiles.length != 0){
				for(File files : listOfFiles){
					list = files.getName();
					if (list.lastIndexOf(".") != -1 && list.lastIndexOf(".") != 0 && list.endsWith(givenText.toLowerCase()) || list.endsWith(givenText.toUpperCase())){
						//Calculating size of deleted files in new thread [START]
						Thread calcSize = new Thread(){
							public void run(){
								megabytes = files.length() / 1024 / 1024;
								fsize+=megabytes;
							}
						};
						calcSize.start();
						//Calculating size of deleted files in new thread [END]
						files.delete();
						if(!files.exists()){
							number++;
							try{
								text.insertString(0, "", null);
								text.insertString(0, "Deleted: " + list + "\n", null);
								CreateLogs.PrepareLogs();
							} catch (Exception e3){
								e3.printStackTrace();
							}
						}
					}
				}
			}
			if (number == 0){
				JOptionPane.showMessageDialog(frame,"Error occured during deleting files!", "Error", 0);
			} else {
				JOptionPane.showMessageDialog(frame,"Number of deleted files: " + number + "\nSize of deleted files: " + fsize + " Mb", "Information", 1);
			}
			number=0;
			fsize=0.0;
		}
	}
}
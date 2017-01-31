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
import ex.cleaner.gui.ChooseType;
import ex.cleaner.gui.LogArea;
import ex.cleaner.gui.WriteExtension;

public class DeleteFiles implements ActionListener{
	
	public static Component frame;
	public static StyledDocument text;
	public static String list;
	public static int number;
	public static double kilobytes, fsize;
	public static String givenText;
	public static File folder;
	public static String weight = " Kb";
	
	@Override
	public void actionPerformed(ActionEvent pressed_btn) {
		
		text = LogArea.logging.getStyledDocument();
		
		LogArea.logging.setText("");
		
		if(ChooseFolderArea.choose == null){
			JOptionPane.showMessageDialog(frame,"Please, choose folder to delete files!", "ExCleaner || [Error]", 0);
		} else {
			folder = ChooseFolderArea.choose.getSelectedFile();
			isSure();
			CreateLogs.PrepareLogs();
		}
	}

	public static void DeleteOnlyFiles(){
		givenText = WriteExtension.extension_fld.getText();
		
		if(givenText.length() >= 7){
			JOptionPane.showMessageDialog(frame,"You need to write less than 7 symbols in 'Extension' field!", "ExCleaner || [Error]", 0);
			WriteExtension.extension_fld.setText("");
		}
		
		File [] listOfFiles = folder.listFiles();
		if (listOfFiles.length != 0){
			
			for(File files : listOfFiles){
				list = files.getName();
				if (list.lastIndexOf(".") != -1 && list.lastIndexOf(".") != 0 && list.endsWith(givenText.toLowerCase()) || list.endsWith(givenText.toUpperCase())){
							kilobytes = files.length() / 1024.0;
							fsize+=kilobytes;
					
						if(!files.isDirectory()){
							files.delete();
						}
					
					if(!files.exists()){
						number++;
						try{
							text.insertString(0, "", null);
							text.insertString(0, "Deleted: " + list + "\n", null);
						} catch (Exception e3){
							e3.printStackTrace();
						}
					}
				}
			}
		}
	}
	
	public static void DeleteAll(File folder_files){
		givenText = WriteExtension.extension_fld.getText();
		
		if(givenText.length() >= 7){
			JOptionPane.showMessageDialog(frame,"You need to write less than 7 symbols in 'Extension' field!", "ExCleaner || [Error]", 0);
			WriteExtension.extension_fld.setText("");
		}
		
		File [] listOfFiles = folder_files.listFiles();
		if (listOfFiles.length != 0){
			
			for(File files : listOfFiles){
				list = files.getName();
				if (list.lastIndexOf(".") != -1 && list.lastIndexOf(".") != 0 && list.endsWith(givenText.toLowerCase()) || list.endsWith(givenText.toUpperCase())){
						if(!files.isDirectory()){
							kilobytes = files.length() / 1024.0;
							fsize+=kilobytes;
							list = files.getName();
							files.delete();
							if(!files.exists()){
								number++;
								try{
									text.insertString(0, "", null);
									text.insertString(0, "Deleted: " + list + "\n", null);
								} catch (Exception e3){
									e3.printStackTrace();
								}
							}
						} else {
							kilobytes = files.length() / 1024.0;
							fsize+=kilobytes;
							DeleteAll(files);
							list = files.getName();
							files.delete();
							if(!files.exists()){
								number++;
								try{
									text.insertString(0, "", null);
									text.insertString(0, "Deleted: " + list + "\n", null);
								} catch (Exception e3){
									e3.printStackTrace();
								}
							}
						}
				}
			}
		}
	}
	
	public static void PrintResult(){
		if (fsize>=1024.0){
			fsize /= 1024.0;
			weight = " Mb";
		}
		if (number == 0){
			JOptionPane.showMessageDialog(frame,"Error occured during deleting files!", "ExCleaner || [Error]", 0);
		} else {
			JOptionPane.showMessageDialog(frame,"Number of deleted files: " + number + "\nSize of deleted files: " + fsize + weight, "Information", 1);
		}
			number=0;
			fsize=0.0;
	}
	
	private static boolean isSure(){
		if(JOptionPane.showConfirmDialog(null, "Are you sure? \nDirectory to clear: " + folder.getName(), "Confirm action",
		        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
			if(ChooseType.selection_without.isSelected()){
				DeleteOnlyFiles();
				PrintResult();
			} else if(ChooseType.selection_with.isSelected()){
				DeleteAll(folder);
				PrintResult(); 
			}
		} else {
			return false;
		}
		return true;
	}
	
}
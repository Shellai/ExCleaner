package ex.cleaner.logic;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import ex.cleaner.gui.LogArea;

public class CreateLogs {

	public static BufferedWriter buffer;
	public static FileWriter writing;
	private static final DateFormat sdf = new SimpleDateFormat("[HH:mm:ss dd/MM/yyyy]");
	private static String givenData, takeName;
	private static String newLine = System.getProperty("line.separator");
	public static String os_name = System.getProperty("os.name").toLowerCase();
	
	public static void PrepareLogs(){
		
		try {
			if(isWindows()){
				writing = new FileWriter(System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "ExCleanerLogs.txt", true);
			} else {
				writing = new FileWriter(System.getProperty("user.home") + File.separator + "ExCleanerLogs.txt", true);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		buffer = new BufferedWriter(writing);
		takeName = LogArea.logging.getText();
		
		try {
			buffer.write(GetCurrentData() + newLine + takeName + newLine);
			//buffer.write(GetCurrentData() + " Deleted file: " + DeleteFiles.list_folders + newLine);
			buffer.flush();
			buffer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String GetCurrentData(){
		Date date = new Date();
		givenData = sdf.format(date);
        return givenData;
	}
	
	public static boolean isWindows(){
		return (os_name.lastIndexOf("win") >=0);
	}
}
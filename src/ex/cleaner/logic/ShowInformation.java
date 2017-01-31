package ex.cleaner.logic;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class ShowInformation implements ActionListener{

	public static String url1 = "https://github.com/Shellai/ExCleaner/";
	private static String url2 = "http://shellai.pw";
	
	private static JEditorPane help = new JEditorPane("text/html", "<html><font color=red face=Verdana font size=3>ExCleaner is an open-source project.</font><br>"
			+ "<font face=Verdana font size=3>&copy;Powered by <font color=#DAA520><b>SHELLAI</b></font>, 2017.<br>"
			+ "Report bugs to E-MAIL: <font color=#008000>maximmishanja123@gmail.com</font><br>"
			+ "Visit developer's profile on " + "<a href=" + url1 + ">" + "GITHUB</a> to download source files!<br>"
			+ "Visit my " + "<a href=" +url2 + ">" + "WEBSITE</a> to download updates and other programs!<br>"
			+ "<font color=red>[WEBSITE is not working now. Please, wait!]</font></font><br><br>"
			+ "<font face=Verdana font size=3><b>How to use:</b><br>"
			+ "(1)Choose folder to clean<br>"
			+ "(2)Write an extension to a field<br>"
			+ "(3)Press button '<font color=green>DELETE</font>'<br>"
			+ "(4)You'll see a list of deleted files in the window<br><br>"
			+ "[NOTE] Open a file <font color=#800000>'<b>ExCleanerLogs.txt</b>'</font> on Desktop(Windows)<br>"
			+ "or inside USER-home directory(Other OS) to see a list of deleted<br>"
			+ "objects for all time.</font></html>");
	
	@Override
	public void actionPerformed(ActionEvent e) {
		help.addHyperlinkListener(new HyperlinkListener() {
            @Override
            public void hyperlinkUpdate(HyperlinkEvent e) {
                if (e.getEventType().equals(HyperlinkEvent.EventType.ACTIVATED)) {
                	if(Desktop.isDesktopSupported()) {
                	    try {
							Desktop.getDesktop().browse(e.getURL().toURI());
						} catch (IOException | URISyntaxException e1) {
							e1.printStackTrace();
						}
                	}
                }
            }
        });
		help.setEditable(false);
		JOptionPane.showMessageDialog(DeleteFiles.frame, help, "About project and how to use", 1);

	}

}

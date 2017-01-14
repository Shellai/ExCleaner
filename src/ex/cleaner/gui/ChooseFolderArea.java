//////////////////////////////////////////
//(C) Powered by Shellai Developer, 2017//
//////////////////////////////////////////
package ex.cleaner.gui;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class ChooseFolderArea {
	public static JFileChooser choose;
	JButton choose_btn;
	JTextPane output_fld;
	
	public Image choose_btn_image, output_choosed_image;
	
	public void AddChooseFolderArea(){
		
		try {
			choose_btn_image = ImageIO.read(getClass().getResource("/ex/cleaner/style/chooser.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			output_choosed_image = ImageIO.read(getClass().getResource("/ex/cleaner/style/Output_btn.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		choose_btn = new JButton(){			
			private static final long serialVersionUID = 184124123L;

			@Override
			protected void paintComponent(Graphics chooseimage){
				chooseimage.drawImage(choose_btn_image, 0, 0, this);
				super.paintComponent(chooseimage);
			}
		};
		
		choose_btn.setBounds(32, 162, 338, 45);
		choose_btn.setOpaque(false);
		choose_btn.setFocusPainted(false);
		choose_btn.setBorderPainted(false);
		choose_btn.setContentAreaFilled(false);
		choose_btn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		choose_btn.setText("Choose folder");
		choose_btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		ListenFolder event1 = new ListenFolder();
		choose_btn.addActionListener(event1);
		
		output_fld = new JTextPane(){
			private static final long serialVersionUID = 2352321L;

			@Override
			protected void paintComponent(Graphics outputimage){
				outputimage.drawImage(output_choosed_image, 0, 0, this);
				super.paintComponent(outputimage);
			}
		};
		output_fld.setOpaque(false);
		output_fld.setBounds(32, 220, 338, 25);
		output_fld.setEditable(false);
		SimpleAttributeSet attributes3 = new SimpleAttributeSet();
		StyleConstants.setAlignment(attributes3 , StyleConstants.ALIGN_CENTER);
		output_fld.setParagraphAttributes(attributes3,true);
        output_fld.setText("Please, choose folder!");
        
	    Window.frame.add(choose_btn);
	    Window.frame.add(output_fld);
	}
	
	
	
	
	
private class ListenFolder implements ActionListener{
		public void actionPerformed(ActionEvent folders){
			choose = new JFileChooser();
			choose.setDialogTitle("Choosing Folder");
			choose.setAcceptAllFileFilterUsed(false);
			choose.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		    if(choose.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		        output_fld.setText("Your directory: " + choose.getSelectedFile().getName());
		        }
		     }
		}
}
	


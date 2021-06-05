package view.components.jtable;

import java.awt.Component;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class TableCellRemoveImageRenderer extends JButton implements TableCellRenderer {
	
	private static final long serialVersionUID = 1L;
	
	private String pathImage;
	private int width;
	private int height;
	
	public TableCellRemoveImageRenderer(int width, int height) {
		
		this.pathImage = "resources/images/iconRemove.png";
		this.width = width;
		this.height = height;
		setHorizontalAlignment(JLabel.CENTER);
		setVerticalAlignment(JLabel.CENTER);
		
		
	}
	
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		ImageIcon imagem = new ImageIcon(pathImage);
		Image image = imagem.getImage();
		Image newImage = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH);  
		imagem = new ImageIcon(newImage);
		
	     if(isSelected)
	       setBackground(table.getSelectionBackground());
	     else
	       setBackground(table.getBackground());		
	     
	     setIcon(imagem);

	     if(value != null) {
	    	 setText(value.toString());
	     }
	     	
	     return this; 
		
	}

	
	
}

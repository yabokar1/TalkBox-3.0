package components.button_panel;

import java.util.ArrayList;

import io.FileLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;

public class ButtonMenu {

	ContextMenu cm;
	
	MenuItem LoadImage;
	
	MenuItem Rename;

	
	
	
	public ButtonMenu() {
		
		cm = new ContextMenu();
		
		LoadImage = new MenuItem("Load Image");
		
		Rename = new MenuItem("Rename");
		
		cm.getItems().addAll(LoadImage,Rename);
		
	}
	
	
	public void setButtonImage(Button b) {
		
// Profile List.	
//		 list.ImageSet.get(row).add(image.file.toURI().toString());
//         
//		 list.RenameSet.get(row).add(null);
			
			 b.setId("image");
			
			 FileLoader image = new FileLoader();
             
			 image.open("Images/");
             
			 Image pic = new Image(image.file.toURI().toString());  

			BackgroundImage bImage = new BackgroundImage(pic, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, new BackgroundSize(b.getWidth(), b.getHeight(), true, true, true, false));

		    Background backGround = new Background(bImage);
		    
		    b.setBackground(backGround);
         

}
	

	
	
	
	public void rename(Button b,String newName) {
	  
		b.setText(newName);
		
//		Profile list.	
//		list.RenameSet.get(row).add(newName);
//		list.ImageSet.get(row).add(null);
	}
}



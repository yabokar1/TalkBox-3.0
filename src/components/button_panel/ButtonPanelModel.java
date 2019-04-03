package components.button_panel;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;

import audio_players.AudioClipWav;
import io.ImportFiles;
import io.TalkBoxLogger;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class ButtonPanelModel  implements Observer, ChangeListener{
	
	
		private int currentRow = 0;
		
		private int currentCol = 0;
		
		private int buttonCount = 0;
		
		
		public static final int MAX_COL = 6;
		
		private ButtonPanelView receiver;

		
		
		
		
		
		@Override
		public void update(Observable o, Object arg) {
			
			String buttonName = (String) arg;
	
			
			System.out.println("Button name = " + buttonName);
			
			
			addButton(buttonName);
			
			this.receiver.addNewButton(buttonName);
			
			
		}
		
		
		
		// The view gets injected here.
		
		public void addSubscriber(ButtonPanelView receiver) {
			
			this.receiver = receiver;
			
		}
		


		public void resetRow() {
			
			this.currentRow = 0;
		}
		
		
		public int getCurrentRow() {
			
			return this.currentRow;
		}
		
		
		public void resetColumn() {
			
			this.currentCol = 0;
		}
		
		
		public int getCurrentCol() {
			
			return this.currentCol;
		}
		

		public void addButton(String name) {
			

		   currentCol++;
		   
		   if(currentCol > MAX_COL) {
			 
			   currentCol = 0;
			 
			   currentRow++;
		   }
		   
		   this.buttonCount++;
			
		}
		
		
		

		public int getButtonCount() {
			
			return this.buttonCount;
		}


		@Override
		public void changed(ObservableValue observable, Object oldValue, Object newValue) {

				
	
		}



		public int getCol() {
			
			return this.getButtonCount() % MAX_COL;
			
		}



		public int getRow() {
	
			return this.getButtonCount()  / MAX_COL;
		}



	
		

	
	


}
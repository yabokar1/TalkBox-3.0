package components.button_panel;

import java.util.Observable;
import java.util.Observer;
import audio_players.AudioClipWav;
import io.TalkBoxLogger;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class ButtonPanelView extends GridPane  {
	
	

		
		private static final int BTN_WIDTH = 90;
		
		private static final int BTN_HEIGHT = 90;
		
		public String newname;
		
		
		private ButtonPanelModel model;
		
		
		
		public ButtonPanelView(ButtonPanelModel model) {
			
			this.model = model;
		}


		public void addNewButton(String name) {
			 

				
				
				Button button = new Button(name);
			   
			   button.setMinSize(BTN_WIDTH, BTN_HEIGHT);
			   
			   button.setMaxSize(BTN_WIDTH, BTN_HEIGHT);
			   
			   ButtonPanelView.setHgrow(button, Priority.ALWAYS);
			   
			   ButtonPanelView.setHgrow(button, Priority.ALWAYS);
			   
			   this.setVgap(20);
			   
			   button.setPadding(new Insets(10,10,10,10));

			   this.add(button, this.model.getCol() , this.model.getRow());
			 
		}


	


		private void attachClickListener(String name, Button b) {
			
			
//			b.setOnMouseClicked(new EventHandler<MouseEvent>() {
//				
//			private AudioClipWav clip = null;
//	           
//			
//			@Override
//	        public void handle(MouseEvent event) {
//	
//	               
//	            	TalkBoxLogger.logMousePressEvent(event);
//	            	
//	            	MouseButton button = event.getButton();
//	               
//	                if(button == MouseButton.PRIMARY) {
//	                	
//	                	try {
//	                		
//	                    	clip = new AudioClipWav(name);
//	                	}
//	                	catch(Exception e) {
//	                		
//	                		e.printStackTrace();
//	                	}	
//						
//	        
//						
//						clip.play();
//	                }
//	                else if(button==MouseButton.SECONDARY){
//	                	
//	                	rightClick(event,b);
//	      
//	                }
//	                
//				
//				} // fn end.
//			
//			} // class end
//			 
//					);
//			
//		
	
		}

		
		public void rightClick(MouseEvent event,Button button) {
			
			
//            ContextMenuClass right = new ContextMenuClass(button,list,newName(),list.getRow());
//            
//            right.cm.show(button, event.getScreenX(), event.getScreenY());
//            
//            right.LoadImage.setOnAction(e ->{
//       			
//            right.attachImageAdder(button, list, list.getRow());
//                
//            System.out.println(list.ImageSet);
//                
//            System.out.println(list.RenameSet);
//       		});
//            right.Rename.setOnAction(e ->{
//            right.rename(button, newName(), list, list.getRow());
//            System.out.println(list.ImageSet);
//              System.out.println(list.RenameSet);
//            	});
//			
//			
			
		}





	
		

	


}
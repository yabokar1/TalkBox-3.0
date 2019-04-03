package components.button_panel;

import java.util.Optional;

import audio_players.AudioClipWav;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class ButtonPanelView extends GridPane  {
	
	

		
		private static final int BTN_WIDTH = 90;
		
		private static final int BTN_HEIGHT = 90;
		
		public String newname;
		
		
		// stores a reference to the model
		// which keeps track of the number of 
		// buttons as well as the number of 
		// columns and rows.
		private ButtonPanelModel model;
		
		private ButtonMenu btnMenu;
		
		
		
		
		
		public ButtonPanelView(ButtonPanelModel model, ButtonMenu btnMenu) {
			
			this.model = model;
			
			this.btnMenu = btnMenu;
		}

		
		
		

		
		/**
		 * Adds a new button to this view.
		 */
		public void addNewButton(String name) {
			 

			   Button button = new Button(name);
			   
			   button.setUserData(name); // stores the file name (so the button name can change if needed, but the actual file name stays the same.)
			   
			   setButtonLook(button);
			   
			   attachClickListener(button);
			    
			   this.add(button, this.model.getCol() , this.model.getRow());
			 
		}

		
		
		
		
		/**
		 *  Sets up the look of the button.
		 * @param button
		 */
		private void setButtonLook(Button button) {
			
			
		   button.setMinSize(BTN_WIDTH, BTN_HEIGHT);
			   
		   button.setMaxSize(BTN_WIDTH, BTN_HEIGHT);
		   
		   ButtonPanelView.setHgrow(button, Priority.ALWAYS);
		   
		   
		   ButtonPanelView.setVgrow(button, Priority.ALWAYS);
		   
		   this.setVgap(20);
		   
		   button.setPadding(new Insets(10,10,10,10));
		}


	

		/**
		 *  Attaches a listener that dictates what happens when the button 
		 *  is pressed.
		 *  
		 * @param b
		 */
		private void attachClickListener(Button b) {
			
	
			ButtonMenu menu = this.btnMenu;
						
			b.setOnMouseClicked(new EventHandler<MouseEvent>() {
				
			private AudioClipWav clip = null;
			

				@Override
		        public void handle(MouseEvent event) {

					MouseButton button = event.getButton();
	            	handleLeftClick(button);
	            	handleRightClick(event);

				
				} // fn end.
			
				
				/**
				 *  Handles what happens when the
				 *  left button is clicked.
				 */
				private void handleLeftClick(MouseButton button) {
					
					
				    
				    if(button == MouseButton.PRIMARY) {
				    	
				    	try {
				    		
				    		String fileName = (String) b.getUserData();
				    		
				        	clip = new AudioClipWav(fileName);
				        	
				        	clip.play();
				    	}
				    	catch(Exception e) {
				    		
				    		e.printStackTrace();
				    	}	
				
				    }
				}
				
				
				
				
				
				/**
				 *  Handles what happens when the right button 
				 *  is clicked.
	
				 */
				private void handleRightClick(MouseEvent event){
					
					MouseButton mouseBtn = event.getButton();
						
	            	if(mouseBtn == MouseButton.SECONDARY){
	
		                	
		                    menu.cm.show(b, event.getScreenX(), event.getScreenY());
		    
		                    
		                    menu.LoadImage.setOnAction(e ->{
		               			
		                    	menu.setButtonImage(b);

		               		});
		                    
		                    
		                    menu.Rename.setOnAction(e -> {
		                    
		   
		                        TextInputDialog td = new TextInputDialog("Enter the new name for this button."); 
		                  
		  
		                        td.setHeaderText("Button Rename."); 
		    
		                        
		                        Optional<String> result = td.showAndWait();

		                        
		                        menu.rename(b, result.get());
		                       
		
		                    });
		        			
		      
		                }
				}
				
				
				
				
				
				
				
				
			
			} // class end
			
			

			 
		);
			
		
	
		}
		
		
		
		
		
		
		


		
		
		





	
		

	


}
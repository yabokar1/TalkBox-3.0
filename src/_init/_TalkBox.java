package _init;


import java.io.File;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;


import components.audio_list.AudioSampleList;
import components.audio_list.AudioSampleListView;
import components.button_panel.ButtonPanelModel;
import components.button_panel.ButtonPanelView;
import components.root.RootView;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import io.TalkBoxLogger;
import constants.Names;

// Inherits from Application 
public class _TalkBox extends Application {
	
	
	
	private Model model;
	
   	
	public static void main(String[] args) {
       
		launch(args);
		
    }

	
	
	
	
	
	
    @Override
    public void start(Stage primaryStage) throws IOException {
        

    	
    	primaryStage.setTitle(Names.TITLE);
        
    	Parent view = makeView();

        Scene scene = new Scene(view, Names.SCENE_WIDTH, Names.SCENE_HEIGHT);
        
        primaryStage.setScene(scene);
        
        primaryStage.show();
       

    }
    
    
    
    
    
    
    
    
    private Parent makeView() {
    	
        RootView root = new RootView();
        
        List<Observer> audioSampleObservers = new LinkedList<Observer>();  
        
        ButtonPanelModel buttonModel = new ButtonPanelModel();
        
        
        ButtonPanelView buttonView = new ButtonPanelView(buttonModel);
        
        buttonModel.addSubscriber(buttonView);
        
        
        ScrollPane scrollBtnView = createScroll(buttonView);
        
        root.getChildren().add(scrollBtnView);
        

        
        
        
        // list part.
        audioSampleObservers.add(buttonModel);
                
        AudioSampleList sampleModel = AudioSampleList.createAudioList(audioSampleObservers);
        
        AudioSampleListView audioSamplesView = new AudioSampleListView(sampleModel);
        
       
        
        root.getChildren().add(audioSamplesView.getList());
      
        return root;
    }
    
    
    
    
    
    private ScrollPane createScroll(ButtonPanelView buttonpanel) {
    	
  	   ScrollPane scrollpane = new ScrollPane();
		  
	   buttonpanel.setHgap(10);
	   
	   buttonpanel.setVgap(5);
	   
	   scrollpane.setContent(buttonpanel);
	   
	   scrollpane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER); // size of the scroll bar
	   
	   scrollpane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);
	   
	   scrollpane.setMinSize(800, 300);
	  
	   scrollpane.setMaxSize(800, 300);
	  
	   return scrollpane;
    }
    
    
    
    
    
//	
//	public VBox audioAndSetPanel( ButtonPanel panel,ProfileList profile) throws FileNotFoundException { //Right side of the Gui
//		VBox section2 = new VBox();
//		section2.getChildren().add(new Label("Profiles"));
//		section2.getChildren().add(profile.getTree());
//		section2.getChildren().add(this.button.enterProfileTextField(profile,panel));
//		section2.getChildren().add(new Label("Audio"));
//		section2.getChildren().add(this.AudioSample(panel,profile).getList());
//		section2.getChildren().add(this.button.addRecordArea(this.sampleList));
//		return section2;
//		
//		
//	}
//    
    
    

    
    


    
    


    
    
    




 

}
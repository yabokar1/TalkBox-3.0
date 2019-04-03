package components.audio_list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import io.AudioFileIO;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import java.util.Observable;
import java.util.Observer;

public class AudioSampleList extends Observable implements ChangeListener {
	
	
	
	
	private List<String> list;
	
	
	
	
	// Factory method.
    public static AudioSampleList createAudioList(List<Observer> observers) {
    	 
    	AudioSampleList samples = new AudioSampleList();
    
    	
    	attachObservers(observers, samples);
	    	
	     
	 	samples.loadFromDisk();
        
 	    
 	    return samples;
    }





	private static void attachObservers(List<Observer> observers, AudioSampleList samples) {
		
		if(observers != null) {
    
    	
	    	for(int i = 0; i < observers.size(); i++) {
	    		
	    		samples.addObserver(observers.get(i));
	    	}
	    	
      	}
	}


	
	

	private AudioSampleList() {
	
		
		list = new ArrayList<String>();
	}
	
	
	
	public int getSampleCount() {
		
		
		return this.list.size();
		
	}

	
	
	private void loadFromDisk() {


		try {

			this.list = AudioFileIO.getAudioNames();

			

		} catch (Exception e) {
		
			e.printStackTrace();
		}
	}
	

	
	

	
	
	
	
	public List<String> getAll(){
		
		return this.list;
	}





	@Override
	public void changed(ObservableValue observable, Object oldValue, Object newValue) {
		
		
		setChanged();
		
		
		notifyObservers(newValue.toString());
	}

	


	


}

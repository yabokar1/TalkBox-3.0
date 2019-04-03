package components.audio_sample_list;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import org.junit.jupiter.api.Test;

import _init._TalkBox;
import components.audio_list.AudioSampleList;
import components.button_panel.ButtonPanelModel;

class AudioSampleListTest {
	
	
	
	@Test
	void makeAudioListTest() {

    	
    	Observer o = new ButtonPanelModel();
    	
    	List<Observer> list = new LinkedList<Observer>();
    	
    	list.add(o);
		
    	Observable audioList = AudioSampleList.createAudioList(list);
    		
    	
    	assertEquals(1, audioList.countObservers());
	}

	
	

	@Test
	public void loadFromDiskTest(){
		
		
		AudioSampleList list =  AudioSampleList.createAudioList(null);
		
		assertEquals(2,list.getSampleCount());
		
	}
	

}

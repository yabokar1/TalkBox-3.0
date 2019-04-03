package audio_players;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import audio_players.AudioClip;
import javafx.event.ActionEvent;



class AudioClipTest {
	

	
	@Test
	void testAudioClipStartsSuccessfully() throws Exception {
		
		AudioClip  clip = new AudioClip("boring.wav");
		
		clip.play();
		
		assertTrue(clip.isConnecting());
	}
	
	
	
	

	
	
	
	


}
